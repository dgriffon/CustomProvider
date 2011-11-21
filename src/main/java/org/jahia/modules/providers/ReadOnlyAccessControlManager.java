/**
 *
 * This file is part of Jahia: An integrated WCM, DMS and Portal Solution
 * Copyright (C) 2002-2009 Jahia Limited. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * As a special exception to the terms and conditions of version 2.0 of
 * the GPL (or any later version), you may redistribute this Program in connection
 * with Free/Libre and Open Source Software ("FLOSS") applications as described
 * in Jahia's FLOSS exception. You should have recieved a copy of the text
 * describing the FLOSS exception, and it is also available here:
 * http://www.jahia.com/license"
 *
 * Commercial and Supported Versions of the program
 * Alternatively, commercial and supported versions of the program may be used
 * in accordance with the terms contained in a separate written agreement
 * between you and Jahia Limited. If you are unsure which license is appropriate
 * for your use, please contact the sales department at sales@jahia.com.
 */
package org.jahia.modules.providers;

import org.apache.commons.lang.ArrayUtils;
import org.apache.jackrabbit.commons.iterator.AccessControlPolicyIteratorAdapter;
import org.apache.jackrabbit.core.security.JahiaPrivilegeRegistry;
import org.apache.log4j.Logger;
import org.jahia.exceptions.JahiaRuntimeException;
import org.jahia.services.content.JCRSessionFactory;

import javax.jcr.AccessDeniedException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.lock.LockException;
import javax.jcr.security.*;
import javax.jcr.version.VersionException;
import java.util.HashMap;
import java.util.Map;

import static javax.jcr.security.Privilege.*;
import static org.jahia.api.Constants.EDIT_WORKSPACE;
import static org.jahia.api.Constants.LIVE_WORKSPACE;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rincevent
 * @since : JAHIA 6.1
 *        Created : 11/21/11
 */
public class ReadOnlyAccessControlManager implements AccessControlManager {
    private transient static Logger logger = Logger.getLogger(ReadOnlyAccessControlManager.class);

    private static final AccessControlPolicy[] POLICIES = new AccessControlPolicy[0];

    private Privilege[] registeredPrivileges;

    private Privilege[] rootNodePrivileges;

    private Privilege[] privileges;

    private Map<String, Privilege> registeredPrivilegeMap;

    public ReadOnlyAccessControlManager() {
        super();
        try {
            init();
        } catch (RepositoryException e) {
            throw new JahiaRuntimeException(e);
        }
    }

    private void init() throws RepositoryException {
        JahiaPrivilegeRegistry registry = new JahiaPrivilegeRegistry(JCRSessionFactory.getInstance().getNamespaceRegistry());
        registeredPrivileges = registry.getRegisteredPrivileges();
        registeredPrivilegeMap = new HashMap<String, Privilege>();
        for (Privilege priv : registeredPrivileges) {
            registeredPrivilegeMap.put(priv.getName(), priv);
        }
            rootNodePrivileges = new Privilege[] {
                    privilegeFromName(JCR_READ + "_" + EDIT_WORKSPACE), privilegeFromName(JCR_READ + "_" + LIVE_WORKSPACE),
                    };
            privileges = rootNodePrivileges;

    }

    /**
     * Returns the privileges supported for absolute path <code>absPath</code>,
     * which must be an existing node.
     * <p/>
     * This method does not return the privileges held by the session. Instead,
     * it returns the privileges that the repository supports.
     *
     * @param absPath an absolute path.
     * @return an array of <code>Privilege</code>s.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public Privilege[] getSupportedPrivileges(String absPath) throws PathNotFoundException, RepositoryException {
        return registeredPrivileges;
    }

    /**
     * Returns the privilege with the specified <code>privilegeName</code>.
     * Since the privilege name is a JCR name, it may be passed in either
     * qualified or expanded form (see specification for details on JCR names).
     *
     * @param privilegeName the name of an existing privilege.
     * @return the <code>Privilege</code> with the specified
     *         <code>privilegeName</code>.
     * @throws javax.jcr.security.AccessControlException
     *                                       if no privilege with the specified name
     *                                       exists.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public Privilege privilegeFromName(String privilegeName) throws AccessControlException, RepositoryException {
        return registeredPrivilegeMap.get(privilegeName);
    }

    /**
     * Returns whether the session has the specified privileges for absolute
     * path <code>absPath</code>, which must be an existing node.
     * <p/>
     * Testing an aggregate privilege is equivalent to testing each non
     * aggregate privilege among the set returned by calling
     * <code>Privilege.getAggregatePrivileges()</code> for that privilege.
     * <p/>
     * The results reported by the this method reflect the net <i>effect</i> of
     * the currently applied control mechanisms. It does not reflect unsaved
     * access control policies or unsaved access control entries. Changes to
     * access control status caused by these mechanisms only take effect on
     * <code>Session.save()</code> and are only then reflected in the results of
     * the privilege test methods.
     *
     * @param absPath    an absolute path.
     * @param privileges an array of <code>Privilege</code>s.
     * @return <code>true</code> if the session has the specified privileges;
     *         <code>false</code> otherwise.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficent access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public boolean hasPrivileges(String absPath, Privilege[] privileges)
            throws PathNotFoundException, RepositoryException {
        if (privileges == null || privileges.length == 0) {
            return true;
        }
        boolean allowed = true;
        Privilege[] granted = getPrivileges(absPath);
        for (Privilege toCheck : privileges) {
            if (toCheck != null && !ArrayUtils.contains(granted, toCheck)) {
                allowed = false;
                break;
            }
        }

        return allowed;
    }

    /**
     * Returns the privileges the session has for absolute path absPath, which
     * must be an existing node.
     * <p/>
     * The returned privileges are those for which {@link #hasPrivileges} would
     * return <code>true</code>.
     * <p/>
     * The results reported by the this method reflect the net <i>effect</i> of
     * the currently applied control mechanisms. It does not reflect unsaved
     * access control policies or unsaved access control entries. Changes to
     * access control status caused by these mechanisms only take effect on
     * <code>Session.save()</code> and are only then reflected in the results of
     * the privilege test methods.
     *
     * @param absPath an absolute path.
     * @return an array of <code>Privilege</code>s.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public Privilege[] getPrivileges(String absPath) throws PathNotFoundException, RepositoryException {
        return absPath.length() == 1 && "/".equals(absPath) ? rootNodePrivileges : privileges;
    }

    /**
     * Returns the <code>AccessControlPolicy</code> objects that have been set
     * to the node at <code>absPath</code> or an empty array if no policy has
     * been set. This method reflects the binding state, including transient
     * policy modifications.
     * <p/>
     * Use {@link #getEffectivePolicies(String)} in order to determine the
     * policy that effectively applies at <code>absPath</code>.
     *
     * @param absPath an absolute path.
     * @return an array of <code>AccessControlPolicy</code> objects or an empty
     *         array if no policy has been set.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.AccessDeniedException
     *                                       if the session lacks
     *                                       <code>READ_ACCESS_CONTROL</code> privilege for the <code>absPath</code>
     *                                       node.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public AccessControlPolicy[] getPolicies(String absPath)
            throws PathNotFoundException, AccessDeniedException, RepositoryException {
        return POLICIES;
    }

    /**
     * Returns the <code>AccessControlPolicy</code> objects that currently are
     * in effect at the node at <code>absPath</code>. This may be policies set
     * through this API or some implementation specific (default) policies.
     *
     * @param absPath an absolute path.
     * @return an array of <code>AccessControlPolicy</code> objects.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.AccessDeniedException
     *                                       if the session lacks
     *                                       <code>READ_ACCESS_CONTROL</code> privilege for the <code>absPath</code>
     *                                       node.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public AccessControlPolicy[] getEffectivePolicies(String absPath)
            throws PathNotFoundException, AccessDeniedException, RepositoryException {
        return POLICIES;
    }

    /**
     * Returns the access control policies that are capable of being applied to
     * the node at <code>absPath</code>.
     *
     * @param absPath an absolute path.
     * @return an <code>AccessControlPolicyIterator</code> over the applicable
     *         access control policies or an empty iterator if no policies are
     *         applicable.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.AccessDeniedException
     *                                       if the session lacks
     *                                       <code>READ_ACCESS_CONTROL</code> privilege for the <code>absPath</code>
     *                                       node.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public AccessControlPolicyIterator getApplicablePolicies(String absPath)
            throws PathNotFoundException, AccessDeniedException, RepositoryException {
        return AccessControlPolicyIteratorAdapter.EMPTY;
    }

    /**
     * Binds the <code>policy</code> to the node at <code>absPath</code>.
     * <p/>
     * The behavior of the call <code>acm.setPolicy(absPath, policy)</code>
     * differs depending on how the <code>policy</code> object was originally
     * acquired.
     * <p/>
     * If <code>policy</code> was acquired through {@link #getApplicablePolicies
     * acm.getApplicablePolicies(absPath)} then that <code>policy</code> object
     * is <i>added</i> to the node at <code>absPath</code>.
     * <p/>
     * On the other hand, if <code>policy</code> was acquired through {@link
     * #getPolicies acm.getPolicies(absPath)} then that <code>policy</code>
     * object (usually after being altered) replaces its former version on the
     * node at <code>absPath</code>.
     * <p/>
     * This is session-write method and therefore the access control policy is
     * only dispatched on <code>save</code> and will only take effect upon
     * persist.
     * <p/>
     * A <code>VersionException</code> will be thrown either immediately, on
     * dispatch or on persists, if the node at <code>absPath</code> is read-only
     * due to a checked-in node. Implementations may differ on when this
     * validation is performed.
     * <p/>
     * A <code>LockException</code> will be thrown either immediately, on
     * dispatch or on persists, if a lock prevents the operation.
     * Implementations may differ on when this validation is performed.
     *
     * @param absPath an absolute path.
     * @param policy  the <code>AccessControlPolicy</code> to be applied.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.security.AccessControlException
     *                                       if the policy is not applicable.
     * @throws javax.jcr.AccessDeniedException
     *                                       if the session lacks
     *                                       <code>MODIFY_ACCESS_CONTROL</code> privilege for the <code>absPath</code>
     *                                       node.
     * @throws javax.jcr.lock.LockException  if a lock applies at the node at
     *                                       <code>absPath</code> and this implementation performs this validation
     *                                       immediately.
     * @throws javax.jcr.version.VersionException
     *                                       if the node at <code>absPath</code> is read-only
     *                                       due to a checked-in node and this implementation performs this validation
     *                                       immediately.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public void setPolicy(String absPath, AccessControlPolicy policy)
            throws PathNotFoundException, AccessControlException, AccessDeniedException, LockException, VersionException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Removes the specified <code>AccessControlPolicy</code> from the node at
     * <code>absPath</code>.
     * <p/>
     * An <code>AccessControlPolicy</code> can only be removed if it was bound
     * to the specified node through this API before. The effect of the removal
     * only takes place upon <code>Session.save()</code>. Note, that an
     * implementation default or any other effective <code>AccessControlPolicy</code>
     * that has not been applied to the node before may never be removed using
     * this method.
     * <p/>
     * A <code>PathNotFoundException</code> is thrown if no node at
     * <code>absPath</code> exists or the session does not have privilege to
     * retrieve the node.
     * <p/>
     * An <code>AccessControlException</code> is thrown if the policy to remove
     * does not exist at the node at <code>absPath</code>.
     * <p/>
     * An <code>AccessDeniedException</code> is thrown if the session lacks
     * <code>MODIFY_ACCESS_CONTROL</code> privilege for the <code>absPath</code>
     * node.
     * <p/>
     * An <code>LockException</code> is thrown either immediately, on dispatch
     * or on persists, if the node at <code>absPath</code> is locked.
     * Implementations may differ on when this validation is performed.
     * <p/>
     * An <code>VersionException</code> is thrown either immediately, on
     * dispatch or on persists, if the node at <code>absPath</code> is read-only
     * due to a checked-in node.Implementations may differ on when this
     * validation is performed.
     * <p/>
     * A <code>RepositoryException</code> is thrown if another error occurs.
     *
     * @param absPath an absolute path.
     * @param policy  the policy to be removed.
     * @throws javax.jcr.PathNotFoundException
     *                                       if no node at <code>absPath</code> exists
     *                                       or the session does not have sufficient access to retrieve a node at that
     *                                       location.
     * @throws javax.jcr.security.AccessControlException
     *                                       if no policy exists.
     * @throws javax.jcr.AccessDeniedException
     *                                       if the session lacks
     *                                       <code>MODIFY_ACCESS_CONTROL</code> privilege for the <code>absPath</code>
     *                                       node.
     * @throws javax.jcr.lock.LockException  if a lock applies at the node at
     *                                       <code>absPath</code> and this implementation performs this validation
     *                                       immediately instead of waiting until <code>save</code>.
     * @throws javax.jcr.version.VersionException
     *                                       if the node at <code>absPath</code> is
     *                                       versionable and checked-in or is non-versionable but its nearest
     *                                       versionable ancestor is checked-in and this implementation performs this
     *                                       validation immediately instead of waiting until <code>save</code>.
     * @throws javax.jcr.RepositoryException if another error occurs.
     */
    public void removePolicy(String absPath, AccessControlPolicy policy)
            throws PathNotFoundException, AccessControlException, AccessDeniedException, LockException, VersionException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

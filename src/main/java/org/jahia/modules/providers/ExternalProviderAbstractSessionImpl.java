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

import org.apache.log4j.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.retention.RetentionManager;
import javax.jcr.security.AccessControlManager;
import javax.jcr.version.VersionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessControlException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : rincevent
 * @since : JAHIA 6.1
 *        Created : 11/21/11
 */
public abstract class ExternalProviderAbstractSessionImpl implements Session {
    private transient static Logger logger = Logger.getLogger(ExternalProviderAbstractSessionImpl.class);

    public abstract Repository getRepository();

    public String getUserID() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String[] getAttributeNames() {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object getAttribute(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public abstract Workspace getWorkspace();

    public abstract Node getRootNode() throws RepositoryException;

    public Session impersonate(Credentials credentials) throws LoginException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node getNodeByUUID(String uuid) throws ItemNotFoundException, RepositoryException {
        return getNodeByIdentifier(uuid);
    }

    public abstract Node getNodeByIdentifier(String id) throws ItemNotFoundException, RepositoryException;

    public abstract Item getItem(String absPath) throws PathNotFoundException, RepositoryException;

    public Node getNode(String absPath) throws PathNotFoundException, RepositoryException {
        return (Node) getItem(absPath);
    }

    public Property getProperty(String absPath) throws PathNotFoundException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean itemExists(String absPath) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean nodeExists(String absPath) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean propertyExists(String absPath) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void move(String srcAbsPath, String destAbsPath) throws ItemExistsException, PathNotFoundException, VersionException, ConstraintViolationException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeItem(String absPath) throws VersionException, LockException, ConstraintViolationException, AccessDeniedException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void save() throws AccessDeniedException, ItemExistsException, ReferentialIntegrityException, ConstraintViolationException, InvalidItemStateException, VersionException, LockException, NoSuchNodeTypeException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void refresh(boolean keepChanges) throws RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasPendingChanges() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ValueFactory getValueFactory() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasPermission(String absPath, String actions) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void checkPermission(String absPath, String actions) throws AccessControlException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasCapability(String methodName, Object target, Object[] arguments) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ContentHandler getImportContentHandler(String parentAbsPath, int uuidBehavior) throws PathNotFoundException, ConstraintViolationException, VersionException, LockException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void importXML(String parentAbsPath, InputStream in, int uuidBehavior) throws IOException, PathNotFoundException, ItemExistsException, ConstraintViolationException, VersionException, InvalidSerializedDataException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void exportSystemView(String absPath, ContentHandler contentHandler, boolean skipBinary, boolean noRecurse) throws PathNotFoundException, SAXException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void exportSystemView(String absPath, OutputStream out, boolean skipBinary, boolean noRecurse) throws IOException, PathNotFoundException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void exportDocumentView(String absPath, ContentHandler contentHandler, boolean skipBinary, boolean noRecurse) throws PathNotFoundException, SAXException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void exportDocumentView(String absPath, OutputStream out, boolean skipBinary, boolean noRecurse) throws IOException, PathNotFoundException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setNamespacePrefix(String prefix, String uri) throws NamespaceException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String[] getNamespacePrefixes() throws RepositoryException {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getNamespaceURI(String prefix) throws NamespaceException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getNamespacePrefix(String uri) throws NamespaceException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public abstract void logout();

    public boolean isLive() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addLockToken(String lt) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String[] getLockTokens() {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeLockToken(String lt) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public AccessControlManager getAccessControlManager() throws UnsupportedRepositoryOperationException, RepositoryException {
        return new ReadOnlyAccessControlManager();
    }

    public RetentionManager getRetentionManager() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

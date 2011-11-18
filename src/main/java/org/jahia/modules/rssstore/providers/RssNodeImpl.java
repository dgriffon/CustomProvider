package org.jahia.modules.rssstore.providers;

import org.jahia.modules.rssstore.camel.RssBean;
import org.jahia.services.content.NodeIteratorImpl;
import org.jahia.services.content.impl.vfs.PropertyIteratorImpl;
import org.jahia.services.content.nodetypes.NodeTypeRegistry;

import javax.jcr.*;
import javax.jcr.lock.Lock;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;
import javax.jcr.version.ActivityViolationException;
import javax.jcr.version.Version;
import javax.jcr.version.VersionException;
import javax.jcr.version.VersionHistory;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 10/11/11
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class RssNodeImpl extends RssItemImpl implements Node {
    private RssSessionImpl session;
    private RssBean rssBean;

    public RssNodeImpl(RssSessionImpl session) {
        this.session = session;
    }

    public RssNodeImpl(RssSessionImpl session, RssBean rssBean) {
        this.session = session;
        this.rssBean = rssBean;
    }

    public Node addNode(String relPath) throws ItemExistsException, PathNotFoundException, VersionException, ConstraintViolationException, LockException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node addNode(String relPath, String primaryNodeTypeName) throws ItemExistsException, PathNotFoundException, NoSuchNodeTypeException, LockException, VersionException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void orderBefore(String srcChildRelPath, String destChildRelPath) throws UnsupportedRepositoryOperationException, VersionException, ConstraintViolationException, ItemNotFoundException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Value value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Value value, int type) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Value[] values) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Value[] values, int type) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, String[] values) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, String[] values, int type) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, String value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, String value, int type) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, InputStream value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Binary value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, boolean value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, double value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, BigDecimal value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, long value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Calendar value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property setProperty(String name, Node value) throws ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node getNode(String relPath) throws PathNotFoundException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeIterator getNodes() throws RepositoryException {
        return new RssNodeIterator((RssSessionImpl) getSession());
    }

    public NodeIterator getNodes(String namePattern) throws RepositoryException {
        return NodeIteratorImpl.EMPTY;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeIterator getNodes(String[] nameGlobs) throws RepositoryException {
        return NodeIteratorImpl.EMPTY;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Property getProperty(String relPath) throws PathNotFoundException, RepositoryException {
        return new RssPropertyImpl(rssBean.getTitle());
    }

    public PropertyIterator getProperties() throws RepositoryException {
        return PropertyIteratorImpl.EMPTY;
    }

    public PropertyIterator getProperties(String namePattern) throws RepositoryException {
        return PropertyIteratorImpl.EMPTY;
    }

    public PropertyIterator getProperties(String[] nameGlobs) throws RepositoryException {
        return PropertyIteratorImpl.EMPTY;
    }

    public Item getPrimaryItem() throws ItemNotFoundException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getUUID() throws UnsupportedRepositoryOperationException, RepositoryException {
        return getIdentifier();
    }

    public String getIdentifier() throws RepositoryException {
        if(rssBean==null) {
            return ((RssRepositoryImpl)getSession().getRepository()).getRoot();
        }
        return rssBean.getUrl();
    }

    public int getIndex() throws RepositoryException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PropertyIterator getReferences() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PropertyIterator getReferences(String name) throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PropertyIterator getWeakReferences() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PropertyIterator getWeakReferences(String name) throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasNode(String relPath) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasProperty(String relPath) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasNodes() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean hasProperties() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeType getPrimaryNodeType() throws RepositoryException {
        return NodeTypeRegistry.getInstance().getNodeType("jnt:rss");
    }

    public NodeType[] getMixinNodeTypes() throws RepositoryException {
        return new NodeType[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isNodeType(String nodeTypeName) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setPrimaryType(String nodeTypeName) throws NoSuchNodeTypeException, VersionException, ConstraintViolationException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addMixin(String mixinName) throws NoSuchNodeTypeException, VersionException, ConstraintViolationException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeMixin(String mixinName) throws NoSuchNodeTypeException, VersionException, ConstraintViolationException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean canAddMixin(String mixinName) throws NoSuchNodeTypeException, RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeDefinition getDefinition() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Version checkin() throws VersionException, UnsupportedRepositoryOperationException, InvalidItemStateException, LockException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void checkout() throws UnsupportedRepositoryOperationException, LockException, ActivityViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void doneMerge(Version version) throws VersionException, InvalidItemStateException, UnsupportedRepositoryOperationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void cancelMerge(Version version) throws VersionException, InvalidItemStateException, UnsupportedRepositoryOperationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void update(String srcWorkspace) throws NoSuchWorkspaceException, AccessDeniedException, LockException, InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeIterator merge(String srcWorkspace, boolean bestEffort) throws NoSuchWorkspaceException, AccessDeniedException, MergeException, LockException, InvalidItemStateException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getCorrespondingNodePath(String workspaceName) throws ItemNotFoundException, NoSuchWorkspaceException, AccessDeniedException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeIterator getSharedSet() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeSharedSet() throws VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeShare() throws VersionException, LockException, ConstraintViolationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isCheckedOut() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void restore(String versionName, boolean removeExisting) throws VersionException, ItemExistsException, UnsupportedRepositoryOperationException, LockException, InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void restore(Version version, boolean removeExisting) throws VersionException, ItemExistsException, InvalidItemStateException, UnsupportedRepositoryOperationException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void restore(Version version, String relPath, boolean removeExisting) throws PathNotFoundException, ItemExistsException, VersionException, ConstraintViolationException, UnsupportedRepositoryOperationException, LockException, InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void restoreByLabel(String versionLabel, boolean removeExisting) throws VersionException, ItemExistsException, UnsupportedRepositoryOperationException, LockException, InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public VersionHistory getVersionHistory() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Version getBaseVersion() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Lock lock(boolean isDeep, boolean isSessionScoped) throws UnsupportedRepositoryOperationException, LockException, AccessDeniedException, InvalidItemStateException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Lock getLock() throws UnsupportedRepositoryOperationException, LockException, AccessDeniedException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void unlock() throws UnsupportedRepositoryOperationException, LockException, AccessDeniedException, InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean holdsLock() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isLocked() throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void followLifecycleTransition(String transition) throws UnsupportedRepositoryOperationException, InvalidLifecycleTransitionException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String[] getAllowedLifecycleTransistions() throws UnsupportedRepositoryOperationException, RepositoryException {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getPath() throws RepositoryException {
        if(rssBean==null) {
            return "/";
        }
        return "/"+rssBean.getUrl();
    }

    public String getName() throws RepositoryException {
        return rssBean.getTitle();
    }

    public Item getAncestor(int depth) throws ItemNotFoundException, AccessDeniedException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node getParent() throws ItemNotFoundException, AccessDeniedException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getDepth() throws RepositoryException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Session getSession() throws RepositoryException {
        return session;
    }

    public boolean isNode() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isNew() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isModified() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isSame(Item otherItem) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void accept(ItemVisitor visitor) throws RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void save() throws AccessDeniedException, ItemExistsException, ConstraintViolationException, InvalidItemStateException, ReferentialIntegrityException, VersionException, LockException, NoSuchNodeTypeException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void refresh(boolean keepChanges) throws InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void remove() throws VersionException, LockException, ConstraintViolationException, AccessDeniedException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

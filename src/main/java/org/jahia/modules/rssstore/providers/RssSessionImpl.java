package org.jahia.modules.rssstore.providers;

import org.apache.commons.lang.StringUtils;
import org.jahia.services.content.JCRNodeWrapperImpl;
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
 * User: david
 * Date: 11/9/11
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class RssSessionImpl implements Session{
    private RssRepositoryImpl repository;
    private RssWorkspaceImpl workspace;

    public RssSessionImpl(RssRepositoryImpl repository) {
        this.repository = repository;
        this.workspace = new RssWorkspaceImpl(this);
    }

    public Repository getRepository() {
        return repository;
    }

    public String getUserID() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String[] getAttributeNames() {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object getAttribute(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public Node getRootNode() throws RepositoryException {
        return  new RssNodeImpl(this);
    }

    public Session impersonate(Credentials credentials) throws LoginException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node getNodeByUUID(String uuid) throws ItemNotFoundException, RepositoryException {
        return getNodeByIdentifier(uuid);
    }

    public Node getNodeByIdentifier(String id) throws ItemNotFoundException, RepositoryException {
        return getNode(id);
    }

    public Item getItem(String absPath) throws PathNotFoundException, RepositoryException {
        return new RssNodeImpl(this,repository.getRssEntries().get(StringUtils.substringAfter(absPath,"/")));
    }

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

    public void logout() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public RetentionManager getRetentionManager() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

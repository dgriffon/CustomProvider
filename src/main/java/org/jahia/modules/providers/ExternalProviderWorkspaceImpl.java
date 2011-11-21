package org.jahia.modules.providers;

import org.jahia.modules.rssstore.providers.RssSessionImpl;
import org.xml.sax.ContentHandler;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.lock.LockManager;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.observation.EventJournal;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.EventListenerIterator;
import javax.jcr.observation.ObservationManager;
import javax.jcr.query.QueryManager;
import javax.jcr.version.Version;
import javax.jcr.version.VersionException;
import javax.jcr.version.VersionManager;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 10/11/11
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class ExternalProviderWorkspaceImpl implements Workspace {
    private ExternalProviderAbstractSessionImpl session;

    public ExternalProviderWorkspaceImpl(ExternalProviderAbstractSessionImpl session) {
        this.session = session;
    }

    public Session getSession() {
        return session;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void copy(String srcAbsPath, String destAbsPath) throws ConstraintViolationException, VersionException, AccessDeniedException, PathNotFoundException, ItemExistsException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void copy(String srcWorkspace, String srcAbsPath, String destAbsPath) throws NoSuchWorkspaceException, ConstraintViolationException, VersionException, AccessDeniedException, PathNotFoundException, ItemExistsException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void clone(String srcWorkspace, String srcAbsPath, String destAbsPath, boolean removeExisting) throws NoSuchWorkspaceException, ConstraintViolationException, VersionException, AccessDeniedException, PathNotFoundException, ItemExistsException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void move(String srcAbsPath, String destAbsPath) throws ConstraintViolationException, VersionException, AccessDeniedException, PathNotFoundException, ItemExistsException, LockException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void restore(Version[] versions, boolean removeExisting) throws ItemExistsException, UnsupportedRepositoryOperationException, VersionException, LockException, InvalidItemStateException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public LockManager getLockManager() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public QueryManager getQueryManager() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NamespaceRegistry getNamespaceRegistry() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NodeTypeManager getNodeTypeManager() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ObservationManager getObservationManager() throws UnsupportedRepositoryOperationException, RepositoryException {
        return new ObservationManager() {
            public void addEventListener(EventListener listener, int eventTypes, String absPath, boolean isDeep, String[] uuid, String[] nodeTypeName, boolean noLocal) throws RepositoryException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void removeEventListener(EventListener listener) throws RepositoryException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public EventListenerIterator getRegisteredEventListeners() throws RepositoryException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public void setUserData(String userData) throws RepositoryException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public EventJournal getEventJournal() throws RepositoryException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public EventJournal getEventJournal(int eventTypes, String absPath, boolean isDeep, String[] uuid, String[] nodeTypeName) throws RepositoryException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    public VersionManager getVersionManager() throws UnsupportedRepositoryOperationException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String[] getAccessibleWorkspaceNames() throws RepositoryException {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ContentHandler getImportContentHandler(String parentAbsPath, int uuidBehavior) throws PathNotFoundException, ConstraintViolationException, VersionException, LockException, AccessDeniedException, RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void importXML(String parentAbsPath, InputStream in, int uuidBehavior) throws IOException, VersionException, PathNotFoundException, ItemExistsException, ConstraintViolationException, InvalidSerializedDataException, LockException, AccessDeniedException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createWorkspace(String name) throws AccessDeniedException, UnsupportedRepositoryOperationException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createWorkspace(String name, String srcWorkspace) throws AccessDeniedException, UnsupportedRepositoryOperationException, NoSuchWorkspaceException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteWorkspace(String name) throws AccessDeniedException, UnsupportedRepositoryOperationException, NoSuchWorkspaceException, RepositoryException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

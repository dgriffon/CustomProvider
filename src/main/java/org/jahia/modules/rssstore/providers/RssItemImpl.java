package org.jahia.modules.rssstore.providers;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 10/11/11
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class RssItemImpl implements Item {
    public String getPath() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getName() throws RepositoryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isNode() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
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

package org.jahia.modules.rssstore.providers;

import org.apache.commons.lang.StringUtils;
import org.jahia.modules.providers.ExternalProviderAbstractSessionImpl;
import org.jahia.modules.providers.ExternalProviderWorkspaceImpl;
import org.jahia.modules.rssstore.camel.RssBean;

import javax.jcr.*;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 11/9/11
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class RssSessionImpl extends ExternalProviderAbstractSessionImpl {
    private RssRepositoryImpl repository;
    private ExternalProviderWorkspaceImpl workspace;

    public RssSessionImpl(RssRepositoryImpl repository) {
        this.repository = repository;
        this.workspace = new ExternalProviderWorkspaceImpl(this);
    }

    @Override
    public Repository getRepository() {
        return repository;
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Node getRootNode() throws RepositoryException {
        return  new RSSProviderNodeImpl(this);
    }

    @Override
    public Node getNodeByIdentifier(String id) throws ItemNotFoundException, RepositoryException {
        return getNode(id);
    }

    @Override
    public Item getItem(String absPath) throws PathNotFoundException, RepositoryException {
        RssBean rssBean = repository.getRssEntries().get(StringUtils.substringAfter(absPath, "/"));
        if(rssBean!=null) {
        return new RSSProviderNodeImpl(this, rssBean);
        } else {
            return getRootNode();
        }
    }

    @Override
    public void logout() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}

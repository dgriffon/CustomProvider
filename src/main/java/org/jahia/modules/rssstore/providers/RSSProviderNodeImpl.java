package org.jahia.modules.rssstore.providers;

import org.jahia.api.Constants;
import org.jahia.modules.providers.ExternamProviderAbstractNodeImpl;
import org.jahia.modules.rssstore.camel.RssBean;
import org.jahia.services.content.JCRContentUtils;
import org.jahia.services.content.impl.vfs.PropertyIteratorImpl;
import org.jahia.services.content.nodetypes.ExtendedNodeType;
import org.jahia.services.content.nodetypes.NodeTypeRegistry;

import javax.jcr.*;
import javax.jcr.nodetype.NodeDefinition;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 10/11/11
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class RSSProviderNodeImpl extends ExternamProviderAbstractNodeImpl {
    private static final String JNT_RSS = "jnt:rssEntry";
    private RssSessionImpl session;
    private Map<String, Object> properties = null;

    public RSSProviderNodeImpl(RssSessionImpl session) {
        this.session = session;
    }

    public RSSProviderNodeImpl(RssSessionImpl session, RssBean rssBean) {
        this.session = session;
        if (rssBean != null) {
            this.properties = new LinkedHashMap<String, Object>();
            properties.put(Constants.JCR_TITLE, rssBean.getTitle());
            properties.put("body", rssBean.getBody());
            properties.put("author", rssBean.getAuthor());
            properties.put("url", rssBean.getUrl());
            properties.put("published", rssBean.getPublishedDate());
        }
    }

    @Override
    public Node getNode(String relPath) throws PathNotFoundException, RepositoryException {
        if(properties!=null) throw new PathNotFoundException(relPath);
        return session.getNode(relPath);
    }

    @Override
    public NodeIterator getNodes() throws RepositoryException {
        if (properties == null) {
            return new RssNodeIterator((RssSessionImpl) getSession());
        } else {
            return new RssNodeIterator(null);
        }
    }

    @Override
    public Property getProperty(String relPath) throws PathNotFoundException, RepositoryException {
        if (properties != null && properties.containsKey(relPath)) {
            return new RSSProviderPropertyImpl(this, relPath, properties.get(relPath));
        } else {
            throw new PathNotFoundException(relPath);
        }
    }

    @Override
    public PropertyIterator getProperties() throws RepositoryException {
        List l = new ArrayList(2);
        l.add(getProperty(Constants.JCR_TITLE));
        l.add(getProperty("body"));
        l.add(getProperty("url"));
        l.add(getProperty("author"));
        l.add(getProperty("published"));

        return new PropertyIteratorImpl(l.iterator(), l.size());
    }

    @Override
    public String getIdentifier() throws RepositoryException {
        if (properties == null) {
            return ((RssRepositoryImpl) getSession().getRepository()).getRoot();
        }
        return JCRContentUtils.generateNodeName((String) properties.get("url"), 64);
    }

    @Override
    public boolean hasNodes() throws RepositoryException {
        return properties == null;
    }

    @Override
    public boolean hasProperties() throws RepositoryException {
        return properties != null;
    }

    @Override
    public ExtendedNodeType getExtendedPrimaryNodeType() throws RepositoryException {
        return NodeTypeRegistry.getInstance().getNodeType(JNT_RSS);
    }

    @Override
    public boolean isNodeType(String nodeTypeName) throws RepositoryException {
        return getExtendedPrimaryNodeType().isNodeType(nodeTypeName);
    }

    @Override
    public NodeDefinition getDefinition() throws RepositoryException {
        return getExtendedPrimaryNodeType().getNodeDefinition(getPrimaryNodeType().getName());
    }

    @Override
    public String getPath() throws RepositoryException {
        if (properties == null) {
            return "/";
        }
        return "/" + JCRContentUtils.generateNodeName((String) properties.get("url"), 64);
    }

    @Override
    public String getName() throws RepositoryException {
        return JCRContentUtils.generateNodeName((String) properties.get("url"), 64);
    }

    @Override
    public Node getParent() throws ItemNotFoundException, AccessDeniedException, RepositoryException {
        if (properties != null) {
            return new RSSProviderNodeImpl(session);
        }
        throw new ItemNotFoundException();
    }

    @Override
    public Session getSession() throws RepositoryException {
        return session;
    }

    @Override
    public boolean isNode() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSame(Item otherItem) throws RepositoryException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

}

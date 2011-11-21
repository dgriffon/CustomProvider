package org.jahia.modules.rssstore.providers;

import org.jahia.api.Constants;
import org.jahia.modules.providers.ExternalProviderAbstractNodeImpl;
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
public class RSSProviderNodeImpl extends ExternalProviderAbstractNodeImpl {
    private static final String JNT_RSS = "jnt:rssEntry";
    private RssSessionImpl session;
    private Map<String, Object> properties = null;

    /**
     * This is the constructor of the root node.
     * @param session opening session for this node.
     */
    public RSSProviderNodeImpl(RssSessionImpl session) {
        this.session = session;
    }

    /**
     * This is the constructor called for a particular rss entry.
     * @param session opening session for this node.
     * @param rssBean the rssBean containing the properties for this rss entry.
     */
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

    /**
     * If this is the root node return the rss entry node associated with this path.
     * @param relPath path of rss entry
     * @return the rss entry node if available
     * @throws PathNotFoundException
     * @throws RepositoryException
     */
    @Override
    public Node getNode(String relPath) throws PathNotFoundException, RepositoryException {
        if(properties!=null) throw new PathNotFoundException(relPath);
        return session.getNode(relPath);
    }

    /**
     * Get all rss entries if current instance is the root node otherwise return empty iterator
     * @return list of all rss entries
     * @throws RepositoryException
     */
    @Override
    public NodeIterator getNodes() throws RepositoryException {
        if (properties == null) {
            return new RssNodeIterator((RssSessionImpl) getSession());
        } else {
            return new RssNodeIterator(null);
        }
    }

    /**
     * get the property associated with this name
     * @param relPath name of the property
     * @return the property itself if available
     * @throws PathNotFoundException
     * @throws RepositoryException
     */
    @Override
    public Property getProperty(String relPath) throws PathNotFoundException, RepositoryException {
        if (properties != null && properties.containsKey(relPath)) {
            return new RSSProviderPropertyImpl(this, relPath, properties.get(relPath));
        } else {
            throw new PathNotFoundException(relPath);
        }
    }

    /**
     * Create an iterator of all the properties of this node
     * @return the iterator on all properties
     * @throws RepositoryException
     */
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

    /**
     * Return the identifier of this node (url if rss entry, rss source if root node)
     * @return identifier of this node
     * @throws RepositoryException
     */
    @Override
    public String getIdentifier() throws RepositoryException {
        if (properties == null) {
            return ((RssRepositoryImpl) getSession().getRepository()).getRoot();
        }
        return JCRContentUtils.generateNodeName((String) properties.get("url"), 64);
    }

    /**
     * Does this node have childs ?
     * @return true if this node has childs false otherwise.
     * @throws RepositoryException
     */
    @Override
    public boolean hasNodes() throws RepositoryException {
        return properties == null;
    }

    /**
     * Does this node have properties.
     * @return true if this node has properties false otherwise.
     * @throws RepositoryException
     */
    @Override
    public boolean hasProperties() throws RepositoryException {
        return properties != null;
    }

    /**
     * Return the node type of this node.
     * @return the node type associated with this node.
     * @throws RepositoryException
     */
    @Override
    public ExtendedNodeType getExtendedPrimaryNodeType() throws RepositoryException {
        return NodeTypeRegistry.getInstance().getNodeType(JNT_RSS);
    }

    /**
     * Is this node a sub type of this type.
     * @param nodeTypeName super type to be tested against.
     * @return true if this node is of this type or false otherwise
     * @throws RepositoryException
     */
    @Override
    public boolean isNodeType(String nodeTypeName) throws RepositoryException {
        return getExtendedPrimaryNodeType().isNodeType(nodeTypeName);
    }

    /**
     * This node definition.
     * @return the definition associated with this node.
     * @throws RepositoryException
     */
    @Override
    public NodeDefinition getDefinition() throws RepositoryException {
        return getExtendedPrimaryNodeType().getNodeDefinition(getPrimaryNodeType().getName());
    }

    /**
     * The absolute path of this node.
     * @return the absolute path of this node.
     * @throws RepositoryException
     */
    @Override
    public String getPath() throws RepositoryException {
        if (properties == null) {
            return "/";
        }
        return "/" + JCRContentUtils.generateNodeName((String) properties.get("url"), 64);
    }

    /**
     * The name of this node based on the url of this rss entry.
     * @return the name of this node.
     * @throws RepositoryException
     */
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

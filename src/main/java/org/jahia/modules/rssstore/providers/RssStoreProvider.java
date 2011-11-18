package org.jahia.modules.rssstore.providers;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.RoutesBuilder;
import org.jahia.modules.rssstore.camel.RssRoutesBuilder;
import org.jahia.services.content.JCRStoreProvider;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.jcr.Repository;

/**
 * A Rss Provider
 * .
 */
public class RssStoreProvider extends JCRStoreProvider implements CamelContextAware {

    private static final Logger logger = LoggerFactory.getLogger(RssStoreProvider.class);

    private String root;

    static private CamelContext camelContext;

    @Override
    public Repository getRepository() {
        if (repo == null) {
            synchronized (RssStoreProvider.class) {
                if (repo == null) {
                    repo = new RssRepositoryImpl(root);
                    // add camel route
                    RssRoutesBuilder r = new RssRoutesBuilder();
                    r.setRssUrl(root.substring(root.indexOf(":") + 1));
                    try {
                        if (camelContext != null) {
                            camelContext.addRoutes(r);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }
        return repo;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

}

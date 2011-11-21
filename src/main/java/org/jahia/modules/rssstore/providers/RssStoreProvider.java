package org.jahia.modules.rssstore.providers;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.commons.lang.StringUtils;
import org.jahia.modules.providers.ExternalProviderStoreProvider;
import org.jahia.modules.rssstore.camel.RssRoutesBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.jcr.Repository;

/**
 * A Rss Provider
 * .
 */
public class RssStoreProvider extends ExternalProviderStoreProvider implements CamelContextAware {

    private static final Logger logger = LoggerFactory.getLogger(RssStoreProvider.class);

    static private CamelContext camelContext;

    @Override
    public Repository getRepository() {
        if (repo == null) {
            synchronized (RssStoreProvider.class) {
                if (repo == null) {
                    String root = getRoot();
                    repo = new RssRepositoryImpl(root);
                    // add camel route
                    RssRoutesBuilder r = new RssRoutesBuilder();
                    r.setRssUrl(StringUtils.substringAfter(root,"://"));
                    r.setRssRepositoryImpl((RssRepositoryImpl) repo);
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

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

}

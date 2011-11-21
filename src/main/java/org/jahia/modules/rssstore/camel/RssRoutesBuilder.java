package org.jahia.modules.rssstore.camel;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.spring.SpringRouteBuilder;
import org.jahia.modules.rssstore.providers.RssRepositoryImpl;
import org.jahia.services.content.JCRContentUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 14/11/11
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class RssRoutesBuilder extends SpringRouteBuilder {
    private String rssUrl;
    private RssRepositoryImpl rssRepositoryImpl;


    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    public void configure() throws Exception {
        from("rss:" + rssUrl + "?splitEntries=false").bean(this);
    }

    @Handler
    public void handleRssFeed(Exchange exchange) {
        SyndFeedImpl syndFeed = (SyndFeedImpl) exchange.getIn().getBody();
        Map<String, RssBean> rssEntries = rssRepositoryImpl.getRssEntries();
        List<SyndEntryImpl> syndEntries = (List<SyndEntryImpl>) syndFeed.getEntries();
        for (SyndEntryImpl syndFeedEntry : syndEntries) {
            String key = JCRContentUtils.generateNodeName(syndFeedEntry.getLink(), 64);
            if (!rssEntries.containsKey(key)) {
                System.out.println("syndFeedEntry.getTitle() = " + syndFeedEntry.getTitle());
                RssBean rssBean = new RssBean();
                rssBean.setTitle(syndFeedEntry.getTitle());
                rssBean.setUrl(syndFeedEntry.getLink());
                rssBean.setBody(syndFeedEntry.getDescription().getValue());
                rssBean.setPublishedDate(syndFeedEntry.getPublishedDate());
                rssBean.setAuthor(syndFeedEntry.getAuthor());
                rssEntries.put(key, rssBean);
            }
        }
        rssRepositoryImpl.setRssEntries(rssEntries);
    }

    public void setRssRepositoryImpl(RssRepositoryImpl rssRepositoryImpl) {
        this.rssRepositoryImpl = rssRepositoryImpl;
    }
}
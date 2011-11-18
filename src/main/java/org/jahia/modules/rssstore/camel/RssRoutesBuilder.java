package org.jahia.modules.rssstore.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: David
 * Date: 14/11/11
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class RssRoutesBuilder extends SpringRouteBuilder {
    private String rssUrl;

    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    public void configure() throws Exception {
        from("rss:" + rssUrl + "?splitEntries=false")
                .unmarshal()
                .rss()
                .process(new Processor() {

            public void process(Exchange e) {
                System.out.println("Received exchange: " + e.getIn());
            }
        });


    }
}
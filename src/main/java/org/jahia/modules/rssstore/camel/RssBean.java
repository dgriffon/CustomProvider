package org.jahia.modules.rssstore.camel;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 11/15/11
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class RssBean {
    private String title;
    private String body;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

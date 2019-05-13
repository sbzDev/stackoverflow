package com.stackoverflow.questions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HtmlParser {

    public String parse(String html) {

        Document document = Jsoup.parse(html);

        return getBodyTag(document);
    }

    private String getBodyTag(final Document document) {
        return document.body().html();
    }
}

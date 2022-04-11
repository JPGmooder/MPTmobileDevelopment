package com.example.news;

public class news {
    String nameNews, textNews;

    public news(String nameNews, String textNews) {
        this.nameNews = nameNews;
        this.textNews = textNews;
    }

    public String getName() { return nameNews; }

    public String getText() {
        return textNews;
    }
}

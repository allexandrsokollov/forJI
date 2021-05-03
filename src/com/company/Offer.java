package com.company;

public class Offer {

    private final String ref;
    private final String title;
    private final String pubDate;


    public Offer(String ref, String title, String paBDate) {
        this.ref = ref;
        this.title = title;
        this.pubDate = paBDate;
    }

    public String getRef() {
        return ref;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "ref='" + ref + '\'' +
                ", title='" + title + '\'' +
                ", puBDate='" + pubDate + '\'' +
                '}';
    }
}

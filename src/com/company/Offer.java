package com.company;

public class Offer {

    private String ref;
    private String title;
    private String pubDate;

    public Offer() {
    }

    public Offer(String ref, String title, String paBDate) {
        this.ref = ref;
        this.title = title;
        this.pubDate = paBDate;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPuBDate(String puBDate) {
        this.pubDate = puBDate;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "ref='" + ref + '\'' +
                ", title='" + title + '\'' +
                ", paBDate='" + pubDate + '\'' +
                '}';
    }
}

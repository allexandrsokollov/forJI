package com.company;

public class Offer {

    private String ref;
    private String title;
    private String paBDate;

    public Offer(String ref, String title, String paBDate) {
        this.ref = ref;
        this.title = title;
        this.paBDate = paBDate;
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

    public String getPaBDate() {
        return paBDate;
    }

    public void setPaBDate(String paBDate) {
        this.paBDate = paBDate;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "ref='" + ref + '\'' +
                ", title='" + title + '\'' +
                ", paBDate='" + paBDate + '\'' +
                '}';
    }
}

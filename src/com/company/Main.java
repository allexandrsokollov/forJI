package com.company;



public class Main {

    public static void main(String[] args) {

        WebParser webParser = new WebParser("https://dataart.team/Umbraco/Api/RssFeed/GenerateRssFeed?section=vacancy");
        webParser.getListOfOffers();
    }
}

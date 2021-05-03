package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        WebParser webParser = new WebParser("https://dataart.team/Umbraco/Api/RssFeed/GenerateRssFeed?section=vacancy");
        ArrayList<Offer> list = webParser.getListOfOffers();

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

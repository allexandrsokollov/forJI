package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DataBase dataBase = new DataBase("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/dt",
                "user", "1234");

        WebParser webParser = new WebParser("https://dataart.team/Umbraco/Api/RssFeed/GenerateRssFeed?section=vacancy");
        ArrayList<Offer> list = dataBase.searchInOffersList("Java", "test");

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}

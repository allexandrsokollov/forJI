package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser("offers.xml");

        List<Offer> list;
        list = parser.getListOfOffers();

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

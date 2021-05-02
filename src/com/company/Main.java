package com.company;



public class Main {

    public static void main(String[] args) {

        DataBase db = new DataBase("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/dt",
                "user", "1234");

        db.dropTable("test");
    }
}

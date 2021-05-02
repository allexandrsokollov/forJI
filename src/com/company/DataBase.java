package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DataBase {

    String JDBC_DRIVER;
    String DB_URL;
    String user;
    String pass;

    public DataBase(String JDBC_DRIVER, String DB_URL, String user, String pass) {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DB_URL = DB_URL;
        this.user = user;
        this.pass = pass;
    }

    public void createTable(String name) {
        String sql = "CREATE TABLE IF NOT EXISTS " + name + " (id VARCHAR(100) NOT NULL, title VARCHAR(255) NOT NULL, date VARCHAR(100) NOT NULL, PRIMARY KEY (id))";
        Connection connection = null;
        Statement stmt = null;


        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, user, pass);
            stmt = connection.createStatement();

            stmt.executeUpdate(sql);


            stmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
        } finally {
            if(stmt != null) {

                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if(connection != null) {

                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
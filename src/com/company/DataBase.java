package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    private final String JDBC_DRIVER;
    private final String DB_URL;
    private final String user;
    private final String pass;

    public DataBase(String JDBC_DRIVER, String DB_URL, String user, String pass) {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DB_URL = DB_URL;
        this.user = user;
        this.pass = pass;
    }

    public void createTable(String name) {
        String sql = "CREATE TABLE IF NOT EXISTS " + name + " (id VARCHAR(200) NOT NULL, title VARCHAR(200) NOT NULL, date VARCHAR(200) NOT NULL, PRIMARY KEY (id))";
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

    public void dropTable(String name) {
        String sql = "Drop TABLE IF EXISTS " + name;
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

    public void addElem(String nameOfTable, String id, String title, String date) {

        String sql = "INSERT INTO " + nameOfTable + " (id, title, date) VALUES ('" + id + "' ,'" + title + "' ,'" + date + "')";
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

    public void listOfOffersToDB(ArrayList<Offer> list, String nameOfTable) {

        for(int i = 0; i < list.size(); i++) {
            addElem(nameOfTable, list.get(i).getRef(), list.get(i).getTitle(), list.get(i).getPubDate());
        }
    }

    public ArrayList<Offer> getListOfOffers (String tableName) {

        String sql = "SELECT * FROM " + tableName;
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Offer> list = new ArrayList<>(100);
        String id;
        String title;
        String pubDate;

        try {
            conn = DriverManager.getConnection(DB_URL, user, pass);
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {

                id = resultSet.getString(1);
                title = resultSet.getString(2);
                pubDate = resultSet.getString(3);
                list.add(new Offer(id, title, pubDate));

                id = null;
                title = null;
                pubDate = null;
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return list;

    }

    public ArrayList<Offer> searchInOffersList(String request, String tableName) {
        String sql = "SELECT * FROM " + tableName + " WHERE TITLE LIKE '%" + request.toLowerCase() + "%'";
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Offer> list = new ArrayList<>(100);
        String id;
        String title;
        String pubDate;

        try {
            conn = DriverManager.getConnection(DB_URL, user, pass);
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {

                id = resultSet.getString(1);
                title = resultSet.getString(2);
                pubDate = resultSet.getString(3);
                list.add(new Offer(id, title, pubDate));

                id = null;
                title = null;
                pubDate = null;
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return list;
    }


}
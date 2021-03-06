package com.company;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class WebParser extends Parser{

    public WebParser(String path) {

        super(path);
    }

    public ArrayList<Offer> getListOfOffers() {

        HttpURLConnection conn;
        BufferedReader reader;
        final int TIMEOUT_LENGTH = 5000;
        BufferedWriter writer = null;
        String line;
        StringBuilder data = new StringBuilder();
        int connectionStatus;
        final int LAST_SUCCESS_CODE = 299;

        try {
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("GET");
            conn.setConnectTimeout(TIMEOUT_LENGTH);
            conn.setReadTimeout(TIMEOUT_LENGTH);

            connectionStatus = conn.getResponseCode();

                if (connectionStatus > LAST_SUCCESS_CODE) {
                    reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                    while ((line = reader.readLine()) != null) {
                        data.append(line);
                        data.append("\n");
                    }


                    reader.close();
                } else {

                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        data.append(line);
                        data.append("\n");
                    }


                     reader.close();
            }

            System.out.println(data);


        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            writer = new BufferedWriter(new FileWriter("temp.xml"));
            String temp = data.toString();
            writer.write(temp.toLowerCase());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null) {

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ArrayList<Offer> list;
        Parser parser = new Parser("temp.xml");
        list = parser.getListOfOffers();

        File f = new File("temp.xml");
        f.delete();


        return list;

    }
}

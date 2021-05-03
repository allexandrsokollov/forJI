package com.company;

import java.awt.desktop.OpenFilesEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WebParser {

    private final String ref;

    public WebParser(String ref) {
        this.ref = ref;
    }

    public ArrayList<Offer> getListOfOffers() {

        HttpURLConnection conn;
        BufferedReader reader;
        BufferedWriter writer = null;
        String line;
        StringBuilder data = new StringBuilder();
        int connectionStatus;
        final int LAST_SUCCESS_CODE = 299;

        try {
            URL url = new URL(ref);
            conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

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
            writer.write(data.toString());

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

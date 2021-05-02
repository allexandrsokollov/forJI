package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WebParser {

    private final String ref;

    public WebParser(String ref) {
        this.ref = ref;
    }

    public void getListOfOffers() {

        HttpURLConnection conn;
        BufferedReader reader;
        String line;
        String data = "";
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
                    data += line;
                    data += "\n";
                }


                reader.close();
            } else {

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    data += line;
                    data += "\n";
                }


                reader.close();
            }

            System.out.println(data);


        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

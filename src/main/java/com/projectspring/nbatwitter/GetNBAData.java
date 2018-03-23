package com.projectspring.nbatwitter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class GetNBAData {
    public void getActivePlayerData() {
        try {
            URL url = new URL ("https://api.mysportsfeeds.com/v1.2/pull/nba/2016-2017-regular/active_players.json");
            String encoding = Base64.getEncoder().encodeToString ("surilshah:Suril5594*".getBytes("utf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

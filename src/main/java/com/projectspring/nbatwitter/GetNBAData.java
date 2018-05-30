package com.projectspring.nbatwitter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.json.*;

public class GetNBAData {
    public List<Player> getActivePlayerData() {
        List<Player> listAllPlayers = new ArrayList<Player>();
        try {
            URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nba/2016-2017-regular/active_players.json");
            String encoding = Base64.getEncoder().encodeToString("surilshah:Suril5594*".getBytes("utf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                JSONObject obj = new JSONObject(line);
                JSONArray playerlist = obj.getJSONObject("activeplayers").getJSONArray("playerentry");
                for(int i = 0; i < playerlist.length(); i++) {
                    Player player = new Player();
                    player.setId(playerlist.getJSONObject(i).getJSONObject("player").getString("ID"));
                    player.setFirstName(playerlist.getJSONObject(i).getJSONObject("player").getString("FirstName"));
                    player.setLastName(playerlist.getJSONObject(i).getJSONObject("player").getString("LastName"));
                    player.setTwitter(playerlist.getJSONObject(i).getJSONObject("player").get("Twitter").toString());
                    listAllPlayers.add(player);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAllPlayers;
    }
}

package com.projectspring.nbatwitter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetPlayerTwitterTimeline {
    public List<TwitterTweets> getPlayerTweets(String playerTwitterHandle) {
        List<TwitterTweets> tweets = new ArrayList<TwitterTweets>();
        try {
            URL url = new URL("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + playerTwitterHandle + "&count=5");
            String authorizationKey = "AAAAAAAAAAAAAAAAAAAAADEF5AAAAAAA83k6AHqDH7oDdfPAr0nLhFolj4E%3Du88UtCrQZdK9IO357wmMVIum8RpBS9h3bUoLpZoRbFSaUs5J5e";
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + authorizationKey);
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                JSONArray tweetList = new JSONArray(line);
                for(int i = 0; i < tweetList.length(); i++) {
                    TwitterTweets tweet = new TwitterTweets();
                    tweet.setId(tweetList.getJSONObject(i).getString("id_str"));
                    tweet.setTweet(tweetList.getJSONObject(i).getString("text"));
                    tweets.add(tweet);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return tweets;
    }
}

package com.projectspring.nbatwitter;

public class TwitterTweets {
    private String id, tweet;

    public void setId(String tweetID) {
        this.id = tweetID;
    }

    public void setTweet(String tweetText) {
        this.tweet = tweetText;
    }

    public String getId() {
        return this.id;
    }

    public String getTweet() {
        return this.tweet;
    }

    @Override
    public String toString() {
        return "TwitterTweet{" + "ID: " + this.id + ", Tweet: " + this.tweet + " }";
    }
}

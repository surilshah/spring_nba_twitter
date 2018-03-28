package com.projectspring.nbatwitter;

public class Player {

    private String id, lastName, firstName, twitter;

    public void setId(String playerID) {
        this.id = playerID;
    }

    public void setLastName(String playerLastName) {
        this.lastName = playerLastName;
    }

    public void setFirstName(String playerFirstName) {
        this.firstName = playerFirstName;
    }

    public void setTwitter(String playerTwitter) {
        this.twitter = playerTwitter;
    }

    public String getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getTwitter() {
        return this.twitter;
    }

    @Override
    public String toString() {
        return "Player{" + "ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Twitter: " + twitter + " }";
    }
}

package com.projectspring.nbatwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NbaTwitterApplication {

	public static void main(String[] args) {

		SpringApplication.run(NbaTwitterApplication.class, args);
//		GetNBAData g = new GetNBAData();
//		g.getActivePlayerData();
//		GetPlayerTwitterTimeline d = new GetPlayerTwitterTimeline();
//		d.getPlayerTweets("ivicazubac");
	}
}

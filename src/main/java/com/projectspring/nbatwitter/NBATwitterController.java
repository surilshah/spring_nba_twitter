package com.projectspring.nbatwitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NBATwitterController {
    @GetMapping("/getPlayers")
    public List<?> getPlayers() {
        GetNBAData obj = new GetNBAData();
        return obj.getActivePlayerData();
    }

    @GetMapping("/getPlayerTweets/{twitterID}")
    public List<?> getPlayerTweets(@PathVariable("twitterID") String twitterID) {
        GetPlayerTwitterTimeline obj = new GetPlayerTwitterTimeline();
        return obj.getPlayerTweets(twitterID);
    }
}

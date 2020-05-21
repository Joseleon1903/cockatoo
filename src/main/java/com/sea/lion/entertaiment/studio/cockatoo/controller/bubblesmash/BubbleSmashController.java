package com.sea.lion.entertaiment.studio.cockatoo.controller.bubblesmash;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerBestScore;
import com.sea.lion.entertaiment.studio.cockatoo.service.PlayerBestScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose eduardo on 5/21/2020.
 */
@RestController
public class BubbleSmashController {

    Logger logger = LoggerFactory.getLogger(BubbleSmashController.class);

    @Autowired
    private PlayerBestScoreService playerBestScoreService;

    @PostMapping("/bubble/smash/api/save/player/score")
    public ResponseEntity savePlayerBestScore(@RequestBody PlayerBestScore playerBestScore) {
        logger.debug("Entering savePlayerBestScore");
        logger.debug("param: "+ playerBestScore);

        logger.debug("call savePlayerBestScore");
        playerBestScoreService.registerPlayerBestCore(playerBestScore);
        logger.debug("end call savePlayerBestScore");

        logger.debug("exiting savePlayerBestScore");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bubble/smash/api/get/player/top/score")
    public ResponseEntity<List<PlayerBestScore>> getPlayerTopTenScore() {

        logger.debug("call getPlayerTopTenScore");
        List<PlayerBestScore> playerbestScores = playerBestScoreService.getBestTopTenScore();
        logger.debug("end call getPlayerTopTenScore");

        logger.debug("returning getPlayerTopTenScore");
        return ResponseEntity.ok(playerbestScores);
    }

}

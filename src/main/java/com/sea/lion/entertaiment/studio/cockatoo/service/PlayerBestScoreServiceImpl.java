package com.sea.lion.entertaiment.studio.cockatoo.service;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerBestScore;
import com.sea.lion.entertaiment.studio.cockatoo.repository.JpaPlayerBestScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 5/21/2020.
 */
@Service
public class PlayerBestScoreServiceImpl implements PlayerBestScoreService {

    Logger logger = LoggerFactory.getLogger(PlayerBestScoreService.class);

    private JpaPlayerBestScoreRepository jpaPlayerBestScoreRepository;

    public PlayerBestScoreServiceImpl(JpaPlayerBestScoreRepository jpaPlayerBestScoreRepository) {
        this.jpaPlayerBestScoreRepository = jpaPlayerBestScoreRepository;
    }

    @Override
    public void registerPlayerBestCore(PlayerBestScore playerBestScore) {
        logger.debug("Entering in method registerPlayerBestCore");
        logger.debug("Entering param: "+playerBestScore);
        Iterable<PlayerBestScore> bestScore = jpaPlayerBestScoreRepository.findAll();

        boolean isValidNewScore = true;

        for(PlayerBestScore score : bestScore){

            if(score.getPlayerScore() >= playerBestScore.getPlayerScore()) {

                isValidNewScore = false;
            }
        }

        if(isValidNewScore){
            PlayerBestScore player = jpaPlayerBestScoreRepository.findByPlayerName(playerBestScore.getPlayerName());
            if(player != null){
                player.setPlayerScore(playerBestScore.getPlayerScore());
                jpaPlayerBestScoreRepository.save(player);
            }else{
                jpaPlayerBestScoreRepository.save(playerBestScore);
            }
        }
    }

    @Override
    public List<PlayerBestScore> getBestTopTenScore() {

        List<PlayerBestScore> listresrult = jpaPlayerBestScoreRepository.getOrderByPlayerScore();
        List<PlayerBestScore> listOut = new ArrayList<>();

        if(listresrult.size() > 10) {
            for (int ind = 1; ind <= 10; ind++) {
                listOut.add(listresrult.get(ind));
            }
            return listOut;
        }
        return listresrult;
    }
}

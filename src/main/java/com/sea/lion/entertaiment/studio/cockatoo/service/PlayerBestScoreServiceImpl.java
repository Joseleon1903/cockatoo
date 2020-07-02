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

        PlayerBestScore bestScoreN = jpaPlayerBestScoreRepository.findByPlayerName(playerBestScore.getPlayerName());

        PlayerBestScore bestScoreS = jpaPlayerBestScoreRepository.findByPlayerScore(playerBestScore.getPlayerScore());

        if(bestScoreN == null  && bestScoreS == null){
            jpaPlayerBestScoreRepository.save(playerBestScore);
        }

        if(bestScoreN != null  && bestScoreS == null){
            bestScoreN.setPlayerScore(playerBestScore.getPlayerScore());
            jpaPlayerBestScoreRepository.save(bestScoreN);
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

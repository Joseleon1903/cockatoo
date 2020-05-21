package com.sea.lion.entertaiment.studio.cockatoo.service;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerBestScore;
import java.util.List;

/**
 * Created by jose eduardo on 5/21/2020.
 */
public interface PlayerBestScoreService {


    void registerPlayerBestCore(PlayerBestScore playerBestScore);

    List<PlayerBestScore> getBestTopTenScore();

}

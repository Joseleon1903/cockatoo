package com.sea.lion.entertaiment.studio.cockatoo.repository;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerBestScore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by jose eduardo on 5/21/2020.
 */
public interface JpaPlayerBestScoreRepository extends CrudRepository<PlayerBestScore, Long> {

    PlayerBestScore findByPlayerName(String playerName);

    @Query(value = "SELECT p FROM PlayerBestScore  p order by playerScore DESC ")
    List<PlayerBestScore> getOrderByPlayerScore();

}

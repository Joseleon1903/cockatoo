package com.sea.lion.entertaiment.studio.cockatoo.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jose eduardo on 5/21/2020.
 */
@Data
@Entity
public class PlayerBestScore {

    @Id
    @GeneratedValue
    private long id;

    private String playerName;

    private int playerScore;

    private String playerScoreDate;

}

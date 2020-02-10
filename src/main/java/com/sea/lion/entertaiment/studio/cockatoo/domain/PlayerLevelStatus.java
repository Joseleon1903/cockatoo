package com.sea.lion.entertaiment.studio.cockatoo.domain;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@Data
@Entity
public class PlayerLevelStatus {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buildId")
    private SystemPlayer systemPlayer;

    private String levelName;

    private int playerPoints;

    private String playerCompleteTime;

    private int playerLife;

    private String isLevelComplete;

    private int playerRetryIntent;

}

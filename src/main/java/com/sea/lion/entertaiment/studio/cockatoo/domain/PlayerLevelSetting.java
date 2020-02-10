package com.sea.lion.entertaiment.studio.cockatoo.domain;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@Data
@Entity
public class PlayerLevelSetting {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buildId")
    private SystemPlayer systemPlayer;

    private String levelReferenceName;

    private int totalLevelEnemy;

    private float enemySpeedRange;

    private float enemySpeedPercent1;

    private float enemySpeedPercent2;

    private float enemyTimeSpawnRange;

    private float enemyTimeSpawnPercent1;

    private float enemyTimeSpawnPercent2;

    private float enemyBaseSpeed;

    private float enemyBaseTimeSpawn;



}
package com.sea.lion.entertaiment.studio.cockatoo.dto;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import lombok.Data;

/**
 * Created by jose eduardo on 1/1/2020.
 */
@Data
public class PlayerLevelSettingDTO {

    private String buildId;

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

    public PlayerLevelSettingDTO(){}

    public static PlayerLevelSetting toEntity(PlayerLevelSettingDTO playerLevelSettingDTO){
        PlayerLevelSetting setting = new PlayerLevelSetting();
        SystemPlayer player = new SystemPlayer(playerLevelSettingDTO.getBuildId());
        setting.setSystemPlayer(player);
        setting.setLevelReferenceName(playerLevelSettingDTO.getLevelReferenceName());
        setting.setTotalLevelEnemy(playerLevelSettingDTO.getTotalLevelEnemy());
        setting.setEnemyBaseSpeed(playerLevelSettingDTO.getEnemyBaseSpeed());
        setting.setEnemyBaseTimeSpawn(playerLevelSettingDTO.getEnemyBaseTimeSpawn());

        setting.setEnemySpeedRange(playerLevelSettingDTO.getEnemySpeedRange());
        setting.setEnemySpeedPercent1(playerLevelSettingDTO.getEnemySpeedPercent1());
        setting.setEnemySpeedPercent2(playerLevelSettingDTO.getEnemySpeedPercent2());

        setting.setEnemyTimeSpawnRange(playerLevelSettingDTO.getEnemyTimeSpawnRange());
        setting.setEnemyTimeSpawnPercent1(playerLevelSettingDTO.getEnemyTimeSpawnPercent1());
        setting.setEnemyTimeSpawnPercent2(playerLevelSettingDTO.getEnemyTimeSpawnPercent2());

        return setting;
    }

    public static PlayerLevelSettingDTO toObject(PlayerLevelSetting playerLevelSetting){
        PlayerLevelSettingDTO settingDto = new PlayerLevelSettingDTO();
        settingDto.setBuildId(playerLevelSetting.getSystemPlayer().getBuildId());
        settingDto.setLevelReferenceName(playerLevelSetting.getLevelReferenceName());
        settingDto.setTotalLevelEnemy(playerLevelSetting.getTotalLevelEnemy());
        settingDto.setEnemyBaseSpeed(playerLevelSetting.getEnemyBaseSpeed());
        settingDto.setEnemyBaseTimeSpawn(playerLevelSetting.getEnemyBaseTimeSpawn());

        settingDto.setEnemySpeedRange(playerLevelSetting.getEnemySpeedRange());
        settingDto.setEnemySpeedPercent1(playerLevelSetting.getEnemySpeedPercent1());
        settingDto.setEnemySpeedPercent2(playerLevelSetting.getEnemySpeedPercent2());

        settingDto.setEnemyTimeSpawnRange(playerLevelSetting.getEnemyTimeSpawnRange());
        settingDto.setEnemyTimeSpawnPercent1(playerLevelSetting.getEnemyTimeSpawnPercent1());
        settingDto.setEnemyTimeSpawnPercent2(playerLevelSetting.getEnemyTimeSpawnPercent2());

        return settingDto;
    }
}

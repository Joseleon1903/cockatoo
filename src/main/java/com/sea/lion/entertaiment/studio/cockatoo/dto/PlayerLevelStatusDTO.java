package com.sea.lion.entertaiment.studio.cockatoo.dto;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelStatus;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import lombok.Data;

/**
 * Created by jose eduardo on 1/1/2020.
 */
@Data
public class PlayerLevelStatusDTO {

    private String buildId;

    private String levelName;

    private int playerPoints;

    private String playerCompleteTime;

    private int playerLife;

    private String isLevelComplete;

    private int playerRetryIntent;

    public PlayerLevelStatusDTO(){}

    public PlayerLevelStatusDTO(String buildId, String levelName, int playerPoints, String playerCompleteTime,int playerLife, String isLevelComplete, int playerRetryIntent) {
        this.buildId = buildId;
        this.levelName = levelName;
        this.playerPoints = playerPoints;
        this.playerLife = playerLife;
        this.playerCompleteTime = playerCompleteTime;
        this.isLevelComplete = isLevelComplete;
        this.playerRetryIntent = playerRetryIntent;
    }

    public static PlayerLevelStatus toEntity(PlayerLevelStatusDTO playerLevelStatusDTO){
        PlayerLevelStatus status = new PlayerLevelStatus();
        SystemPlayer player = new SystemPlayer(playerLevelStatusDTO.getBuildId());
        status.setSystemPlayer(player);
        status.setLevelName(playerLevelStatusDTO.getLevelName());
        status.setPlayerPoints(playerLevelStatusDTO.getPlayerPoints());
        status.setPlayerLife(playerLevelStatusDTO.getPlayerLife());
        status.setPlayerCompleteTime(playerLevelStatusDTO.getPlayerCompleteTime());
        status.setIsLevelComplete(playerLevelStatusDTO.getIsLevelComplete());
        status.setPlayerRetryIntent(playerLevelStatusDTO.getPlayerRetryIntent());
        return status;
    }

    public static PlayerLevelStatusDTO toObject(PlayerLevelStatus playerLevelStatus){
        PlayerLevelStatusDTO statusDTO = new PlayerLevelStatusDTO();
        statusDTO.setBuildId(playerLevelStatus.getSystemPlayer().getBuildId());
        statusDTO.setPlayerPoints(playerLevelStatus.getPlayerPoints());
        statusDTO.setPlayerLife(playerLevelStatus.getPlayerLife());
        statusDTO.setPlayerCompleteTime(playerLevelStatus.getPlayerCompleteTime());
        statusDTO.setIsLevelComplete(playerLevelStatus.getIsLevelComplete());
        statusDTO.setLevelName(playerLevelStatus.getLevelName());
        statusDTO.setPlayerRetryIntent(playerLevelStatus.getPlayerRetryIntent());
        return statusDTO;
    }
}
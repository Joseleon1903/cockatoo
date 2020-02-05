package com.sea.lion.entertaiment.studio.cockatoo.dto;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 1/1/2020.
 */
@Data
public class PlayerInfoDTO {

    private String buildId;

    private String gameName;

    private String platform;

    private String creationDate;

    private List<PlayerLevelSettingDTO> levelSettingDTOList;

    private List<PlayerLevelStatusDTO> levelStatusDTOList;

    public static SystemPlayer toEntity(PlayerInfoDTO playerInfoDTO){
        SystemPlayer player = new SystemPlayer();
        player.setBuildId(playerInfoDTO.getBuildId());
        player.setCreationDate(playerInfoDTO.getCreationDate());
        player.setGameName(playerInfoDTO.getGameName());
        player.setPlatform(playerInfoDTO.getPlatform());
        return player;
    }

    public static PlayerInfoDTO toObject(SystemPlayer systemPlayer){
        PlayerInfoDTO playerInfoDTO = new PlayerInfoDTO();
        playerInfoDTO.setBuildId(systemPlayer.getBuildId());
        playerInfoDTO.setCreationDate(systemPlayer.getCreationDate());
        playerInfoDTO.setGameName(systemPlayer.getGameName());
        playerInfoDTO.setPlatform(systemPlayer.getPlatform());
        return playerInfoDTO;
    }

    public static List<PlayerInfoDTO> toObjectList(List<SystemPlayer> systemPlayerList){
        List<PlayerInfoDTO> listDto = new ArrayList<>();
        PlayerInfoDTO dto;
        for(SystemPlayer sys : systemPlayerList){
            dto = new PlayerInfoDTO();
            dto = PlayerInfoDTO.toObject(sys);
            listDto.add(dto);
        }
        return listDto;
    }

}

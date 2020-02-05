package com.sea.lion.entertaiment.studio.cockatoo.service;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelStatus;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerInfoDTO;

import java.util.List;

/**
 * Created by jose eduardo on 12/30/2019.
 */
public interface PlayerService {

    void registerPlayer(SystemPlayer systemPlayer);

    boolean existBuildId(String buildId);

    void updatePlayerLevelSetting(PlayerLevelSetting playerLevelSetting);

    void updatePlayerLevelStatus(PlayerLevelStatus playerLevelStatus);

    PlayerInfoDTO getPlayerInfomation(String buildid);

    List<PlayerInfoDTO> getAllPlayers();

}

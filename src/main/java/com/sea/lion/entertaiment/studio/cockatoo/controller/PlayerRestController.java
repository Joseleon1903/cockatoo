package com.sea.lion.entertaiment.studio.cockatoo.controller;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelStatus;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerInfoDTO;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerLevelSettingDTO;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerLevelStatusDTO;
import com.sea.lion.entertaiment.studio.cockatoo.exception.NotFoundBuildIdException;
import com.sea.lion.entertaiment.studio.cockatoo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@RestController
public class PlayerRestController {

    Logger logger = LoggerFactory.getLogger(PlayerRestController.class);

    @Autowired
    private PlayerService playerService;

    @PostMapping("/api/player")
    public ResponseEntity registerPlayer(@RequestBody SystemPlayer systemPlayer) {
        logger.debug("Entering registerPlayer");
        logger.debug("call PlayerService");

        playerService.registerPlayer(systemPlayer);

        logger.debug("exit PlayerService");
        logger.debug("returning PlayerService");

        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/player/update/lvl-setting")
    public ResponseEntity updatePlayerLevelSetting(@RequestBody PlayerLevelSettingDTO playerLevelSettingDto) {
        logger.debug("Entering updatePlayerLevelSetting");
        logger.debug("validate BuildId ");

        if(!playerService.existBuildId(playerLevelSettingDto.getBuildId())){
            throw new NotFoundBuildIdException();
        }

        logger.debug("parse to entity..");

        PlayerLevelSetting setting = PlayerLevelSettingDTO.toEntity(playerLevelSettingDto);

        logger.debug("entity parse: "+ setting);

        logger.debug("call PlayerService");
        playerService.updatePlayerLevelSetting(setting);
        logger.debug("end call PlayerService");

        logger.debug("returning PlayerService");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/player/update/lvl-status")
    public ResponseEntity updatePlayerLevelStatus(@RequestBody PlayerLevelStatusDTO playerLevelSettingDto) {
        logger.debug("Entering updatePlayerLevelStatus");
        logger.debug("validate BuildId ");

        if(!playerService.existBuildId(playerLevelSettingDto.getBuildId())){
            throw new NotFoundBuildIdException();
        }

        logger.debug("parse to entity..");

        PlayerLevelStatus playerLevelStatus = PlayerLevelStatusDTO.toEntity(playerLevelSettingDto);

        logger.debug("entity parse: "+ playerLevelStatus);

        logger.debug("call PlayerService");
        playerService.updatePlayerLevelStatus(playerLevelStatus);
        logger.debug("end call PlayerService");

        logger.debug("returning PlayerService");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/player")
    public ResponseEntity<PlayerInfoDTO> getPlayerInfo(@RequestParam("builId") String builId) {
        logger.debug("Entering getPlayerInfo");
        logger.debug("param BuildId : "+ builId);

        logger.debug("validate BuildId ");

        if(!playerService.existBuildId(builId)){
            throw new NotFoundBuildIdException();
        }

        logger.debug("call PlayerService");
        PlayerInfoDTO infoOut =playerService.getPlayerInfomation(builId);
        logger.debug("end call PlayerService");

        logger.debug("returning PlayerService");
        return ResponseEntity.ok(infoOut);
    }


    @GetMapping("/api/player/resume")
    public ResponseEntity<List<PlayerInfoDTO>> getPlayerResume() {

        logger.debug("Entering getPlayerResume");

        logger.debug("call PlayerService");
        List<PlayerInfoDTO> listOut  =playerService.getAllPlayers();
        logger.debug("end call PlayerService");

        logger.debug("returning PlayerService");
        logger.info("List size "+ listOut.size());
        return ResponseEntity.ok(listOut);
    }

}

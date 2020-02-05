package com.sea.lion.entertaiment.studio.cockatoo.service;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelStatus;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerInfoDTO;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerLevelSettingDTO;
import com.sea.lion.entertaiment.studio.cockatoo.dto.PlayerLevelStatusDTO;
import com.sea.lion.entertaiment.studio.cockatoo.exception.DataDuplicateException;
import com.sea.lion.entertaiment.studio.cockatoo.exception.IntegrityException;
import com.sea.lion.entertaiment.studio.cockatoo.repository.JpaPlayerLevelSettingRepository;
import com.sea.lion.entertaiment.studio.cockatoo.repository.JpaPlayerLevelStatusRepository;
import com.sea.lion.entertaiment.studio.cockatoo.repository.JpaSystemPlayerRepository;
import com.sea.lion.entertaiment.studio.cockatoo.validation.PlayerServiceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@Service
public class PlayerServiceImpl implements PlayerService{

    Logger logger = LoggerFactory.getLogger(PlayerService.class);

    private JpaSystemPlayerRepository jpaSystemPlayerRepository;

    private JpaPlayerLevelSettingRepository jpaPlayerLevelSettingRepository;

    private JpaPlayerLevelStatusRepository jpaPlayerLevelStatusRepository;

    public PlayerServiceImpl(JpaSystemPlayerRepository jpaSystemPlayerRepository, JpaPlayerLevelSettingRepository jpaPlayerLevelSettingRepository,
                             JpaPlayerLevelStatusRepository jpaPlayerLevelStatusRepository) {
        this.jpaSystemPlayerRepository = jpaSystemPlayerRepository;
        this.jpaPlayerLevelSettingRepository = jpaPlayerLevelSettingRepository;
        this.jpaPlayerLevelStatusRepository = jpaPlayerLevelStatusRepository;
    }

    @Override
    public void registerPlayer(SystemPlayer systemPlayer) {
        logger.debug("Entering in method registerPlayer");
        logger.debug("param : "+ systemPlayer);

        logger.debug("validate param");
        if(PlayerServiceValidator.playerSystemIntegrityValidation(systemPlayer)){
            throw new IntegrityException();
        }
        SystemPlayer duplicate = jpaSystemPlayerRepository.findByBuildId(systemPlayer.getBuildId());
        if(duplicate != null){
            throw new DataDuplicateException();

        }
        logger.debug("validate param is successfull");
        jpaSystemPlayerRepository.save(systemPlayer);
        logger.debug("save param is successfull");
    }

    @Override
    public boolean existBuildId(String buildId) {
        logger.debug("Entering in method existBuildId");
        logger.debug("param buildId : "+ buildId);
        SystemPlayer player =jpaSystemPlayerRepository.findByBuildId(buildId);

        if(player != null){
            return true;
        }
        return false;
    }

    @Override
    public void updatePlayerLevelSetting(PlayerLevelSetting playerLevelSetting) {
        logger.debug("Entering in method updatePlayerLevelSetting");
        logger.debug("param : "+ playerLevelSetting);

        logger.debug("search player build ");
        SystemPlayer player =jpaSystemPlayerRepository.findByBuildId(playerLevelSetting.getSystemPlayer().getBuildId());
        logger.debug("finish search player build ");

        logger.debug("validate level reference ");
        PlayerLevelSetting settingRef = jpaPlayerLevelSettingRepository.findByLevelReferenceName(playerLevelSetting.getLevelReferenceName());

        if(settingRef != null){
            logger.debug("exist level reference update reference ");
            playerLevelSetting.setId(settingRef.getId());
        }
        playerLevelSetting.setSystemPlayer(player);

        jpaPlayerLevelSettingRepository.save(playerLevelSetting);
        logger.debug("save param is successfull");
    }

    @Override
    public void updatePlayerLevelStatus(PlayerLevelStatus playerLevelStatus) {

        logger.debug("Entering in method updatePlayerLevelStatus");
        logger.debug("param : "+ playerLevelStatus);

        logger.debug("search player build ");
        SystemPlayer player =jpaSystemPlayerRepository.findByBuildId(playerLevelStatus.getSystemPlayer().getBuildId());
        logger.debug("finish search player build ");

        playerLevelStatus.setSystemPlayer(player);

        if(playerLevelStatus.getIsLevelComplete().equalsIgnoreCase("FALSE")){

            PlayerLevelStatus playerLevelStatusRepo = jpaPlayerLevelStatusRepository.findByLevelName(playerLevelStatus.getLevelName());

            if(playerLevelStatusRepo != null) {
                int newIntent = playerLevelStatusRepo.getPlayerRetryIntent() + 1;
                playerLevelStatusRepo.setPlayerRetryIntent(newIntent);
                playerLevelStatus = playerLevelStatusRepo;
            }else{
                playerLevelStatus.setPlayerRetryIntent(1);
            }
        }

        if(playerLevelStatus.getIsLevelComplete().equalsIgnoreCase("TRUE")){

            PlayerLevelStatus playerLevelStatusRepo = jpaPlayerLevelStatusRepository.findByLevelName(playerLevelStatus.getLevelName());

            if(playerLevelStatusRepo != null) {
                playerLevelStatus.setId(playerLevelStatusRepo.getId());
                playerLevelStatus.setPlayerRetryIntent(playerLevelStatusRepo.getPlayerRetryIntent());
            }
        }

        jpaPlayerLevelStatusRepository.save(playerLevelStatus);

        logger.debug("save is successfull");

    }

    @Override
    public PlayerInfoDTO getPlayerInfomation(String buildid) {
        logger.debug("Entering in method getPlayerInformation");

        PlayerInfoDTO info = new PlayerInfoDTO();
        SystemPlayer player = jpaSystemPlayerRepository.findByBuildId(buildid);
        info.setBuildId(player.getBuildId());
        info.setCreationDate(player.getCreationDate());
        info.setGameName(player.getGameName());
        info.setPlatform(player.getPlatform());

        List<PlayerLevelSetting> settinglist = jpaPlayerLevelSettingRepository.findBySystemPlayerBuildId(buildid);
        List<PlayerLevelSettingDTO> listSettingDto = new ArrayList<>();

        for (PlayerLevelSetting set: settinglist) {
            listSettingDto.add(PlayerLevelSettingDTO.toObject(set));
        }
        info.setLevelSettingDTOList(listSettingDto);

        List<PlayerLevelStatus> statusList = jpaPlayerLevelStatusRepository.findBySystemPlayerBuildId(buildid);
        List<PlayerLevelStatusDTO> listStatusDto = new ArrayList<>();

        for (PlayerLevelStatus set: statusList) {
            listStatusDto.add(PlayerLevelStatusDTO.toObject(set));
        }

        info.setLevelSettingDTOList(listSettingDto);
        info.setLevelStatusDTOList(listStatusDto);

        logger.debug("exiting method getPlayerInformation");
        return info;
    }

    @Override
    public List<PlayerInfoDTO> getAllPlayers() {
        logger.debug("Entering in method getAllPlayers");
        List<SystemPlayer> listPlayer = jpaSystemPlayerRepository.findAll();
        List<PlayerInfoDTO> listOut = PlayerInfoDTO.toObjectList(listPlayer);
        logger.debug("Exiting in method getAllPlayers");
        return listOut;
    }
}
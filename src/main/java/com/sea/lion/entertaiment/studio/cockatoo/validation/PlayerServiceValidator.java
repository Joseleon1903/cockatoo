package com.sea.lion.entertaiment.studio.cockatoo.validation;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;

/**
 * Created by jose eduardo on 12/30/2019.
 */
public class PlayerServiceValidator {

    private PlayerServiceValidator(){}

    public static boolean playerSystemIntegrityValidation(SystemPlayer systemPlayer){

        if(systemPlayer.getBuildId().isEmpty() || systemPlayer.getGameName().isEmpty() ||
                systemPlayer.getPlatform().isEmpty() || systemPlayer.getCreationDate().isEmpty()){
            return true;
        }
        return false;
    }

}
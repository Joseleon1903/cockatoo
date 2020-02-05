package com.sea.lion.entertaiment.studio.cockatoo.repository;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jose eduardo on 12/30/2019.
 */
public interface JpaPlayerLevelSettingRepository extends CrudRepository<PlayerLevelSetting, Long> {

    List<PlayerLevelSetting> findBySystemPlayerBuildId(String buildId);

    PlayerLevelSetting findByLevelReferenceName(String levelReferenceName);

}

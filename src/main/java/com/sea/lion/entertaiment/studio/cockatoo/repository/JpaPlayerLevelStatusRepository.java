package com.sea.lion.entertaiment.studio.cockatoo.repository;

import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jose eduardo on 12/30/2019.
 */
public interface JpaPlayerLevelStatusRepository extends CrudRepository<PlayerLevelStatus, Long> {

    List<PlayerLevelStatus> findBySystemPlayerBuildId(String buildId);

    PlayerLevelStatus findByLevelName(String levelName);
}

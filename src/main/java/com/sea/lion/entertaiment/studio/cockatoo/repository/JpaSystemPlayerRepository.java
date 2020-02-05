package com.sea.lion.entertaiment.studio.cockatoo.repository;

import com.sea.lion.entertaiment.studio.cockatoo.domain.SystemPlayer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jose eduardo on 12/30/2019.
 */
public interface JpaSystemPlayerRepository extends CrudRepository<SystemPlayer, Long>{

    SystemPlayer findByBuildId(String buildId);

    @Override
    List<SystemPlayer> findAll();

}

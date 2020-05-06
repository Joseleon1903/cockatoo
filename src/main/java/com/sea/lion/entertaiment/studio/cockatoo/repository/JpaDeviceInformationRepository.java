package com.sea.lion.entertaiment.studio.cockatoo.repository;

import com.sea.lion.entertaiment.studio.cockatoo.domain.DeviceInformation;
import com.sea.lion.entertaiment.studio.cockatoo.domain.PlayerLevelSetting;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 5/6/2020.
 */
public interface JpaDeviceInformationRepository extends CrudRepository<DeviceInformation, Long> {

    DeviceInformation findByDeviceName(String deviceName);

}

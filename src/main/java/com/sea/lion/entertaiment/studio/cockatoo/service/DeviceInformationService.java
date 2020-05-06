package com.sea.lion.entertaiment.studio.cockatoo.service;

import com.sea.lion.entertaiment.studio.cockatoo.domain.DeviceInformation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jose eduardo on 5/6/2020.
 */
public interface DeviceInformationService {

    void registerInformation(DeviceInformation device);

    List<DeviceInformation> getAllInformation();
}

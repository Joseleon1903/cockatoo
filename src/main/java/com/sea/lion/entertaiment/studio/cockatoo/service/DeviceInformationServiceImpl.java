package com.sea.lion.entertaiment.studio.cockatoo.service;

import com.sea.lion.entertaiment.studio.cockatoo.domain.DeviceInformation;
import com.sea.lion.entertaiment.studio.cockatoo.repository.JpaDeviceInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 5/6/2020.
 */
@Service
public class DeviceInformationServiceImpl implements DeviceInformationService{


    Logger logger = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    private JpaDeviceInformationRepository jpaDeviceInformationRepository;


    @Override
    public void registerInformation(DeviceInformation device) {
        logger.debug("Entering in method registerInformation");
        logger.debug("param : "+ device);
        logger.debug("search device whit the same name");
        DeviceInformation storeDevice = jpaDeviceInformationRepository.findByDeviceName(device.getDeviceName());

        if(storeDevice == null){
            logger.debug("device with the same name is not found");
            logger.debug("save new Device: "+device);
            jpaDeviceInformationRepository.save(device);
        }
    }

    @Override
    public List<DeviceInformation> getAllInformation() {
        List<DeviceInformation> listOut = new ArrayList<>();
        jpaDeviceInformationRepository.findAll().forEach(item ->{
            listOut.add(item);
        });
        return listOut;
    }
}

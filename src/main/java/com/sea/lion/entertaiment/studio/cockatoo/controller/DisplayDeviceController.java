package com.sea.lion.entertaiment.studio.cockatoo.controller;

import com.sea.lion.entertaiment.studio.cockatoo.domain.DeviceInformation;
import com.sea.lion.entertaiment.studio.cockatoo.dto.DeviceInformationDTO;
import com.sea.lion.entertaiment.studio.cockatoo.service.DeviceInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jose eduardo on 5/6/2020.
 */
@RestController
public class DisplayDeviceController {

    Logger logger = LoggerFactory.getLogger(PlayerRestController.class);

    @Autowired
    private DeviceInformationService deviceInformationService;

    @PostMapping("/api/device/information/update")
    public ResponseEntity updateDeviceInformation(@RequestBody DeviceInformationDTO deviceInformationDTO) {
        logger.debug("Entering updateDeviceInformation");
        DeviceInformation entity = DeviceInformationDTO.toEntity(deviceInformationDTO);
        logger.debug("entity parse: "+ entity);

        logger.debug("call deviceInformationService");
        deviceInformationService.registerInformation(entity);
        logger.debug("end call deviceInformationService");

        logger.debug("returning PlayerService");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/device/information/get")
    public ResponseEntity<List<DeviceInformation>> getDeviceInformationDisplay() {

        logger.debug("call deviceInformationService");
        List<DeviceInformation> resumenInformation = deviceInformationService.getAllInformation();
        logger.debug("end call deviceInformationService");

        logger.debug("returning PlayerService");
        return ResponseEntity.ok(resumenInformation);
    }

}

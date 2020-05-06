package com.sea.lion.entertaiment.studio.cockatoo.dto;

import com.sea.lion.entertaiment.studio.cockatoo.domain.DeviceInformation;
import lombok.Data;

/**
 * Created by jose eduardo on 5/6/2020.
 */
@Data
public class DeviceInformationDTO {

    private int height;
    private int width;
    private String deviceName;
    private String displayOrientation;

    public static DeviceInformation toEntity(DeviceInformationDTO deviceInformationDTO){
        DeviceInformation entity = new DeviceInformation();
        entity.setDeviceName(deviceInformationDTO.getDeviceName());
        entity.setDisplayOrientation(deviceInformationDTO.getDisplayOrientation());
        entity.setHeight(deviceInformationDTO.getHeight());
        entity.setWidth(deviceInformationDTO.getWidth());
        return entity;
    }


}

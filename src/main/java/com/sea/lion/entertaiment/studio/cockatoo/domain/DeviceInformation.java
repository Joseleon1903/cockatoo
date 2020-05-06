package com.sea.lion.entertaiment.studio.cockatoo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jose eduardo on 5/6/2020.
 */
@Data
@Entity
public class DeviceInformation {

    @Id
    @GeneratedValue
    private long id;

    private int Height;
    private int Width;
    private String deviceName;
    private String displayOrientation;



}

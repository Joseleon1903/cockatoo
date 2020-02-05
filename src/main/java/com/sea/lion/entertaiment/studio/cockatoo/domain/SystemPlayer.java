package com.sea.lion.entertaiment.studio.cockatoo.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@Data
@Entity
public class SystemPlayer {

    @Id
    @GeneratedValue
    private long id;

    private String buildId;

    private String gameName;

    private String platform;

    private String creationDate;

    public SystemPlayer() {}

    public SystemPlayer(String buildId) {
        this.buildId = buildId;
    }

    public SystemPlayer(String buildId, String gameName, String platform, String creationDate) {
        this.buildId = buildId;
        this.gameName = gameName;
        this.platform = platform;
        this.creationDate = creationDate;
    }
}

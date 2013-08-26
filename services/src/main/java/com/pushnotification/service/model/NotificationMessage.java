package com.pushnotification.service.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 1/7/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationMessage implements Serializable {
    public String deviceToken;
    public String deviceType;
    public String message;
    public int targetId;
    public List<String> regIds;
    public NotificationMessage() {
    }

    public NotificationMessage(String deviceToken, String deviceType, String message, int targetId) {

        this.deviceToken = deviceToken;
        this.deviceType = deviceType;
        this.message = message;
        this.targetId = targetId;
    }

    public NotificationMessage(String deviceType, String message, List<String> regIds) {

        this.deviceToken = deviceToken;
        this.deviceType = deviceType;
        this.message = message;
        this.regIds = regIds;
    }
}

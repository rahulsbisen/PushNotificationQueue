package com.pushnotification.service.rest;

import com.pushnotification.service.concurrency.PushNotificationSender;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("pushService")
public class PushService {

    private PushNotificationSender pushNotificationSender;

    @POST
    @Produces({"application/xml", "application/json"})
    public Response pushMessage(@FormParam("deviceToken") String deviceToken, @FormParam("deviceType") String deviceType,@FormParam("message") String message,@FormParam("targetId") Integer targetId){
        pushNotificationSender.sendStatusNotification(deviceToken, deviceType, message, targetId);
        return Response.ok().build();
    }


    public PushNotificationSender getPushNotificationSender() {
        return pushNotificationSender;
    }

    public void setPushNotificationSender(PushNotificationSender pushNotificationSender) {
        this.pushNotificationSender = pushNotificationSender;
    }
}

package com.pushnotification.service.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pushnotification.service.concurrency.PushNotificationSender;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Path("pushService")
public class PushService {

    private PushNotificationSender pushNotificationSender;

    private Gson gson;

    @POST
    @Produces({"application/xml", "application/json"})
    public Response pushMessage(@FormParam("deviceToken") String deviceToken, @FormParam("deviceType") String deviceType,@FormParam("message") String message,@FormParam("targetId") Integer targetId){
        pushNotificationSender.sendStatusNotification(deviceToken, deviceType, message, targetId);
        return Response.ok().build();
    }

    @POST
    @Produces({"application/xml", "application/json"})
    @Path("group")
    public Response pushMessageToGroup(@FormParam("deviceType") String deviceType,@FormParam("message") String message,@FormParam("targetIds") String targetIds){
        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        List<String> regIds = gson.fromJson(targetIds,listType);
        pushNotificationSender.sendStatusNotification(deviceType, message, regIds);
        return Response.ok().build();
    }

    public PushNotificationSender getPushNotificationSender() {
        return pushNotificationSender;
    }

    public void setPushNotificationSender(PushNotificationSender pushNotificationSender) {
        this.pushNotificationSender = pushNotificationSender;
    }
    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}

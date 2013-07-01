package com.pushnotification.service.notification;

import com.pushnotification.service.model.DeviceType;
import com.pushnotification.service.model.NotificationMessage;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 18/04/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationServiceFactory {

    public static AndroidPushNotificationService androidPushNotificationService = new AndroidPushNotificationService();
    public static ApplePushNotificationService applePushNotificationService = new ApplePushNotificationService();

    public static void notify(NotificationMessage notificationMessage) throws IOException, InvalidDeviceTokenFormatException, KeystoreException, CommunicationException, JSONException {
        if (DeviceType.ANDROID.equalsIgnoreCase(notificationMessage.deviceType)) {
            androidPushNotificationService.pushNotification(notificationMessage);
        } else if (DeviceType.IOS.equalsIgnoreCase(notificationMessage.deviceType)) {
            applePushNotificationService.pushNotification(notificationMessage);
        }
    }
}

package com.pushnotification.service.notification;

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
public abstract class PushNotificationService {
    public abstract void pushNotification(NotificationMessage statusNotificationMessage) throws CommunicationException, KeystoreException, InvalidDeviceTokenFormatException, IOException, JSONException;
}

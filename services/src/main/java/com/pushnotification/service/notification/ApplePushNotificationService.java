package com.pushnotification.service.notification;

import com.pushnotification.service.model.NotificationMessage;
import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import org.json.JSONException;

public class ApplePushNotificationService extends PushNotificationService {

    public static final String CERTIFICATE_FILE = "APNSCertificateKey.p12";
    public static final String PASSWORD = "{CERTIFICATE_PASSWORD}";
    public static final boolean IS_PRODUCTION = true;

    @Override
    public void pushNotification(NotificationMessage notificationMessage) throws CommunicationException, KeystoreException, InvalidDeviceTokenFormatException, JSONException {
    Push.alert(notificationMessage.message, this.getClass().getClassLoader().
                getResourceAsStream(CERTIFICATE_FILE), PASSWORD, IS_PRODUCTION, notificationMessage.deviceToken);
    }
}

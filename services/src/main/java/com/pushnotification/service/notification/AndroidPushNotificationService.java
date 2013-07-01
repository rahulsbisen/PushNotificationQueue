package com.pushnotification.service.notification;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.pushnotification.service.model.NotificationMessage;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Properties;

public class AndroidPushNotificationService extends PushNotificationService {
    private Properties configFile = new Properties();
    private static final Log log = LogFactory.getLog(AndroidPushNotificationService.class);

    private String getGoogleCloudMessagingAPIKey() throws IOException {
        configFile.load(NotificationServiceFactory.class.getClassLoader().getResourceAsStream("./googleCloudMessaging.properties"));
        return configFile.getProperty("GoogleCloudMessagingAPIKey");
    }

    @Override
    public void pushNotification(NotificationMessage notificationMessage) throws CommunicationException, KeystoreException, InvalidDeviceTokenFormatException, IOException {
        Sender sender = new Sender(getGoogleCloudMessagingAPIKey());
        Message m = new Message.Builder()
                .addData("notification.key", notificationMessage.message)
                .addData("request.id", Integer.toString(notificationMessage.targetId))
                .build();
        Result send = sender.send(m, notificationMessage.deviceToken, 5);
        log.info(send.toString());
    }
}

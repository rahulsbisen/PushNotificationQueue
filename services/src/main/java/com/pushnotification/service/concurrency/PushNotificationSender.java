package com.pushnotification.service.concurrency;

import com.pushnotification.service.model.DeviceType;
import com.pushnotification.service.model.NotificationMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PushNotificationSender {
    private final JmsTemplate jmsTemplate;
    private static final Log log = LogFactory.getLog(PushNotificationSender.class);

    @Autowired
    public PushNotificationSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendStatusNotification(String deviceToken, String deviceType, String message, int targetId) {
        NotificationMessage notificationMessage = new NotificationMessage(deviceToken, deviceType, message, targetId);
        jmsTemplate.convertAndSend("Queue.PushNotification", notificationMessage);
        log.info(notificationMessage.toString());
    }

    public void sendStatusNotification(String deviceType, String message, List<String> regIds) {
        NotificationMessage notificationMessage = new NotificationMessage(deviceType, message, regIds);
        jmsTemplate.convertAndSend("Queue.PushNotification", notificationMessage);
        log.info(notificationMessage.toString());
    }
}


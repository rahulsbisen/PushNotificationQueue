package com.pushnotification.service.concurrency;

import com.pushnotification.service.model.NotificationMessage;
import com.pushnotification.service.notification.NotificationServiceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

@Component
public class PushNotificationListener implements MessageListener {
    private static final Log log = LogFactory.getLog(PushNotificationListener.class);

    public void onMessage(final Message message) {
        if (message instanceof ObjectMessage) {
            final ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                NotificationMessage notificationMessage = (NotificationMessage) objectMessage.getObject();
                NotificationServiceFactory.notify(notificationMessage);
            } catch (final Exception e) {
                log.error(e.toString(), e);
            }
        }
    }
}

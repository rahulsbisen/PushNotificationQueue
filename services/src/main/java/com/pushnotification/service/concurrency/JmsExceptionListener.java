package com.pushnotification.service.concurrency;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JmsExceptionListener implements ExceptionListener {
    private static final Log log = LogFactory.getLog(JmsExceptionListener.class);

    public void onException(final JMSException e) {
        log.error(e.toString(),e);
    }
}

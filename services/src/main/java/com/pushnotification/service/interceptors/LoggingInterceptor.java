package com.pushnotification.service.interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.util.Set;

@Provider
@ServerInterceptor
@Component
public class LoggingInterceptor implements PreProcessInterceptor {
    private static final Log log = LogFactory.getLog(LoggingInterceptor.class);

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethodInvoker resourceMethodInvoker) throws Failure, WebApplicationException {
        try {
            StringBuilder sb = new StringBuilder();
            UriInfo uri = request.getUri();
            sb.append("Request Method: ");
            sb.append(request.getHttpMethod());
            sb.append(", Request URI: ");
            sb.append(uri.getAbsolutePath());

            MultivaluedMap<String, String> formParameters = request.getFormParameters();

            Set<String> keys = formParameters.keySet();
            int mapSize = keys.size();
            if (mapSize > 0) {
                sb.append(", Incoming parameters: ");
                int processedParams = 1;
                for (String key : keys) {
                    sb.append(key).append("=");
                    sb.append(formParameters.get(key));
                    if (processedParams < mapSize) {
                        sb.append(", ");
                    }
                    processedParams++;
                }

            }
            log.info(sb.toString());
        } catch (Exception ex) {
            log.error(ex.toString(), ex);
        }
        return null;
    }
}

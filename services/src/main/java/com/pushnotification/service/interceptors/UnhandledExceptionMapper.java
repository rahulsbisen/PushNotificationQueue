package com.pushnotification.service.interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component
public class UnhandledExceptionMapper implements ExceptionMapper<Exception> {
    private static final Log log = LogFactory.getLog(UnhandledExceptionMapper.class);

    @Override
    public Response toResponse(Exception e) {
        log.error(e.toString(),e);
        return Response.serverError().entity(e.toString()).build();
    }
}

package com.xiaomi.servergateway.config.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: GlobalExceptionHandler
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/6/12 0012 上午 11:13
 * @email: a1205938863@gmail.com
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger( GlobalExceptionHandler.class );

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error( request.getContextPath() );
        logger.error( e.getLocalizedMessage() );
        return e.getMessage();
    }
}

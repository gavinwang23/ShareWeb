package com.share.handler;

import com.share.entity.GlobalExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class GlobalControllerAdviceHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalControllerAdviceHandler.class);

    /**
     * 处理IOException，并返回502错误, 即"Bad Gateway"
     * @param ex
     * @return
     */
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public void handleIOException(IOException ex) {

    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public GlobalExceptionResponse handleException(Exception e) {
        GlobalExceptionResponse response = new GlobalExceptionResponse();
        response.setCode(-1);
        response.setMessage(e.getMessage());
        return response;
    }

}

package com.kbs.templateortest.exception.handler;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /* NullPointerException.class에 해당하는 오류 발생시 아래와 같이 처리 */
    @ExceptionHandler({NullPointerException.class})
    public String nullPointerExceptionHandle(NullPointerException ex){
        return "nullPointerException 발생!!!";
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String httpRequestMethodNotSupportedExceptionHandle(HttpRequestMethodNotSupportedException ex){
        return "HttpRequestMethodNotSupportedException 발생!!!";
    }


}

package com.sea.lion.entertaiment.studio.cockatoo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= {IntegrityException.class})
    protected ResponseEntity<Object> handleIntegrity(RuntimeException ex, WebRequest request) {

        IntegrityException integrityException = (IntegrityException) ex;
        String response = integrityException.toString();
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value= {DataDuplicateException.class})
    protected ResponseEntity<Object> handleDataDuplicate(RuntimeException ex, WebRequest request) {

        DataDuplicateException integrityException = (DataDuplicateException) ex;
        String response = integrityException.toString();
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value= {NotFoundBuildIdException.class})
    protected ResponseEntity<Object> handleNotBuildid(RuntimeException ex, WebRequest request) {
        NotFoundBuildIdException integrityException = (NotFoundBuildIdException) ex;
        String response = integrityException.toString();
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
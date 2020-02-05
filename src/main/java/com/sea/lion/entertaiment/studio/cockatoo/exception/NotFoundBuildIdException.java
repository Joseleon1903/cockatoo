package com.sea.lion.entertaiment.studio.cockatoo.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by jose eduardo on 1/1/2020.
 */
public class NotFoundBuildIdException extends RuntimeException {

    private String message = "There is no a build id in the system";
    private String code ="11";
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public NotFoundBuildIdException(){}

    public NotFoundBuildIdException(Throwable cause, String message, String code, HttpStatus status) {
        super(message, cause);
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public NotFoundBuildIdException(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    @Override
    public String toString() {
        return "NotFoundBuildIdException:{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}

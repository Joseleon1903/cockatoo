package com.sea.lion.entertaiment.studio.cockatoo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@Data
public class DataDuplicateException extends RuntimeException {

    private String message = "There are data already registered in the system";
    private String code ="22";
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public DataDuplicateException(){}

    public DataDuplicateException(Throwable cause, String message, String code, HttpStatus status) {
        super(message, cause);
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public DataDuplicateException(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DataDuplicateException: {" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
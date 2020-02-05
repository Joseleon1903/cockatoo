package com.sea.lion.entertaiment.studio.cockatoo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by jose eduardo on 12/30/2019.
 */
@Data
public class IntegrityException extends RuntimeException {

    private String message = "There is data provided invalid";
    private String code ="55";
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public IntegrityException(){}

    public IntegrityException(Throwable cause, String message, String code, HttpStatus status) {
        super(message, cause);
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public IntegrityException(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    @Override
    public String toString() {
        return "IntegrityException:{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}

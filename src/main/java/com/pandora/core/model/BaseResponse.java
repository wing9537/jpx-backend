package com.pandora.core.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseResponse extends ResponseEntity<Object> {

    public BaseResponse(HttpStatus status) {
        super(status);
    }

    public BaseResponse(Object body, HttpStatus status) {
        super(body, status);
    }

    public BaseResponse(Object body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public static final BaseResponse ok = new BaseResponse(HttpStatus.OK);

    static public final BaseResponse badRequest = new BaseResponse(HttpStatus.BAD_REQUEST);

    static public final BaseResponse notFound = new BaseResponse(HttpStatus.NOT_FOUND);

    static public final BaseResponse noContent = new BaseResponse(HttpStatus.NO_CONTENT);

    static public final BaseResponse unauthorized = new BaseResponse(HttpStatus.UNAUTHORIZED);

    public static BaseResponse accept(Object body) {
        log.debug("accept: {}", body);
        return new BaseResponse(body, HttpStatus.OK);
    }

    public static BaseResponse reject(Object body) {
        log.debug("reject: {}", body);
        return new BaseResponse(body, HttpStatus.BAD_REQUEST);
    }

}

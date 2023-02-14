package com.pandora.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pandora.core.model.BaseId;
import com.pandora.core.utils.BaseValidationUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BaseIdConverter implements Converter<String, BaseId> {

    @Autowired
    private BaseAesHandler baseAesHandler;

    @Override
    public BaseId convert(String text) {
        try {
            if (BaseValidationUtil.isBase64(text)) {
                return new BaseId(baseAesHandler.decrypt(text));
            }
        } catch (Exception e) {
            log.error("Invalid decoding", e);
        }
        return null;
    }

}

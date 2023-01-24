package com.pandora.core.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BaseJsonEncodeHandler extends StdSerializer<Integer> {

    @Autowired
    private BaseAesHandler baseAesHandler;

    public BaseJsonEncodeHandler() {
        this(null);
    }

    public BaseJsonEncodeHandler(Class<Integer> t) {
        super(t);
    }

    @Override
    public void serialize(Integer num, JsonGenerator generator, SerializerProvider provider) throws IOException {
        try {
            // convert a number field to encrypted string
            generator.writeString(baseAesHandler.encrypt(num.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            generator.writeNull();
        }
    }

}

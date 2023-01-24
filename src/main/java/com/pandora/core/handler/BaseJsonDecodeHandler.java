package com.pandora.core.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BaseJsonDecodeHandler extends StdDeserializer<Integer> {
    
    @Autowired
    private BaseAesHandler baseAesHandler;

    public BaseJsonDecodeHandler() {
        this(null);
    }

    public BaseJsonDecodeHandler(Class<?> vc) {
        super(vc);
    }

    @Override
    public Integer deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        try {
            // assume decrypted string must be an integer.
            return Integer.parseInt(baseAesHandler.decrypt(parser.getText()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

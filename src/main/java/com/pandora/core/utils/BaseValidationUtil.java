package com.pandora.core.utils;

public class BaseValidationUtil {

    private static final String REGEX_base64 = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

    private static final String REGEX_base64Url = "^([A-Za-z0-9_-]{4})*([A-Za-z0-9_-]{3}=|[A-Za-z0-9_-]{2}==)?$";

    private static final String REGEX_email = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isBase64(String text) {
        return text.matches(REGEX_base64);
    }

    public static boolean isBase64Url(String text) {
        return text.matches(REGEX_base64Url);
    }

    public static boolean isEmail(String text) {
        return text.matches(REGEX_email);
    }

}

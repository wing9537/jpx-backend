package com.pandora.core.utils;

import org.springframework.beans.BeanUtils;

public class BaseConversionUtil {

    public static <T, S> void copyProperties(S source, T target) {
        BeanUtils.copyProperties(source, target);
    }

}

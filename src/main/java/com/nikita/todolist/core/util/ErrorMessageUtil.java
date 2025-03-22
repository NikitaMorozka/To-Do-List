package com.nikita.todolist.core.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class ErrorMessageUtil {

    private final Properties props;

    ErrorMessageUtil() {
        try {
            props = PropertiesLoaderUtils.loadProperties(new ClassPathResource("errorCodes.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getErrorDescription(String errorCode) {
        return props.getProperty(errorCode);
    }

}

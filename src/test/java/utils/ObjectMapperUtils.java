package utils;

import org.codehaus.jackson.map.*;
import java.io.*;

public class ObjectMapperUtils {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static <T> T convertJsonToJava(String json, Class<T> cls) { // Generic method

        T javaResult;

        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return javaResult;
    }
}
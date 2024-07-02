package com.cognitive.cogdemver.utils;

import java.util.UUID;

public class ServiceUtil {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}

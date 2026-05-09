package com.project.notificationservice.utils;

import org.springframework.util.ObjectUtils;

public class NotificationServiceUtil {
    public static boolean isObjectNotEmpty(final Object object) {
        return !ObjectUtils.isEmpty(object);
    }

    public static boolean isObjectEmpty(final Object object) {
        return ObjectUtils.isEmpty(object);
    }
}

package com.project.notificationservice.config;

public final class NotificationContextHolder {
    private static final ThreadLocal<NotificationContext> holder = new ThreadLocal<>();

    public static void setContext(NotificationContext context) {
        holder.set(context);
    }

    public static NotificationContext getContext() {
        return holder.get();
    }

    public static void clearContext() {
        holder.remove();
    }
}

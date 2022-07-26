package com.ahsan.notification;

public record NotificationRequest(
        Integer toClientId,
        String toClientEmail,
        String message
) {
}

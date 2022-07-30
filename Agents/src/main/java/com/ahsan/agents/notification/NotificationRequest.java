package com.ahsan.agents.notification;

public record NotificationRequest(
        Integer toClientId,
        String toClientEmail,
        String message
) {
}

package com.ahsan.agents.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationAgent {

    @PostMapping({"api/v1/notification"})
    void sendNotification(NotificationRequest var1);
}

package com.ahsan.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public  void send(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .toClientId(notificationRequest.toClientId())
                        .toClientEmail(notificationRequest.toClientEmail())
                        .sender("ahsan")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}

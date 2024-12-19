package com.klef.jfsd.notification.service;

import com.klef.jfsd.clients.notifications.NotificationRequest;
import com.klef.jfsd.notification.model.Notification;
import com.klef.jfsd.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getCustomerId())
                        .toCustomerEmail(notificationRequest.getCustomerEmail())
                        .message(notificationRequest.getMessage())
                        .sender("Lalitesh")
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}

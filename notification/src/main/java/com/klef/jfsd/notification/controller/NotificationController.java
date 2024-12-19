package com.klef.jfsd.notification.controller;

import com.klef.jfsd.clients.notifications.NotificationRequest;
import com.klef.jfsd.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;


    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Sending notification request: {}", notificationRequest);
        notificationService.send(notificationRequest);
    }

}

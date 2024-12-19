package com.klef.jfsd.notification.rabbitmq;

import com.klef.jfsd.clients.notifications.NotificationRequest;
import com.klef.jfsd.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.notification.queue}")
    public void consume(NotificationRequest notificationRequest) {
        log.info("Consumed notification request from queue: {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}


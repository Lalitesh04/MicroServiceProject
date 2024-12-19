package com.klef.jfsd.clients.notifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private Integer customerId;
    private String customerEmail;
    private String message;
}

package com.klef.jfsd.customer.dto;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

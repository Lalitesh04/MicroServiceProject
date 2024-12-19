package com.klef.jfsd.customer.service;



import com.klef.jfsd.clients.fraud.FraudClient;
import com.klef.jfsd.clients.fraud.dto.FraudCheckResponse;
import com.klef.jfsd.clients.notifications.NotificationRequest;
import com.klef.jfsd.customer.dto.CustomerRegistrationRequest;
import com.klef.jfsd.customer.model.Customer;
import com.klef.jfsd.customer.repository.CustomerRepository;
import com.klef.jfsd.mq.RabbitMQMessageProducer;
import com.klef.jfsd.notification.NotificationConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) throws Exception {
//        Customer findByEmail = customerRepository.findByEmail(request.email());
//        if (findByEmail != null) {
//            throw new Exception("Customer already exists");
//        }
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.save(customer);
//        String url = UriComponentsBuilder.fromUriString("http://FRAUD/api/v1/fraud-check")
//                .queryParam("customerId", customer.getId())
//                .toUriString();
//
//        FraudCheckResponse response = restTemplate.getForObject(url, FraudCheckResponse.class);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
        if (response != null && response.isFraudster()) {
            throw new Exception("Fraudster detected");
        }

        // TODO: make it async. i.e add to queue
        NotificationRequest payload= NotificationRequest.builder()
                .customerId(    customer.getId())
                .customerEmail(customer.getEmail())
                .message(String.format("Hi %s",customer.getFirstName()))
                .build();
       rabbitMQMessageProducer.publish(payload,"internal.exchange","internal.notification.routing-key");
    }
}

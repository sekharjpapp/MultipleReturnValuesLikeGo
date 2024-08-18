package com.pixel.service;

import com.pixel.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails getPaymentDetails(String orderId) {
        return new PaymentDetails("Credit Card", "123456789");
    }
}

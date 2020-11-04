package com.prueba.javatest.util.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);

}

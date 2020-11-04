package com.prueba.javatest.util.payments;

import static com.prueba.javatest.util.payments.PaymentResponse.PaymentStatus.OK;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        return response.getStatus() == OK;
    }

}
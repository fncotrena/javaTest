package com.prueba.javatest.util;

import com.prueba.javatest.util.payments.PaymentGateway;
import com.prueba.javatest.util.payments.PaymentProcessor;
import com.prueba.javatest.util.payments.PaymentResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.prueba.javatest.util.payments.PaymentResponse.PaymentStatus.ERROR;
import static com.prueba.javatest.util.payments.PaymentResponse.PaymentStatus.OK;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentProcessorTest {

    @InjectMocks
    PaymentProcessor paymentProcessor;

    @Mock
    PaymentGateway paymentGateway;

    @Before
    public void setup(){
        paymentProcessor = new PaymentProcessor(paymentGateway);

    }

    @Test
    public void makePayment_whenPaymentIsCorrect() {
        // any(): Simulate with mockito classes that can not be tested directly (PaymentRequest).
        when(paymentGateway.requestPayment(any())).thenReturn(new PaymentResponse(OK));
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void makePayment_whenPaymentIsWrong() {
        // any(): Simulate with mockito classes that can not be tested directly (PaymentRequest).
        when(paymentGateway.requestPayment(any())).thenReturn(new PaymentResponse(ERROR));
        assertFalse(paymentProcessor.makePayment(1000));
    }
}

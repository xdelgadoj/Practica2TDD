package ec.edu.ups.tdd.payment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway gateway = null;
    private PaymentProcessor processor = null;

    @Before
    public void setUp() {
        gateway = Mockito.mock(PaymentGateway.class);
        processor = new PaymentProcessor(gateway);
    }

    @Test
    public void given_payment_when_is_correct_then_ok() {

        Mockito.when(gateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        assertTrue(processor.makePayment(100));
    }

    @Test
    public void given_payment_when_is_wrong_then_error() {

        Mockito.when(gateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(processor.makePayment(100));
    }
}
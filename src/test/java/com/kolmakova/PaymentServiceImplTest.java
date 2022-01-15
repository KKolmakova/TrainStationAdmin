package com.kolmakova;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.entities.Train;
import com.kolmakova.repositories.PaymentRepository;
import com.kolmakova.services.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentServiceImpl;

    @Test
    public void savePayment(){
        //GIVEN
        Payment payment = new Payment();

        payment.setId(1);
        payment.setPassenger(new Passenger());
        payment.setTrain(new Train());
        payment.setPricing(new Pricing());
        payment.setAmount(11.70);

        //WHEN
        when(paymentRepository.save(payment)).thenReturn(payment);
        Payment savedPayment = paymentServiceImpl.save(payment);

        //THEN
        verify(paymentRepository).save(payment);
    }
}

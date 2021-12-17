package com.kolmakova.utils;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.dto.ComfortDTO;
import com.kolmakova.dto.PricingDTO;
import com.kolmakova.entities.Comfort;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.entities.Train;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    public TrainDTO convertToTrainDTO(Train train) {
        TrainDTO trainDTO = new TrainDTO();
        BeanUtils.copyProperties(train, trainDTO);

        List<PricingDTO> pricingDTOList = new ArrayList<>();

        for (Pricing pricing : train.getPricingList()) {
            pricingDTOList.add(convertToPricingDTO(pricing));
        }
        trainDTO.setPricingDTOList(pricingDTOList);

        return trainDTO;
    }

    public PassengerDTO convertToPassengerDTO(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        List<PaymentDTO> paymentDTOList = convertToPaymentDTOList(passenger.getPaymentList());

        BeanUtils.copyProperties(passenger, passengerDTO);
        passengerDTO.setPaymentDTOList(paymentDTOList);

        return passengerDTO;
    }

    public PaymentDTO convertToPaymentDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();

        TrainDTO trainDTO = convertToTrainDTO(payment.getTrain());
        PricingDTO pricingDTO = convertToPricingDTO(payment.getPricing());

        BeanUtils.copyProperties(payment, paymentDTO);

        paymentDTO.setTrainDTO(trainDTO);
        paymentDTO.setPricingDTO(pricingDTO);

        return paymentDTO;
    }

    public PricingDTO convertToPricingDTO(Pricing pricing) {
        PricingDTO pricingDTO = new PricingDTO();
        ComfortDTO comfortDTO = convertComfortDTO(pricing.getComfortType());

        BeanUtils.copyProperties(pricing, pricingDTO);
        pricingDTO.setComfortDTO(comfortDTO);

        return pricingDTO;
    }

    public ComfortDTO convertComfortDTO(Comfort comfort) {
        ComfortDTO comfortDTO = new ComfortDTO();
        BeanUtils.copyProperties(comfort, comfortDTO);

        return comfortDTO;
    }

    public List<PaymentDTO> convertToPaymentDTOList(List<Payment> paymentList) {
        List<PaymentDTO> paymentDTOList = new ArrayList<>();

        for (Payment payment : paymentList) {
            paymentDTOList.add(convertToPaymentDTO(payment));
        }

        return paymentDTOList;
    }

    public List<TrainDTO> convertToTrainDTOList(List<Train> trainList) {
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Train train : trainList) {
            trainDTOList.add(convertToTrainDTO(train));
        }

        return trainDTOList;
    }

    public Passenger convertToPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDTO, passenger);

        return passenger;
    }
}

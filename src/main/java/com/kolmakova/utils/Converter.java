package com.kolmakova.utils;

import com.kolmakova.dto.*;
import com.kolmakova.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class Converter {

    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final String TIME_FORMAT = "HH:mm";

    public TrainDTO convertToTrainDTO(Train train) {
        TrainDTO trainDTO = new TrainDTO();
        BeanUtils.copyProperties(train, trainDTO);

        List<PricingDTO> pricingDTOList = new ArrayList<>();

        for (Pricing pricing : train.getPricingList()) {
            pricingDTOList.add(convertToPricingDTO(pricing));
        }
        trainDTO.setPricingDTOList(pricingDTOList);

        Date departureDate = trainDTO.getDepartureDate();
        Date departureTime = trainDTO.getDepartureTime();

        if (Objects.nonNull(departureDate)) {
            trainDTO.setDepartureDateStr(new SimpleDateFormat(DATE_FORMAT).format(departureDate));
        }
        if (Objects.nonNull(departureTime)) {
            trainDTO.setDepartureTimeStr(new SimpleDateFormat(TIME_FORMAT).format(departureTime));
        }
        return trainDTO;
    }

    public PassengerDTO convertToPassengerDTO(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        DocumentDTO documentDTO = convertDocumentDTO(passenger.getDocumentType());
        List<PaymentDTO> paymentDTOList = convertToPaymentDTOList(passenger.getPaymentList());

        BeanUtils.copyProperties(passenger, passengerDTO);
        passengerDTO.setPaymentDTOList(paymentDTOList);
        passengerDTO.setDocumentDTO(documentDTO);

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

    public DocumentDTO convertDocumentDTO(Document document) {
        DocumentDTO documentDTO = new DocumentDTO();
        BeanUtils.copyProperties(document, documentDTO);

        return documentDTO;
    }

    public List<DocumentDTO> convertToDocumentDTOList(List<Document> documentList) {
        List<DocumentDTO> documentDTOList = new ArrayList<>();

        for (Document document : documentList) {
            documentDTOList.add(convertDocumentDTO(document));
        }

        return documentDTOList;
    }

    public List<PaymentDTO> convertToPaymentDTOList(List<Payment> paymentList) {
        List<PaymentDTO> paymentDTOList = new ArrayList<>();

        for (Payment payment : paymentList) {
            paymentDTOList.add(convertToPaymentDTO(payment));
        }

        return paymentDTOList;
    }

    public List<PassengerDTO> convertToPassengerDTOList(List<Passenger> passengerList) {
        List<PassengerDTO> passengerDTOList = new ArrayList<>();

        for (Passenger passenger : passengerList) {
            passengerDTOList.add(convertToPassengerDTO(passenger));
        }

        return passengerDTOList;
    }

    public Passenger convertToPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDTO, passenger);

        return passenger;
    }

    public Account convertToAccount(AccountDTO accountDto) {
        Account account = new Account();

        BeanUtils.copyProperties(accountDto, account);

        return account;
    }
}

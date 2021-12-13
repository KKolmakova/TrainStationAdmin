package com.kolmakova.responses;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.TrainDTO;

import java.util.List;

public class EditResponse {

    private List<PaymentDTO> paymentDTOList;
    private PassengerDTO passengerDTO;

    public PassengerDTO getPassengerDTO() {
        return passengerDTO;
    }

    public void setPassengerDTO(PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }

    public List<PaymentDTO> getPaymentDTOList() {
        return paymentDTOList;
    }

    public void setPaymentDTOList(List<PaymentDTO> paymentDTOList) {
        this.paymentDTOList = paymentDTOList;
    }
}

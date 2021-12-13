package com.kolmakova.responses;

import com.kolmakova.dto.PassengerDTO;

import java.util.List;

public class PassengerResponse {

    private List<PassengerDTO> passengerDTOList;

    public List<PassengerDTO> getPassengerDTOList() {
        return passengerDTOList;
    }

    public void setPassengerDTOList(List<PassengerDTO> passengerDTOList) {
        this.passengerDTOList = passengerDTOList;
    }
}

package com.kolmakova.responses;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.dto.PassengerDTO;

import java.util.List;

public class PassengerResponse {

    private List<PassengerDTO> passengerDTOList;
    private List<DocumentDTO> documentDTOList;

    public List<DocumentDTO> getDocumentDTOList() {
        return documentDTOList;
    }

    public void setDocumentDTOList(List<DocumentDTO> documentDTOList) {
        this.documentDTOList = documentDTOList;
    }

    public List<PassengerDTO> getPassengerDTOList() {
        return passengerDTOList;
    }

    public void setPassengerDTOList(List<PassengerDTO> passengerDTOList) {
        this.passengerDTOList = passengerDTOList;
    }
}

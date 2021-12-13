package com.kolmakova.responses;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.TrainDTO;

import java.util.List;

public class EditResponse {

    private PassengerDTO passengerDTO;
    private List<TrainDTO> trainDTOList;

    public PassengerDTO getPassengerDTO() {
        return passengerDTO;
    }

    public void setPassengerDTO(PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }

    public List<TrainDTO> getTrainDTOList() {
        return trainDTOList;
    }

    public void setTrainDTOList(List<TrainDTO> trainDTOList) {
        this.trainDTOList = trainDTOList;
    }
}

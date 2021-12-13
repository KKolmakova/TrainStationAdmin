package com.kolmakova.responses;

import com.kolmakova.dto.TrainDTO;

import java.util.List;

public class TrainResponse {

    private TrainDTO selectedTrainDTO;
    private List<TrainDTO> trainDTOList;
    private String trainsIds;

    public String getTrainsIds() {
        return trainsIds;
    }

    public void setTrainsIds(String trainsIds) {
        this.trainsIds = trainsIds;
    }

    public TrainDTO getSelectTrainDTO() {
        return selectedTrainDTO;
    }

    public void setSelectTrainDTO(TrainDTO trainDTO) {
        this.selectedTrainDTO = trainDTO;
    }

    public List<TrainDTO> getTrainDTOList() {
        return trainDTOList;
    }

    public void setTrainDTOList(List<TrainDTO> trainDTOList) {
        this.trainDTOList = trainDTOList;
    }
}

package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.responseServices.TrainResponseService;
import com.kolmakova.responses.TrainResponse;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainResponseServiceImpl implements TrainResponseService {

    @Autowired
    private TrainService trainService;

    @Override
    public TrainResponse getResponse(Integer trainId, List<Integer> trainsIds) {
        List<TrainDTO> trainDTOList = getTrainDTOList(trainsIds);

        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setId(trainId);

        return createTrainResponse(trainsIds, trainDTOList, trainDTO);
    }

    private TrainResponse createTrainResponse(List<Integer> trainsIds, List<TrainDTO> trainDTOList, TrainDTO trainDTO) {
        TrainResponse trainResponse = new TrainResponse();

        trainResponse.setSelectTrainDTO(trainDTO);
        trainResponse.setTrainDTOList(trainDTOList);
        trainResponse.setTrainsIds(trainService.getSelectedTrainsUrl(trainService.getTrainsByIds(trainsIds)));

        return trainResponse;
    }

    private List<TrainDTO> getTrainDTOList(List<Integer> trainsIds) {
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Integer id : trainsIds) {
            TrainDTO trainDTO = new TrainDTO();
            trainDTO.setId(id);
            trainDTOList.add(trainDTO);
        }

        return trainDTOList;
    }
}

package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.SearchResponseService;
import com.kolmakova.responses.TrainResponse;
import com.kolmakova.services.TrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchResponseServiceImpl implements SearchResponseService {

    @Autowired
    private TrainService trainService;

    @Override
    public TrainResponse getResponse(TrainDTO trainDTO) {
        List<Train> trains = trainService.getByArrivalPlace(trainDTO.getArrivalPlace());
        String trainsIdsUrl = trainService.getSelectedTrainsUrl(trains);

        return getTrainResponse(trains, trainsIdsUrl);
    }

    private TrainResponse getTrainResponse(List<Train> trains, String trainsIdsUrl) {
        TrainResponse trainResponse = new TrainResponse();
        trainResponse.setTrainDTOList(convertTrainsToDto(trains));
        trainResponse.setTrainsIds(trainsIdsUrl);

        return trainResponse;
    }

    private List<TrainDTO> convertTrainsToDto(List<Train> trains){
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Train train : trains) {
            TrainDTO trainDTO = new TrainDTO();
            BeanUtils.copyProperties(train, trainDTO);
            trainDTOList.add(trainDTO);
        }

        return trainDTOList;
    }
}

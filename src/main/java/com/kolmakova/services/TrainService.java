package com.kolmakova.services;

import com.kolmakova.entities.Train;
import com.kolmakova.repositories.TrainRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> list() {
        return trainRepository.findAll();
    }

    public List<Train> getByArrivalPlace(String arrivalPlace) {
        return trainRepository.findTrainByArrival(arrivalPlace);
    }

    public Train getTrainById(int id) {
        return trainRepository.findById(id).orElse(new Train());
    }

    public List<Integer> getTrainsId(List<Train> trains) {
        List<Integer> trainsId = new ArrayList<>();
        for (Train train : trains) {
            trainsId.add(train.getId());
        }

        return trainsId;
    }

    public String getSelectedTrainsUrl(List<Train> trains) {
        List<Integer> ids = getTrainsId(trains);
        return StringUtils.join(ids, ',');
    }

    public List<Train> getTrainsByIds(List<Integer> id) {
        return trainRepository.findAllById(id);
    }
}

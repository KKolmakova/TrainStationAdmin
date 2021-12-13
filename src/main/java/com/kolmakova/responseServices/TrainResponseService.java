package com.kolmakova.responseServices;

import com.kolmakova.responses.TrainResponse;

import java.util.List;

public interface TrainResponseService {

    TrainResponse getResponse(Integer trainId, List<Integer> trainsIds);
}

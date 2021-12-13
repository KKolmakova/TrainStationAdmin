package com.kolmakova.responseServices;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.responses.TrainResponse;

public interface SearchResponseService {

    TrainResponse getResponse(TrainDTO trainDTO);
}

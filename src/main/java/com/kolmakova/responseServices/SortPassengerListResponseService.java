package com.kolmakova.responseServices;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responses.PassengerListResponse;

public interface SortPassengerListResponseService {

    PassengerListResponse getResponse();

    PassengerListResponse getSortedResponse(PassengerDTO passengerDTO);
}

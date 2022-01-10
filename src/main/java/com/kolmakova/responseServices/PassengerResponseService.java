package com.kolmakova.responseServices;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responses.PassengerResponse;

public interface PassengerResponseService {

    PassengerResponse getResponse();

    PassengerResponse getSortedResponse(PassengerDTO passengerDTO);
}

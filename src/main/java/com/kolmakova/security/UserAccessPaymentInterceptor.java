package com.kolmakova.security;

import com.kolmakova.entities.TrainStationUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("userAccessPaymentInterceptor")
public class UserAccessPaymentInterceptor implements HandlerInterceptor {
    
    private static final String ID_PATH_VARIABLE = "id";
    private static final String PASSENGER_ID_PATH_VARIABLE = "passengerId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> pathVariables = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        TrainStationUser principal = (TrainStationUser) ((UsernamePasswordAuthenticationToken) request.getUserPrincipal()).getPrincipal();

        if (pathVariables.containsKey(ID_PATH_VARIABLE)) {
            if (pathVariables.get(ID_PATH_VARIABLE) instanceof Integer) {
                Integer paymentId = (Integer) pathVariables.get(ID_PATH_VARIABLE);

            }
        }
        if(pathVariables.containsKey(PASSENGER_ID_PATH_VARIABLE)){
            if(pathVariables.get(PASSENGER_ID_PATH_VARIABLE) instanceof Integer){
                Integer passengerId = (Integer) pathVariables.get(PASSENGER_ID_PATH_VARIABLE);
            }
        }
        return false;
    }
}

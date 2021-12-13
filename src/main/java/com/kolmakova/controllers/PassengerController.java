package com.kolmakova.controllers;

import com.kolmakova.responseServices.PassengerResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class PassengerController {

    @Autowired
    private PassengerResponseService passengerResponseService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("home", true);
        return "trainStationAdmin";
    }

    @GetMapping("/passengers")
    public String printAllPassengers(Model model) {
        model.addAttribute("passengers", true);
        model.addAttribute("response", passengerResponseService.getResponse());

        return "trainStationAdmin";
    }
}

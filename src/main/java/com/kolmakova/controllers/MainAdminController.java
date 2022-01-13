package com.kolmakova.controllers;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responseServices.SortPassengerListResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainAdminController {

    @Autowired
    private SortPassengerListResponseService sortPassengerListResponseService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("home", true);
        return "home";
    }

    @GetMapping("/passengers")
    public String printAllPassengers(Model model) {
        model.addAttribute("passengers", true);
        model.addAttribute("response", sortPassengerListResponseService.getResponse());

        return "trainStationAdmin";
    }

    @PostMapping("/passengers/sort")
    public String sortPassengers(Model model, PassengerDTO passengerDTO) {
        model.addAttribute("passengers", true);
        model.addAttribute("response", sortPassengerListResponseService.getSortedResponse(passengerDTO));

        return "trainStationAdmin";
    }
}

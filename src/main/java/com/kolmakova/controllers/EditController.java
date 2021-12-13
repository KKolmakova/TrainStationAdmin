package com.kolmakova.controllers;

import com.kolmakova.responseServices.EditResponseService;
import com.kolmakova.responseServices.TrainResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/passenger/{passengerId}")
public class EditController {

    @Autowired
    private EditResponseService editResponseService;

    @GetMapping("/print")
    public String getPassenger(Model model,
                                    @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("edit", true);
        model.addAttribute("response", editResponseService.getResponse(passengerId));

        return "trainStationAdmin";
    }
}

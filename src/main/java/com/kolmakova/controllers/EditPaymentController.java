package com.kolmakova.controllers;

import com.kolmakova.responseServices.DeleteResponseService;
import com.kolmakova.responseServices.EditResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passenger/{passengerId}")
public class EditPaymentController {

    @Autowired
    private EditResponseService editResponseService;
    @Autowired
    private DeleteResponseService deleteResponseService;

    @GetMapping("/print")
    public String getPassenger(Model model,
                                    @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("edit", true);
        model.addAttribute("response", editResponseService.getResponse(passengerId));

        return "trainStationAdmin";
    }

    @GetMapping("/payment/{paymentId}/delete")
    public String deletePayment(Model model,
                               @PathVariable("paymentId") Integer paymentId) {
        model.addAttribute("delete", true);
        model.addAttribute("response", deleteResponseService.getResponse(paymentId));

        return "trainStationAdmin";
    }
}

package com.kolmakova.controllers;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responseServices.DeleteResponseService;
import com.kolmakova.responseServices.EditResponseService;
import com.kolmakova.responseServices.PassengerResponseService;
import com.kolmakova.responseServices.RestoreResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passenger/{passengerId}")
public class EditPaymentController {

    @Autowired
    private EditResponseService editResponseService;
    @Autowired
    private DeleteResponseService deleteResponseService;
    @Autowired
    private RestoreResponseService restoreResponseService;
    @Autowired
    private PassengerResponseService passengerResponseService;

    @GetMapping("/print")
    public String getPassenger(Model model,
                               @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("edit", true);
        model.addAttribute("response", editResponseService.getResponse(passengerId));

        return "trainStationAdmin";
    }

    @GetMapping("/payment/{paymentId}/delete")
    public String deletePayment(Model model,
                                @PathVariable("paymentId") Integer paymentId,
                                @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("response", deleteResponseService.getResponse(paymentId));

        return "redirect:/passenger/" + passengerId + "/print";
    }

    @GetMapping("/payment/{paymentId}/restore")
    public String restorePayment(Model model,
                                 @PathVariable("paymentId") Integer paymentId,
                                 @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("response", restoreResponseService.getResponse(paymentId));

        return "redirect:/passenger/" + passengerId + "/print";
    }

//    @GetMapping("/return")
//    public String returnToAllPassengers(Model model) {
//        model.addAttribute("passengers", true);
//        model.addAttribute("response", passengerResponseService.getResponse());
//
//        return "redirect:/home/passengers";
//    }
}

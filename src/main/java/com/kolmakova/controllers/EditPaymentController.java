package com.kolmakova.controllers;

import com.kolmakova.responseServices.DeletePaymentResponseService;
import com.kolmakova.responseServices.EditPassengerResponseService;
import com.kolmakova.responseServices.SortPassengerListResponseService;
import com.kolmakova.responseServices.RestorePaymentResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passenger/{passengerId}")
public class EditPaymentController {

    @Autowired
    private EditPassengerResponseService editPassengerResponseService;
    @Autowired
    private DeletePaymentResponseService deletePaymentResponseService;
    @Autowired
    private RestorePaymentResponseService restorePaymentResponseService;
    @Autowired
    private SortPassengerListResponseService sortPassengerListResponseService;

    @GetMapping("/print")
    public String getPassenger(Model model,
                               @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("edit", true);
        model.addAttribute("response", editPassengerResponseService.getResponse(passengerId));

        return "trainStationAdmin";
    }

    @GetMapping("/payment/{paymentId}/delete")
    public String deletePayment(Model model,
                                @PathVariable("paymentId") Integer paymentId,
                                @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("response", deletePaymentResponseService.getResponse(paymentId));

        return "redirect:/passenger/" + passengerId + "/print";
    }

    @GetMapping("/payment/{paymentId}/restore")
    public String restorePayment(Model model,
                                 @PathVariable("paymentId") Integer paymentId,
                                 @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("response", restorePaymentResponseService.getResponse(paymentId));

        return "redirect:/passenger/" + passengerId + "/print";
    }

    @GetMapping("/return")
    public String returnToAllPassengers(Model model) {
        model.addAttribute("passengers", true);
        model.addAttribute("response", sortPassengerListResponseService.getResponse());

        return "redirect:/home/passengers";
    }
}

package com.kolmakova.controllers;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responseServices.PaymentResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/payment")
public class PaymentController {

//    @Autowired
//    private PaymentResponseService paymentResponseService;
//
//    @GetMapping("{id}")
//    public String getOne(Model model,
//                         @PathVariable("id") Integer paymentId) {
//        model.addAttribute("payment", true);
//        model.addAttribute("response", paymentResponseService.getResponse(paymentId));
//
//        return "trainStation";
//    }
//
//    @PostMapping("/create")
//    public String createPayment(PassengerDTO passengerDTO,
//                                @RequestParam("trainId") Integer trainId) {
//        return "redirect:" + paymentResponseService.create(passengerDTO, trainId).getPayment().getId();
//    }
}

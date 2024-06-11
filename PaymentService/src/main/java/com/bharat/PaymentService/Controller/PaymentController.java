package com.bharat.PaymentService.Controller;

import com.bharat.PaymentService.DTO.PaymentRequestDTO;
import com.bharat.PaymentService.Service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping()
    public String doPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException{
        return paymentService.doPayment(paymentRequestDTO.getAmount(),paymentRequestDTO.getOrderId(),
                paymentRequestDTO.getName(),paymentRequestDTO.getContact(),paymentRequestDTO.getEmail());

    }
}

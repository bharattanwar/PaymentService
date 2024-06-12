package com.bharat.PaymentService.Controller;

import com.bharat.PaymentService.DTO.PaymentRequestDTO;
import com.bharat.PaymentService.Service.PaymentService;
import com.razorpay.RazorpayException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello from Bharat tanwar");
    }
}

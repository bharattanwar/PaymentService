package com.bharat.PaymentService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripe/webhook")
public class StripeWebhookController {
    @PostMapping
    public ResponseEntity<String> webhook(){
        System.out.println("waiting");
        return ResponseEntity.ok("OK");
    }
}

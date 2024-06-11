package com.bharat.PaymentService.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  razorpayConfig {
    @Value("${razorpay.key.id}")
    private String razorpayId;
    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException{
        return new RazorpayClient(razorpayId,razorpaySecret);
    }
}

package com.bharat.PaymentService.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {
    @Value("${stripe.key.id}")
    private String stripeId;

    @Bean
    public StripeClient getStripeClient() throws StripeException{
        return new StripeClient(stripeId);
    }
}

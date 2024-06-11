package com.bharat.PaymentService.PaymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentGatewayStrategyChooser {
    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;
    /*@Autowired
    private StripePaymentGateway stripePaymentGateway;*/

    public PaymentGateway getBestPaymentGateway(){
        String[] arr = {"razorpay","stripe"};
        Random random = new Random();
        int randomnumber = random.nextInt(arr.length);
        String s = arr[randomnumber];
        /*if(s.equals("Stripe")){
            return stripePaymentGateway;
        }*/
        return razorpayPaymentGateway;
    }
}

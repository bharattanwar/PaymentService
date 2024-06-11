package com.bharat.PaymentService.PaymentGateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RazorpayPaymentGateway implements PaymentGateway {
    @Autowired
    private RazorpayClient razorpayClient;

    @Override
    public String getPaymentLink(long amount, String orderId, String name, String contact, String email) throws RazorpayException {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
            paymentLinkRequest.put("first_min_partial_amount", 100);
            paymentLinkRequest.put("expire_by", Instant.now().toEpochMilli() + 600000);
            paymentLinkRequest.put("reference_id", orderId);
            paymentLinkRequest.put("description", "Payment for policy no 1111");
            JSONObject customer = new JSONObject();
            customer.put("name", name);
            customer.put("contact", contact);
            customer.put("email", email);
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
//          JSONObject notes = new JSONObject();
//          notes.put("policy_name","Jeevan Bima");
//          paymentLinkRequest.put("notes",notes);
            /*paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method", "get");*/

            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url").toString();
        }
        catch(RazorpayException r){
            throw new RuntimeException(r);
        }
    }
}






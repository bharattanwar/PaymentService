package com.bharat.PaymentService.Service;

import com.bharat.PaymentService.PaymentGateway.PaymentGateway;
import com.bharat.PaymentService.PaymentGateway.PaymentGatewayStrategyChooser;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentGatewayStrategyChooser paymentGatewayStrategyChooser;
    @Override
    public String doPayment(long amount, String orderId, String name, String contact, String email) throws RazorpayException {
        PaymentGateway paymentGateway = paymentGatewayStrategyChooser.getBestPaymentGateway();
        return paymentGateway.getPaymentLink(amount,orderId,name,contact,email);
    }
}


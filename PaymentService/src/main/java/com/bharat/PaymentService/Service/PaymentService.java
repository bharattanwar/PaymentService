package com.bharat.PaymentService.Service;

import com.razorpay.RazorpayException;

public interface PaymentService {
    String doPayment(long amount, String orderId, String name, String contact, String email) throws RazorpayException;
}

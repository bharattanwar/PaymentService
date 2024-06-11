package com.bharat.PaymentService.PaymentGateway;

import com.bharat.PaymentService.DTO.PaymentRequestDTO;
import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String getPaymentLink(long amount, String orderId, String name, String contact, String email) throws RazorpayException;
}

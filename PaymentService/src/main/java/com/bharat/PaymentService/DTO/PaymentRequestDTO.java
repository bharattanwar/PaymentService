package com.bharat.PaymentService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    private long amount;
    private String orderId;
    private String name;
    private String contact;
    private String email;
}

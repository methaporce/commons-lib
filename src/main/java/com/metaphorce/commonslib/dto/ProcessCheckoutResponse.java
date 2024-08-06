package com.metaphorce.commonslib.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProcessCheckoutResponse {

    private BigDecimal totalToPay;
    private Long idCheckout;
    private String status;
    private Long orderId;
}

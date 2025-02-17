package com.metaphorce.commonslib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {

    private Long orderId;
    private BigDecimal totalToPay;
    private Long cartId;

}

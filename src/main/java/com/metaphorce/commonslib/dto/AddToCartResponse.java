package com.metaphorce.commonslib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartResponse {

    private Long cartId;
    private Long userId;
    private Long categoryId;
    private String categoryName;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productTotal;
    private String productImage;
    private Integer productStock;
    private Integer quantity;

}

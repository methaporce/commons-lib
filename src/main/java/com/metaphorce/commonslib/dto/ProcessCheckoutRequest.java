package com.metaphorce.commonslib.dto;

import com.metaphorce.commonslib.entities.Card;
import com.metaphorce.commonslib.entities.UserLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessCheckoutRequest {

    private Long orderId;
    private String phoneUser;
    private UserLocation userLocation;
    private Card cardUser;
    private Long paymentMethodId;

}

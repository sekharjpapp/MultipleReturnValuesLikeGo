package com.pixel.service;

import com.pixel.model.ShippingDetails;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    public ShippingDetails getShippingDetails(String userId) {
        return new ShippingDetails("Delhi", "10/10/2020", "123456789");
    }

}

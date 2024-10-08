package com.lld.cabBooking.strategy.impl;

import com.lld.cabBooking.model.Cab;
import com.lld.cabBooking.model.Location;
import com.lld.cabBooking.strategy.PriceMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class PricingMatchingStrategyImpl implements PriceMatchingStrategy {
    private final Double PRICE_PER_KM = 10.00;
    @Override
    public Double getPrice(Cab cab, Location pickup, Location drop) {
        return pickup.getDistance(drop)*(PRICE_PER_KM);
    }
}

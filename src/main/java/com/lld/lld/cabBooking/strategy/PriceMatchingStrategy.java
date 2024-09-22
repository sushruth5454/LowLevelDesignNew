package com.lld.lld.cabBooking.strategy;

import com.lld.lld.cabBooking.model.Cab;
import com.lld.lld.cabBooking.model.Location;

public interface PriceMatchingStrategy {
    Double getPrice(Cab cab, Location pickup, Location drop);
}

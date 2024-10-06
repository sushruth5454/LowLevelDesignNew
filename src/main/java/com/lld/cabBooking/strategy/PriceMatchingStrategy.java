package com.lld.cabBooking.strategy;

import com.lld.cabBooking.model.Cab;
import com.lld.cabBooking.model.Location;

public interface PriceMatchingStrategy {
    Double getPrice(Cab cab, Location pickup, Location drop);
}

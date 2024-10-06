package com.lld.cabBooking.strategy.impl;

import com.lld.cabBooking.model.Cab;
import com.lld.cabBooking.model.CabStatus;
import com.lld.cabBooking.model.Location;
import com.lld.cabBooking.model.User;
import com.lld.cabBooking.strategy.CabMatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CabMatchingStrategyImpl implements CabMatchingStrategy {
    @Override
    public Optional<Cab> matchCabToRider(List<Cab> cabList, User user, Location fromPoint, Location toPoint) {
        return cabList.stream().filter(cab -> cab.getStatus() == CabStatus.AVAILABLE).findFirst();
    }
}

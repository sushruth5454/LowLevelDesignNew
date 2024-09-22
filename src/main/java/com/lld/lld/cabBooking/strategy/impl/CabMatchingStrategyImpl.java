package com.lld.lld.cabBooking.strategy.impl;

import com.lld.lld.cabBooking.model.Cab;
import com.lld.lld.cabBooking.model.CabStatus;
import com.lld.lld.cabBooking.model.Location;
import com.lld.lld.cabBooking.model.User;
import com.lld.lld.cabBooking.strategy.CabMatchingStrategy;

import java.util.List;
import java.util.Optional;

public class CabMatchingStrategyImpl implements CabMatchingStrategy {
    @Override
    public Optional<Cab> matchCabToRider(List<Cab> cabList, User user, Location fromPoint, Location toPoint) {
        return cabList.stream().filter(cab -> cab.getStatus() == CabStatus.AVAILABLE).findFirst();
    }
}

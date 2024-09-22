package com.lld.lld.cabBooking.strategy;

import com.lld.lld.cabBooking.model.Cab;
import com.lld.lld.cabBooking.model.Location;
import com.lld.lld.cabBooking.model.User;

import java.util.List;
import java.util.Optional;

public interface CabMatchingStrategy {

    Optional<Cab> matchCabToRider(List<Cab> cabList, User user, Location fromPoint, Location toPoint);
}

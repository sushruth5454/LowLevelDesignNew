package com.lld.cabBooking.service;

import com.lld.cabBooking.model.*;
import com.lld.cabBooking.strategy.CabMatchingStrategy;
import com.lld.cabBooking.strategy.PriceMatchingStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Data
@Service
public class TripService {
    private Map<String , List<Ride>> rideStore = new HashMap<>();
    private CabService cabService;
    private UserService userService;

    private CabMatchingStrategy cabMatchingStrategy;
    private PriceMatchingStrategy priceMatchingStrategy;
    private final double MAX_DISTANCE = 10.0;

    public void createTrip(User user, Location pickup, Location drop) throws Exception {

        List<Cab> cabList= cabService.getCabs(pickup, MAX_DISTANCE);
        Optional<Cab> matchedCab = cabMatchingStrategy.matchCabToRider(cabList, user, pickup, drop);
        if(matchedCab.isEmpty()){
            throw  new Exception("No cabs are available");
        }
        Cab selectedCab = matchedCab.get();
        Double price = priceMatchingStrategy.getPrice(selectedCab, drop, pickup);
        final Ride ride = Ride.builder().cost(price).drop(drop)
                .pickup(pickup).status(RideStatus.BOOKED).startedAt(LocalDateTime.now()).userId(user.getId())
                .cabId(selectedCab.getCabNumber()).build();

        selectedCab.setRide(ride);
        selectedCab.setStatus(CabStatus.IN_RIDE);
        if(!rideStore.containsKey(user.getId())){
            rideStore.put(user.getId(), new ArrayList<>());
        }
        rideStore.get(user.getId()).add(ride);
    }

    public void endRide(Ride ride) throws Exception {
        ride.setEndedAt(LocalDateTime.now());
        ride.setStatus(RideStatus.COMPLETED);
        Cab cab= cabService.getCab(ride.getCabId());
        cab.setStatus(CabStatus.AVAILABLE);
        cabService.updateLocation(cab.getId(), ride.getDrop());
        cab.setRide(null);
    }
}

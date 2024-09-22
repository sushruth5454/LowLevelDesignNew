package com.lld.lld.cabBooking.service;

import com.lld.lld.cabBooking.model.Cab;
import com.lld.lld.cabBooking.model.CabStatus;
import com.lld.lld.cabBooking.model.Location;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CabService {
    Map<String, Cab> cabStore = new HashMap<>();


    public void register(String cabId, String driverName) throws Exception {
        if(cabStore.containsKey(cabId)){
            throw new Exception("cab already assigned");
        }
        cabStore.put(cabId, new Cab(cabId, driverName));
    }

    public void updateLocation(String cabId, Location location) throws Exception {
        if(!cabStore.containsKey(cabId)){
            throw new Exception("Invalid cabId");
        }
        Cab cab= cabStore.get(cabId);
        cab.setCurrLocation(location);

    }

    public List<Cab> getCabs(@NonNull final Location location, @NonNull final Double distance) {
        return cabStore.values().stream()
                .filter(cab -> cab.getCurrLocation().getDistance(location) <= distance)
                .collect(Collectors.toList());
    }


    public void updateStatus(String cabId, CabStatus status) throws Exception {
        if(!cabStore.containsKey(cabId)){
            throw new Exception("Invalid cabId");
        }
        Cab cab = cabStore.get(cabId);
        cab.setStatus(status);
    }

    public Cab getCab(String cabId){
        return cabStore.get(cabId);
    }
}

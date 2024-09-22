package com.lld.lld.cabBooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Location {
    private double x;
    private double y;

    public Double getDistance(Location destination){
        return Math.sqrt(Math.pow((this.x - destination.x), 2) + Math.pow((this.y - destination.y), 2));
    }
}

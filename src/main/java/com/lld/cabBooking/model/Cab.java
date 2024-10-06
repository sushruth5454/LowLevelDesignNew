package com.lld.cabBooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
public class Cab extends BaseClass{
    private String cabNumber;
    private CabType cabType;
    private int capacity;
    private int currentCapacity;
    private Location currLocation;
    private Boolean isAvailable;
    private String driverName;
    private CabStatus status;
    private String driverId;

    private Ride ride;

    public Cab(final String cabId, final String driverName){
        this.cabNumber = cabId;
        this.cabType = CabType.BASIC;
        this.capacity = 4;
        this.currentCapacity = 0;
        this.status = CabStatus.AVAILABLE;
    }
}

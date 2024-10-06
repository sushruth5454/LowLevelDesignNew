package com.lld.cabBooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Driver {
    private long cabId;
    private String driverName;
    private long rating;
    private int noOfRatings;
    private CabStatus status;
}

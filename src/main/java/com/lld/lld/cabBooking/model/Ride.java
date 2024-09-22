package com.lld.lld.cabBooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
public class Ride extends BaseClass{
    private String cabId;
    private String userId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private Location pickup;
    private Location drop;
    private Double cost;
    private RideStatus status;
    private PaymentMethod method;
    private Long paymentId;
}

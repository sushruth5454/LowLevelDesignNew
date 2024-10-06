package com.lld.cabBooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseClass {
    private String id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String createdBy;
    private String updatedBy;

}

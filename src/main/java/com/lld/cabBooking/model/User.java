package com.lld.cabBooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
public class User extends BaseClass{
    private String userName;
    private String password;
}

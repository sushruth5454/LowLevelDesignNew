package com.lld.lld.cabBooking.controller;

import com.lld.lld.cabBooking.model.Cab;
import com.lld.lld.cabBooking.model.CabStatus;
import com.lld.lld.cabBooking.model.Location;
import com.lld.lld.cabBooking.service.CabService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/cab")
public class CabsController {
    private CabService cabService;

    @PostMapping("/register")
    public ResponseEntity registerCab(@RequestParam("cabId") final String cabId, @RequestParam("driverName") String driverName) throws Exception {
        cabService.register(cabId, driverName);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/update-location")
    public ResponseEntity updateLocation(@RequestParam("cabId") final String cabId, @RequestBody Location location) throws Exception {
        cabService.updateLocation(cabId, location);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/getCabs")
    public ResponseEntity<List<Cab>> updateLocation(@RequestBody Location location, @RequestParam("distance") double distance){
        List<Cab> cabs= cabService.getCabs(location, distance);
        return ResponseEntity.ok(cabs);
    }

    @PostMapping("/update-status")
    public ResponseEntity updateStatus(@RequestParam("cabId") final String cabId, @RequestParam("status") CabStatus status) throws Exception {
        cabService.updateStatus(cabId, status);
        return ResponseEntity.ok("success");
    }

}

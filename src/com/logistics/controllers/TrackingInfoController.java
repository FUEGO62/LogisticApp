package com.logistics.controllers;

import com.logistics.dtos.CreateTrackingInfoRequest;
import com.logistics.dtos.CreateTrackingInfoResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.logistics.services.TrackingInfoService;
import com.logistics.services.TrackingInfoServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TrackingInfoController {

    private final TrackingInfoService trackingInfoService;

    @PostMapping("/trackingInfo")
    public CreateTrackingInfoResponse updateTrackingInfo(@RequestBody CreateTrackingInfoRequest createTrackingInfoRequest) {
        return trackingInfoService.updateTrackingInfoFor(createTrackingInfoRequest);
    }
}
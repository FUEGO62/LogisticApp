package controller;

import data.models.TrackingInfo;
import dtos.CreateTrackingInfoRequest;
import dtos.CreateTrackingInfoResponse;
import services.TrackingInfoService;
import services.TrackingInfoServiceImpl;

public class TrackingInfoController {

    private final TrackingInfoService trackingInfoService = new TrackingInfoServiceImpl();

    public CreateTrackingInfoResponse updateTrackingInfo(CreateTrackingInfoRequest createTrackingInfoRequest) {
        return trackingInfoService.updateTrackingInfoFor(createTrackingInfoRequest);
    }
}

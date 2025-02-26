package com.logistics.services;

import com.logistics.dtos.CreateTrackingInfoRequest;
import com.logistics.dtos.CreateTrackingInfoResponse;

import java.util.ArrayList;

public interface TrackingInfoService {
    long count();
    CreateTrackingInfoResponse createTrackingInfo(CreateTrackingInfoRequest request);
    CreateTrackingInfoResponse updateTrackingInfoFor(CreateTrackingInfoRequest request);
    ArrayList<CreateTrackingInfoResponse> findAllByItemId(String id);
    void deleteAll();

}

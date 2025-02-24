package services;

import data.models.TrackingInfo;
import dtos.CreateTrackingInfoRequest;
import dtos.CreateTrackingInfoResponse;

import java.util.ArrayList;

public interface TrackingInfoService {
    long count();
    CreateTrackingInfoResponse createTrackingInfo(CreateTrackingInfoRequest request);
    CreateTrackingInfoResponse updateTrackingInfoFor(CreateTrackingInfoRequest request);
    ArrayList<CreateTrackingInfoResponse> findAllByItemId(int id);
    void deleteAll();

}

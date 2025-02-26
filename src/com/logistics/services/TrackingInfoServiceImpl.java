package com.logistics.services;

import com.logistics.data.models.TrackingInfo;
import com.logistics.data.repositories.TrackingInfoRepository;
import com.logistics.dtos.CreateTrackingInfoRequest;
import com.logistics.dtos.CreateTrackingInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.logistics.utils.Mapper.map;

@Service
public class TrackingInfoServiceImpl implements TrackingInfoService {

    @Autowired
    private  TrackingInfoRepository trackingInfoRepository;
    
    @Override
    public void deleteAll(){
        trackingInfoRepository.deleteAll();
    }


    @Override
    public CreateTrackingInfoResponse updateTrackingInfoFor(CreateTrackingInfoRequest createTrackingInfoRequest) {

        TrackingInfo trackingInfo = map(createTrackingInfoRequest);
        return map( trackingInfoRepository.save(trackingInfo));
    }

    @Override
    public ArrayList<CreateTrackingInfoResponse> findAllByItemId(String id) {

        ArrayList<CreateTrackingInfoResponse>  trackingInfos = new ArrayList<>();
        for(TrackingInfo trackingInfo: trackingInfoRepository.findAllByItemId(id)){
            trackingInfos.add(map(trackingInfo));
        }
        return trackingInfos;
    }

    public CreateTrackingInfoResponse createTrackingInfo(CreateTrackingInfoRequest createTrackingInfoRequest) {

        TrackingInfo trackingInfo = map(createTrackingInfoRequest);
        return map(trackingInfoRepository.save(trackingInfo));
    }

    public long count() {
        return trackingInfoRepository.count();
    }
}

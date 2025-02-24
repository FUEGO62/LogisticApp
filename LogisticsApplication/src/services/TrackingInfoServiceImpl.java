package services;

import data.models.TrackingInfo;
import data.repositories.TrackingInfoRepository;
import data.repositories.TrackingInfos;
import dtos.CreateTrackingInfoRequest;
import dtos.CreateTrackingInfoResponse;

import java.util.ArrayList;

import static utils.Mapper.map;

public class TrackingInfoServiceImpl implements TrackingInfoService {

    private static final TrackingInfoRepository trackingInfoRepository = new TrackingInfos();



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
    public ArrayList<CreateTrackingInfoResponse> findAllByItemId(int id) {

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

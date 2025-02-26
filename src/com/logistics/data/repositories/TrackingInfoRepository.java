package com.logistics.data.repositories;

import com.logistics.data.models.TrackingInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface TrackingInfoRepository extends MongoRepository<TrackingInfo ,String> {

    ArrayList<TrackingInfo> findAllByItemId(String trackingId);
}

package data.repositories;

import data.models.Item;
import data.models.TrackingInfo;

import java.util.ArrayList;
import java.util.List;

public interface TrackingInfoRepository {

    long count();
    TrackingInfo save(TrackingInfo trackingInfo);
    TrackingInfo findById(int id);
    List<TrackingInfo> findAllById(int ... id);
    void deleteById(int id);
    void deleteAll();
    ArrayList<TrackingInfo> findAllByItemId(int itemId);
}

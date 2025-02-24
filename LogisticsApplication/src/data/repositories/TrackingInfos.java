package data.repositories;

import data.models.TrackingInfo;

import java.util.ArrayList;

public class TrackingInfos implements TrackingInfoRepository {

    private ArrayList<TrackingInfo> trackingInfos = new ArrayList<>();
    private int count;

    public TrackingInfo save(TrackingInfo trackingInfo) {

        if(trackingInfo == null) throw new IllegalArgumentException("trackingInfo is null");

        if(existsById(trackingInfo.getTrackingInfoId())){
            update(trackingInfo);
        }
        else {
            generateId(trackingInfo);
            trackingInfos.add(trackingInfo);
        }
        return trackingInfo;
    }

    public TrackingInfo[] saveAll(TrackingInfo ... trackingInfos) {
        for(TrackingInfo TrackingInfo : trackingInfos){
            save(TrackingInfo);
        }
        return trackingInfos;
    }

    public long count() {
        return trackingInfos.size();
    }

    public boolean existsById(int id) {
        TrackingInfo checker = findById(id);
        return checker != null;
    }


    public void deleteById(int id) {
        TrackingInfo deletedTrackingInfo = findById(id);
        if(deletedTrackingInfo == null){
            throw new IllegalArgumentException("TrackingInfo not found");
        }
        trackingInfos.remove(deletedTrackingInfo);
    }

    public void deleteAll(TrackingInfo ... trackingInfos) {

        for(TrackingInfo trackingInfo : trackingInfos){
            if(existsById(trackingInfo.getTrackingInfoId())){
                deleteById(trackingInfo.getTrackingInfoId());
            }
            else {
                throw new IllegalArgumentException("TrackingInfo not found");
            }
        }
    }

    public void deleteAll(){
        trackingInfos.clear();
    }

    public void deleteAllById(int ... ids) {
        for(int id : ids){
            if(existsById(id)){
                deleteById(id);
            }
            else {
                throw new IllegalArgumentException("TrackingInfo not found");
            }
        }
    }

    private void update(TrackingInfo trackingInfo) {
        deleteById(trackingInfo.getTrackingInfoId());
        trackingInfos.add(trackingInfo);
    }

    private void generateId(TrackingInfo trackingInfo) {
        count++;
        trackingInfo.setTrackingInfoId(count);
    }

    public TrackingInfo findById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getTrackingInfoId() == id) {
                return trackingInfo;
            }
        }
        return null;
    }


    public ArrayList<TrackingInfo> findAllById(int ... ids) {
        ArrayList<TrackingInfo> foundTrackingInfo = new ArrayList<>();
        for (int id : ids) {
            foundTrackingInfo.add(findById(id));
        }
        return foundTrackingInfo;

    }

    public ArrayList<TrackingInfo> findAllByItemId(int id) {
        ArrayList<TrackingInfo> foundTrackingInfo = new ArrayList<>();
        for (TrackingInfo trackingInfo : trackingInfos) {
            if(trackingInfo.getItemId() == id){
                foundTrackingInfo.add(trackingInfo);
            }
        }
        return foundTrackingInfo;

    }
}

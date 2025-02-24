package utils;

import data.models.Item;
import data.models.TrackingInfo;
import dtos.CreateItemRequest;
import dtos.CreateItemResponse;
import dtos.CreateTrackingInfoRequest;
import dtos.CreateTrackingInfoResponse;

public class Mapper {

    public static Item map(CreateItemRequest createItemRequest) {
        Item item = new Item();
        item.setDescription(createItemRequest.getDescription());
        item.setWeightInGrams(createItemRequest.getWeightInGrammes());
        return item;
    }

    public static CreateItemResponse map(Item item) {

        CreateItemResponse createItemResponse = new CreateItemResponse();
        createItemResponse.setDescription(item.getDescription());
        createItemResponse.setId(item.getItemId());

        return createItemResponse;
    }

    public static TrackingInfo map(CreateTrackingInfoRequest createTrackingInfoRequest) {
        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfo.setItemId(createTrackingInfoRequest.getItemId());
        trackingInfo.setInfo(createTrackingInfoRequest.getInfo());
        return trackingInfo;
    }

    public static CreateTrackingInfoResponse map(TrackingInfo trackingInfo) {
        CreateTrackingInfoResponse createTrackingInfoResponse = new CreateTrackingInfoResponse();
        createTrackingInfoResponse.setInfo(trackingInfo.getInfo());
        createTrackingInfoResponse.setItemId(trackingInfo.getItemId());
        createTrackingInfoResponse.setTrackingInfoId(trackingInfo.getTrackingInfoId());
        return createTrackingInfoResponse;

    }

}

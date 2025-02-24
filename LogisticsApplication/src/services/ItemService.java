package services;

import data.models.Item;
import data.models.TrackingInfo;
import dtos.CreateItemRequest;
import dtos.CreateItemResponse;
import dtos.CreateTrackingInfoResponse;

import java.util.ArrayList;

public interface ItemService {

    CreateItemResponse createNewPackageFor(CreateItemRequest createItemRequest);
    ArrayList<CreateTrackingInfoResponse> trackPackage(int itemId);
    long count();
    void deleteAll();
}

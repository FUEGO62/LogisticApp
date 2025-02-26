package com.logistics.services;

import com.logistics.dtos.CreateItemRequest;
import com.logistics.dtos.CreateItemResponse;
import com.logistics.dtos.CreateTrackingInfoResponse;

import java.util.ArrayList;

public interface ItemService {

    CreateItemResponse createNewPackageFor(CreateItemRequest createItemRequest);
    ArrayList<CreateTrackingInfoResponse> trackPackage(String itemId);
    long count();
    void deleteAll();
}

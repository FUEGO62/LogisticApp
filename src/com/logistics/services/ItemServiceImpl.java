 package com.logistics.services;

import com.logistics.data.models.Item;
import com.logistics.data.repositories.ItemRepository;
import com.logistics.dtos.CreateItemRequest;
import com.logistics.dtos.CreateItemResponse;
import com.logistics.dtos.CreateTrackingInfoRequest;
import com.logistics.dtos.CreateTrackingInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.logistics.utils.Mapper.map;

 @Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository items;

    @Autowired
    private TrackingInfoService trackingInfoService;

    @Override
    public long count(){
        return items.count();
    }

    @Override
    public void deleteAll(){
        items.deleteAll();
    }

    @Override
    public CreateItemResponse createNewPackageFor(CreateItemRequest createItemRequest) {

        Item item = items.save(map(createItemRequest));

        CreateTrackingInfoRequest createTrackingInfoRequest = new CreateTrackingInfoRequest();
        createTrackingInfoRequest.setItemId(item.getItemId());
        createTrackingInfoRequest.setInfo(item.getName()+ "  at warehouse");

        trackingInfoService.createTrackingInfo(createTrackingInfoRequest);
        return map(item);
    }

    @Override
    public ArrayList<CreateTrackingInfoResponse> trackPackage(String itemId) {
        return trackingInfoService.findAllByItemId(itemId);

    }
}

package services;

import static utils.Mapper.*;
import data.models.Item;
import data.models.TrackingInfo;
import data.repositories.ItemRepository;
import data.repositories.Items;
import dtos.CreateItemRequest;
import dtos.CreateItemResponse;
import dtos.CreateTrackingInfoRequest;
import dtos.CreateTrackingInfoResponse;

import java.util.ArrayList;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository items = new Items();

    private final TrackingInfoService trackingInfoService = new TrackingInfoServiceImpl();


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
        createTrackingInfoRequest.setInfo("item at lagos");

        trackingInfoService.createTrackingInfo(createTrackingInfoRequest);
        return map(item);
    }

    @Override
    public ArrayList<CreateTrackingInfoResponse> trackPackage(int itemId) {
        return trackingInfoService.findAllByItemId(itemId);

    }
}

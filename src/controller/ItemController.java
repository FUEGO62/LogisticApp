package controller;

import data.models.Item;
import data.models.TrackingInfo;
import dtos.CreateItemRequest;
import dtos.CreateItemResponse;
import dtos.CreateTrackingInfoResponse;
import services.ItemService;
import services.ItemServiceImpl;

import java.util.ArrayList;

public class ItemController {

    private final ItemService itemService = new ItemServiceImpl();

    public CreateItemResponse createNewPackageFor(String description, int weightInGrams){

        CreateItemRequest createItemRequest = new CreateItemRequest();
        createItemRequest.setDescription(description);
        createItemRequest.setWeightInGrammes(weightInGrams);

       return itemService.createNewPackageFor(createItemRequest);
    }

    public ArrayList<CreateTrackingInfoResponse> trackPackage(int itemId){
        return itemService.trackPackage(itemId);
    }

}

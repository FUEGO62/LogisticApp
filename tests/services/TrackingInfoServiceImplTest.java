package services;


import data.models.Item;
import dtos.CreateItemRequest;
import dtos.CreateItemResponse;
import dtos.CreateTrackingInfoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInfoServiceImplTest {
    private TrackingInfoService trackingInfoService = new TrackingInfoServiceImpl();
    private ItemService itemService = new ItemServiceImpl();
    private CreateItemRequest createItemRequest;
    private CreateTrackingInfoRequest createTrackingInfoRequest;

    @BeforeEach
    public void setUp() {
        createItemRequest = new CreateItemRequest();
        createItemRequest.setDescription("rice");
        createItemRequest.setWeightInGrammes(5000);
        createTrackingInfoRequest = new CreateTrackingInfoRequest();
        createTrackingInfoRequest.setInfo("item in lagos");
    }

    @Test
    public void TestThatNewTrackingInfoCanBeCreated() {
        assertEquals(0, trackingInfoService.count());
        CreateItemResponse item = itemService.createNewPackageFor(createItemRequest);
        assertEquals(1, trackingInfoService.count());
        createTrackingInfoRequest.setItemId(item.getId());
        trackingInfoService.updateTrackingInfoFor(createTrackingInfoRequest);
    }

}
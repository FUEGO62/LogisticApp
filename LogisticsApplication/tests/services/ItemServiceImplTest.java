package services;

import data.models.Item;
import dtos.CreateItemRequest;
import dtos.CreateItemResponse;
import dtos.CreateTrackingInfoRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceImplTest {
    private ItemService itemService;
    private TrackingInfoService trackingInfoService;
    private final CreateItemRequest createItemRequest = new CreateItemRequest();
    private final CreateTrackingInfoRequest createTrackingInfoRequest = new CreateTrackingInfoRequest();

    @BeforeEach
    public void beforeEach() {
        itemService = new ItemServiceImpl();
        trackingInfoService = new TrackingInfoServiceImpl();
        createItemRequest.setWeightInGrammes(5000);
        createItemRequest.setDescription("jollof rice");
        createTrackingInfoRequest.setInfo("item in lagos");
    }

    @AfterEach
    public void afterEach() {
        trackingInfoService.deleteAll();
        itemService.deleteAll();
    }

    @Test
    public void addItemCountIsOne() {
        CreateItemResponse saved = itemService.createNewPackageFor(createItemRequest);
        assertEquals(1,itemService.count());
        assertEquals(1,trackingInfoService.count());

    }

    @Test
    public void testThatUpdateTrackingInfoCountIsTwo(){
        CreateItemResponse saved = itemService.createNewPackageFor(createItemRequest);
        createTrackingInfoRequest.setItemId(saved.getId());
        trackingInfoService.updateTrackingInfoFor(createTrackingInfoRequest);
        assertEquals(2,trackingInfoService.count());
    }

    @Test
    public void testThatPackageCanBeTracked(){
        CreateItemResponse saved = itemService.createNewPackageFor(createItemRequest);
        createTrackingInfoRequest.setItemId(saved.getId());
        trackingInfoService.updateTrackingInfoFor(createTrackingInfoRequest);

        int sizeOfTrackingInfo = itemService.trackPackage(saved.getId()).size();
        System.out.println(itemService.trackPackage(saved.getId()).get(1));
        assertEquals(sizeOfTrackingInfo,2);
    }
}
package com.logistics.controllers;

import com.logistics.dtos.CreateItemRequest;
import com.logistics.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.logistics.services.ItemService;


@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/package")
    public ResponseEntity <ApiResponse> createNewPackageFor(@RequestBody CreateItemRequest createItemRequest) {
       return new ResponseEntity<>( new ApiResponse(true, itemService.createNewPackageFor(createItemRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/package/{trackingNumber}")
    public ResponseEntity <ApiResponse> trackPackage(@PathVariable("trackingNumber") String itemId){
        return new ResponseEntity<>( new ApiResponse(true, itemService.trackPackage(itemId)),HttpStatus.OK);
    }

}

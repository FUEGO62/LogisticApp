package com.logistics.dtos;


import lombok.Data;

@Data
public class CreateTrackingInfoResponse {

    private String itemId;
    private String info;
    private String trackingInfoId;

}

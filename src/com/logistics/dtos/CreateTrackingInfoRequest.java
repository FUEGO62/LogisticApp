package com.logistics.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CreateTrackingInfoRequest {

    private String itemId;
    private String info;
}
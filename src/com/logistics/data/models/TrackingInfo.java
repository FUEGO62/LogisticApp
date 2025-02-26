package com.logistics.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TrackingInfo {

    @Id
    private String id;
    private String itemId;
    private String info;
    private LocalDateTime time;

}

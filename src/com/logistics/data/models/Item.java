package com.logistics.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Item {

    private String name;
    private String description;
    private int weightInGrams;
    @Id
    private String itemId;

}

package com.logistics.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
public class CreateItemRequest {
    private String description;
    private int weightInGrammes;


}

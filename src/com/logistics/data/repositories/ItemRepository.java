package com.logistics.data.repositories;

import com.logistics.data.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item ,String> {

}

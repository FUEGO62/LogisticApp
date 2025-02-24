package data.repositories;

import data.models.Item;

import java.util.List;

public interface ItemRepository {

    Item save(Item item);
    Item findById(int id);
    List<Item> findAllById(int ... id);
    void deleteById(int id);
    void deleteAll();
    long count();
}

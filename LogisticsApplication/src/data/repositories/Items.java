package data.repositories;

import data.models.Item;

import java.util.ArrayList;


public class Items {

    private ArrayList<Item> items = new ArrayList<>();
    private int count;

    public Item save(Item item) {

        if(item == null) {throw new IllegalArgumentException("cannot save a null item");}

        if(existsById(item.getItemId())){
            update(item);
        }
        else {
            generateId(item);
            items.add(item);
        }
        return item;
    }

    public Item[] saveAll(Item ... items) {
        for(Item item : items){
            save(item);
        }
        return items;
    }

    public long count() {
        return items.size();
    }

    public boolean existsById(int id) {
        Item checker = findById(id);
        return checker != null;
    }


    public void delete(int id) {
        Item deletedItem = findById(id);
        if(deletedItem == null){
            throw new IllegalArgumentException("Item not found");
        }
        items.remove(deletedItem);
    }

    public void deleteAll(Item ... items) {

        for(Item item : items){
            if(existsById(item.getItemId())){
                delete(item.getItemId());
            }
            else {
                throw new IllegalArgumentException("Item not found");
            }
        }
    }

    public void deleteAll(){
        items.clear();
    }

    public void deleteAllById(int ... ids) {
        for(int id : ids){
            if(existsById(id)){
                delete(id);
            }
            else {
                throw new IllegalArgumentException("Item not found");
            }
        }
    }

    private void update(Item item) {
        Item original = findById(item.getItemId());
        original = item;
    }

    private void generateId(Item item) {
        count++;
        item.setItemId(count);
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getItemId() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> findAllById(int ... ids) {
        ArrayList<Item> foundItem = new ArrayList<>();
        for (int id : ids) {
            foundItem.add(findById(id));
        }
        return foundItem;

    }


}

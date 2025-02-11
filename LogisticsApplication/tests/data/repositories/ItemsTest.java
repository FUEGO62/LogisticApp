package data.repositories;

import data.models.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {

    @Test
    void testThatNewItemRepositoryIsEmpty() {
        Items items = new Items();
        long numberOfItems = items.count();
        assertEquals(0, numberOfItems);
    }

    @Test
    void testThatNewItemRepositoryCanSaveItems() {
        Items items = new Items();
        Item item = new Item("rice","food",2300);
        Item saved  = items.save(item);
        long numberOfItems = items.count();
        assertEquals(1, numberOfItems);
        assertEquals(saved,item);
    }

    @Test
    public void testThatNullItemsCantBeSaved() {
        Items items = new Items();
        assertThrows(IllegalArgumentException.class, () -> items.save(null));
        assertThrows(IllegalArgumentException.class, () -> items.saveAll(null,null,null));

    }

    @Test
    public void testThatNewItemRepositoryCanSaveMultipleItems(){
        Items items = new Items();
        Item item1 = new Item("rice","food",2300);
        Item item2 = new Item("rice","food",2300);
        items.saveAll(item1, item2);
        long numberOfItems = items.count();
        assertEquals(2, numberOfItems);

    }

    @Test
    public void testThatNewItemRepositoryCanFindItemById() {
        Items items = new Items();
        Item item = new Item("rice","food",2300);
        items.save(item);
        Item foundItem = items.findById(item.getItemId());
        assertEquals(item, foundItem);
    }

    @Test
    public void testThatNewItemRepositoryCanDeleteItem() {
        Items items = new Items();
        Item item = new Item("rice","food",2300);
        items.save(item);
        items.delete(item.getItemId());
        long numberOfItems = items.count();
        assertEquals(0, numberOfItems);
    }

    @Test
    public void testThatNewItemRepositoryCanDeleteAllItems() {
        Items items = new Items();
        Item item1 = new Item("rice","food",2300);
        Item item2 = new Item("rice","food",2300);

        items.save(item1);
        items.save(item2);
        items.deleteAll();
        assertEquals(0, items.count());
    }

    @Test
    public void testThatNewItemRepositoryCanUpdateItem() {
        Items items = new Items();
        Item item = new Item("rice","food",2300);
        items.save(item);
        item.setName("New name");
        items.save(item);
        long numberOfItems = items.count();
        assertEquals(1, numberOfItems);
    }

    @Test
    public void testThatNewItemRepositoryCanDeleteMultipleItems() {
        Items items = new Items();
        Item item1 = new Item("rice","food",2300);
        Item item2 = new Item("fish","food",2300);
        items.save(item1);
        items.save(item2);

        assertEquals(2, items.count());
        items.deleteAll(item1,item2);
        long numberOfItems = items.count();
        assertEquals(0, numberOfItems);
    }

    @Test
    public void testThatNewItemRepositoryCanDeleteMultipleItemsById() {
        Items items = new Items();
        Item item1 = new Item("rice","food",2300);
        Item item2 = new Item("fish","food",2300);
        items.save(item1);
        items.save(item2);

        assertEquals(2, items.count());
        items.deleteAllById(item1.getItemId(),item2.getItemId());
        long numberOfItems = items.count();
        assertEquals(0, numberOfItems);
    }

    @Test
    public void testThatDeleteThrowsExceptionWithInvalidNames() {
        Items items = new Items();
        Item item1 = new Item("rice","food",2300);
        items.save(item1);
        assertThrows(IllegalArgumentException.class, () -> items.delete(214580));
    }

    @Test
    public void testThatNewItemRepositoryCanFindItemAllItemById() {
        Items items = new Items();
        Item item1 = new Item("rice","food",2300);
        Item item2 = new Item("fish","food",2300);
        items.save(item1);
        items.save(item2);
        ArrayList<Item> foundItems = items.findAllById(item1.getItemId(),item2.getItemId());
        assertEquals(2, foundItems.size());
    }

}
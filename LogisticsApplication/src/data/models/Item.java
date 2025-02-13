package data.models;

public class Item {

    private String name;
    private String description;
    private int weightInGrams;
    private int itemId;
//    private Receiver receiver;
//    private Sender sender;

    public Item(String name, String description, int weightInGrams) {
        this.name = name;
        this.description = description;
        this.weightInGrams = weightInGrams;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

}

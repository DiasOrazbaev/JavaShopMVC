package kz.aitu.training.fastjava.models;

public class Item {
    private int ID;
    private String name;
    private String description;
    private double price = 0.0;

    public Item(int ID, String name, String description, double price) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

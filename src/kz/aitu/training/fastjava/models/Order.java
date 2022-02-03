package kz.aitu.training.fastjava.models;

public class Order {
    private int ID;
    private int customerID;
    private int itemID;
    private int amount;
    private double totalPrice;

    public Order(int ID, int customerID, int itemID, int amount, double totalPrice) {
        this.ID = ID;
        this.customerID = customerID;
        this.itemID = itemID;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public int getID() {
        return ID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getItemID() {
        return itemID;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

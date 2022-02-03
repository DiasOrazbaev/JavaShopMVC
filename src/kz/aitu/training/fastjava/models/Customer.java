package kz.aitu.training.fastjava.models;

public class Customer {
    private int ID;
    private String firstName;
    private String lastName;
    private double balance = 0.0;
    private String phone;

    public Customer(int ID, String firstName, String lastName, double balance, String phone) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public String getPhone() {
        return phone;
    }
}

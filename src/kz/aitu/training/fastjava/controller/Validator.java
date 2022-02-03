package kz.aitu.training.fastjava.controller;

import kz.aitu.training.fastjava.repository.CustomerRepository;
import kz.aitu.training.fastjava.repository.ItemRepository;

public class Validator {

    public static boolean validateIdx(CustomerRepository repository, int idx) {
        if (idx > repository.getAll().size()) {
            System.out.println("Please enter valid index!");
            return false;
        }
        return true;
    }

    public static boolean validateItemID(ItemRepository repository, int itemID) {
        if (itemID > repository.getItems().size()) {
            System.out.println("Please enter valid index!");
            return false;
        }
        return true;
    }
}

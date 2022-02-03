package kz.aitu.training.fastjava.controller;

import kz.aitu.training.fastjava.models.Customer;
import kz.aitu.training.fastjava.models.Item;
import kz.aitu.training.fastjava.repository.ItemRepository;

import java.util.List;

public class ItemController {
    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    public String getAllItems() {
        List<Item> customerList = repository.getItems();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < customerList.size(); i++) {
            stringBuilder.append(customerList.get(i).getID()).append(": ");
            stringBuilder.append(customerList.get(i).getName()).append(" ");
            stringBuilder.append(customerList.get(i).getPrice()).append("$ apiece\n");
        }
        return stringBuilder.toString();
    }
}

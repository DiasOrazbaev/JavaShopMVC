package kz.aitu.training.fastjava.controller;

import kz.aitu.training.fastjava.models.Customer;
import kz.aitu.training.fastjava.repository.CustomerRepository;

import java.util.List;

public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    public String getAllCustomers() {
        List<Customer> customerList = repo.getAll();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < customerList.size(); i++) {
            stringBuilder.append(customerList.get(i).getID()).append(": ");
            stringBuilder.append(customerList.get(i).getFirstName()).append(" ");
            stringBuilder.append(customerList.get(i).getLastName()).append("\n");
        }
        return stringBuilder.toString();
    }


}

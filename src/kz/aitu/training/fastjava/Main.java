package kz.aitu.training.fastjava;

import kz.aitu.training.fastjava.controller.CustomerController;
import kz.aitu.training.fastjava.database.PostgreSQL;
import kz.aitu.training.fastjava.repository.CustomerRepository;
import kz.aitu.training.fastjava.repository.ItemRepository;
import kz.aitu.training.fastjava.repository.OrderRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostgreSQL DB = new PostgreSQL();

        CustomerRepository customerRepository = new CustomerRepository(DB);
        ItemRepository itemRepository = new ItemRepository(DB);
        OrderRepository orderRepository = new OrderRepository(DB);

        CustomerController controller = new CustomerController(customerRepository);

        Application app = new Application(controller, scanner, customerRepository, itemRepository, orderRepository);

        app.app();
    }
}

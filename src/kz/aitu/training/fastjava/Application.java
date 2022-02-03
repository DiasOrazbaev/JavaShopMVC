package kz.aitu.training.fastjava;

import kz.aitu.training.fastjava.controller.CustomerController;
import kz.aitu.training.fastjava.controller.ItemController;
import kz.aitu.training.fastjava.controller.OrderController;
import kz.aitu.training.fastjava.controller.Validator;
import kz.aitu.training.fastjava.models.Customer;
import kz.aitu.training.fastjava.models.Item;
import kz.aitu.training.fastjava.models.Order;
import kz.aitu.training.fastjava.repository.CustomerRepository;
import kz.aitu.training.fastjava.repository.ItemRepository;
import kz.aitu.training.fastjava.repository.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class Application {

    private final Scanner scanner;

    private final CustomerController controller;
    private final CustomerRepository repository;

    private ItemRepository itemRepository;
    private ItemController itemController;

    private OrderRepository orderRepository;
    private OrderController orderController;

    private static String DELIMER = "********************************************************";


    public Application(CustomerController controller, Scanner scanner, CustomerRepository repository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.scanner = scanner;

        this.controller = controller;
        this.repository = repository;

        this.itemRepository = itemRepository;
        this.itemController = new ItemController(this.itemRepository);

        this.orderRepository = orderRepository;
        this.orderController = new OrderController(this.orderRepository);
    }

    public void printAllCustomers() {
        String customers = controller.getAllCustomers();
        System.out.println(customers);
    }

    public void printAllItems() {
        String items = itemController.getAllItems();
        System.out.println(items);
    }

    public void app() {
        List<Customer> customers = repository.getAll();
        List<Item> items = itemRepository.getItems();
        while (true) {
            System.out.println("Welcome to the SimplYShoP");
            System.out.println("Select Customer: ");

            int idx = 0;
            while (true) {
                printAllCustomers();
                idx = scanner.nextInt();
                if (!Validator.validateIdx(repository, idx)) {
                    continue;
                }
                break;
            }

            System.out.println("Selected " + customers.get(idx-1).getFirstName() + ". With " + customers.get(idx-1).getBalance() + "$ balance.");

            int itemID = 0;
            while (true) {
                printAllItems();
                itemID = scanner.nextInt();

                if (!Validator.validateItemID(itemRepository, itemID)) {
                    continue;
                }

                int maximum = (int) ((int)customers.get(idx-1).getBalance()/items.get(itemID-1).getPrice());
                System.out.println("How many you want " + items.get(itemID-1).getName() +
                        " ?(you can buy maximum " + maximum + " pieces)");

                int cnt = 0;
                cnt = scanner.nextInt();

                if (cnt > maximum) {
                    System.out.println("Not enough money to pay!");
                    System.out.println(DELIMER);
                    continue;
                }
                double totalPrice = cnt * items.get(itemID-1).getPrice();

                if (!orderController.createOrder(idx, itemID, cnt, totalPrice)) {
                    System.out.println("Failed to create new order");
                }
                else {
                    repository.updateBalance(idx, customers.get(idx-1).getBalance() - totalPrice);
                    System.out.println("Success! Order created! We can see after 2-3 days order!");
                }
                break;
            }
            break;
        }
    }
}

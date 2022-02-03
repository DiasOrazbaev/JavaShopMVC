package kz.aitu.training.fastjava.controller;

import kz.aitu.training.fastjava.models.Order;
import kz.aitu.training.fastjava.repository.OrderRepository;

public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }

    public boolean createOrder(int customerID, int itemID, int cnt, double totalPrice) {
        Order order = new Order(
                1,
                customerID,
                itemID,
                cnt,
                totalPrice
        );

        return repository.createOrder(order);
    }
}

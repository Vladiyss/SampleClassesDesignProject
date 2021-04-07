package by.vladiyss.sample.storage;

import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.exception.IncorrectOrderPersistenceException;
import by.vladiyss.sample.exception.IncorrectOrderItemsPersistenceException;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {

    public String persistOrder(Order order) throws IncorrectOrderPersistenceException {
        throw new IncorrectOrderPersistenceException("Storing order has failed!");
    }

    public boolean persistOrderItems(List<OrderItem> orderItems) throws IncorrectOrderItemsPersistenceException {
        throw new IncorrectOrderItemsPersistenceException("Storing order items has failed!");
    }

    public List<Order> loadOrdersByUserId(String userId) {
        List<Order> orders = new ArrayList<>();
        //some code
        return orders;
    }
}

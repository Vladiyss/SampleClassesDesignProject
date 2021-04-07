package by.vladiyss.sample.service;

import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.exception.IncorrectOrderItemsPersistenceException;
import by.vladiyss.sample.exception.IncorrectOrderPersistenceException;
import by.vladiyss.sample.exception.InvalidOrderException;
import by.vladiyss.sample.exception.InvalidOrderItemException;
import by.vladiyss.sample.storage.OrderStorage;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final OrderItemValidator orderItemValidator;
    private final OrderValidator orderValidator;
    private final OrderStorage orderStorage;

    public OrderService(OrderItemValidator orderItemValidator,
                        OrderValidator orderValidator, OrderStorage orderStorage) {
        this.orderItemValidator = orderItemValidator;
        this.orderValidator = orderValidator;
        this.orderStorage = orderStorage;
    }

    public boolean prepareOrderItemsForStoringToDatabase(List<OrderItem> orderItems, Order order)
            throws InvalidOrderItemException {
        for (OrderItem orderItem : orderItems) {
            if ( !(orderItemValidator.validateOrderItemBeforeAdding(orderItem)) ) {
                throw new InvalidOrderItemException(orderItem.hashCode() + "orderItem is invalid!");
            }
        }
        order.getItems().addAll(orderItems);
        return true;
    }

    public boolean prepareOrderForStoringToDatabase(Order order)
            throws InvalidOrderException  {
        if (!(orderValidator.validateOrder(order)) ) {
            throw new InvalidOrderException(orderValidator.hashCode() + " order is invalid!");
        }
        return true;
    }

    public boolean placeOrderItems(List<OrderItem> orderItems)
            throws  IncorrectOrderItemsPersistenceException {
        final boolean stored;
        try {
            stored = orderStorage.persistOrderItems(orderItems);
        }
        catch (IncorrectOrderItemsPersistenceException incorrectOrderItemsPersistenceException) {
            throw new IncorrectOrderItemsPersistenceException(incorrectOrderItemsPersistenceException.getMessage());
        }
        return stored;
    }

    public String placeOrder(Order order) throws IncorrectOrderPersistenceException  {

        String orderId = "---";
        orderId = orderStorage.persistOrder(order);
        return orderId;
    }

}

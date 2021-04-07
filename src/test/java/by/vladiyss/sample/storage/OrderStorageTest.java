package by.vladiyss.sample.storage;

import by.vladiyss.sample.data.OrderTestSamples;
import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.exception.IncorrectOrderItemsPersistenceException;
import by.vladiyss.sample.exception.IncorrectOrderPersistenceException;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderStorageTest {

    OrderStorage orderStorage = new OrderStorage();

    Order order = OrderTestSamples.validOrderWithItems();
    List<OrderItem> orderItems = OrderTestSamples.validOrderItems();

    @Test
    public void testPersistOrder() {
        assertThrows(IncorrectOrderPersistenceException.class,
                () -> orderStorage.persistOrder(order));
    }

    @Test
    public void testPersistOrderItems() {
        assertThrows(IncorrectOrderItemsPersistenceException.class,
                () -> orderStorage.persistOrderItems(orderItems));
    }

}

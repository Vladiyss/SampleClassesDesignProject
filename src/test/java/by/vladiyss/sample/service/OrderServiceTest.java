package by.vladiyss.sample.service;

import by.vladiyss.sample.data.OrderTestSamples;
import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.exception.IncorrectOrderItemsPersistenceException;
import by.vladiyss.sample.exception.IncorrectOrderPersistenceException;
import by.vladiyss.sample.exception.InvalidOrderException;
import by.vladiyss.sample.exception.InvalidOrderItemException;
import by.vladiyss.sample.storage.OrderStorage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderItemValidator orderItemValidator;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderItemValidator, orderValidator, orderStorage);
    }

    @Test
    public void test_prepareOrderItemsForStoringToDatabase_valid() {
        Order validOrder = OrderTestSamples.validOrderWithoutItems();
        List<OrderItem> validOrderItems = OrderTestSamples.validOrderItems();
        try {
            assertThat(true, equalTo(
                    orderService.prepareOrderItemsForStoringToDatabase(validOrderItems, validOrder)));
        } catch (InvalidOrderItemException invalidOrderItemException) {
            invalidOrderItemException.printStackTrace();
        }
    }

    @Test
    public void test_prepareOrderItemsForStoringToDatabase_invalid() {
        Order validOrder = OrderTestSamples.validOrderWithoutItems();
        List<OrderItem> invalidOrderItems = OrderTestSamples.invalidOrderItems();
        assertThrows(InvalidOrderItemException.class,
                () -> orderService.prepareOrderItemsForStoringToDatabase(invalidOrderItems, validOrder));
    }

    @Test
    public void test_prepareOrderForStoringToDatabase_valid() {
        Order validOrder = OrderTestSamples.validOrderWithItems();
        try {
            assertThat(true, equalTo(
                    orderService.prepareOrderForStoringToDatabase(validOrder)));
        } catch (InvalidOrderException invalidOrderException) {
            invalidOrderException.printStackTrace();
        }
    }

    @Test
    public void test_prepareOrderForStoringToDatabase_invalid() {
        Order invalidOrder = OrderTestSamples.invalidOrderWithItems();
        assertThrows(InvalidOrderException.class,
                () -> orderService.prepareOrderForStoringToDatabase(invalidOrder));
    }

    @Test
    public void test_placeOrderItems_exception() {
        List<OrderItem> validOrderItems = OrderTestSamples.validOrderItems();
        try {
            assertFalse(orderService.placeOrderItems(validOrderItems));
        } catch (IncorrectOrderItemsPersistenceException incorrectOrderItemsPersistenceException) {
            incorrectOrderItemsPersistenceException.printStackTrace();
        }
    }

    @Test
    public void test_placeOrder_exception() {
        Order validOrder = OrderTestSamples.validOrderWithoutItems();
        try {
            assertNull(orderService.placeOrder(validOrder));
        } catch (IncorrectOrderPersistenceException incorrectOrderPersistenceException) {
            incorrectOrderPersistenceException.printStackTrace();
        }
    }
}

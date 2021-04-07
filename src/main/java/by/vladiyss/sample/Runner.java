package by.vladiyss.sample;

import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderDeliveryAddress;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.domain.OrderStatus;
import by.vladiyss.sample.exception.IncorrectOrderItemsPersistenceException;
import by.vladiyss.sample.exception.IncorrectOrderPersistenceException;
import by.vladiyss.sample.exception.InvalidOrderException;
import by.vladiyss.sample.exception.InvalidOrderItemException;
import by.vladiyss.sample.service.OrderItemValidator;
import by.vladiyss.sample.service.OrderService;
import by.vladiyss.sample.service.OrderValidator;
import by.vladiyss.sample.storage.OrderStorage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory
            .getLogger(Runner.class);

    public static void main(String[] args) {
        OrderValidator orderValidator = new OrderValidator();
        OrderItemValidator orderItemValidator = new OrderItemValidator();
        OrderStorage orderStorage = new OrderStorage();
        OrderService orderService = new OrderService(orderItemValidator, orderValidator, orderStorage);

        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals.addAll(orderCostInitialization());

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Laptop Dell Inspiron 5570",
                2, bigDecimals.get(0), "DELL"));
        orderItems.add(new OrderItem("Smartphone Xiaomi Redmi Note 9",
                3, bigDecimals.get(1), "Xiaomi"));
        orderItems.add(new OrderItem("Chair 34f23",
                5, bigDecimals.get(2), "Some company"));

        OrderDeliveryAddress orderDeliveryAddress = new OrderDeliveryAddress(
                "Belarus", "Minsk region", "Minsk", "Some street", "245405");

        Order order = new Order("", OrderStatus.ON_CONFIRMATION, orderDeliveryAddress, LocalDate.now());

        try {
            boolean orderItemsPrepared = orderService.prepareOrderItemsForStoringToDatabase(orderItems, order);
        }
        catch (InvalidOrderItemException invalidOrderItemException) {
            logger.error("{}", invalidOrderItemException.getMessage());
            return;
        }
        logger.debug("The first stage - validation order items - success");

        try {
            boolean orderPrepared = orderService.prepareOrderForStoringToDatabase(order);
        }
        catch (InvalidOrderException invalidOrderException) {
            logger.error("{}", invalidOrderException.getMessage());
            return;
        }
        logger.debug("The second stage - validation order - success");

        final boolean orderItemsStored;
        try {
            orderItemsStored = orderService.placeOrderItems(order.getItems());
            logger.debug("Order items have been successfully stored");
        }
        catch (IncorrectOrderItemsPersistenceException incorrectOrderItemsPersistenceException) {
            logger.error("{}", incorrectOrderItemsPersistenceException.getMessage());
        }

        final String orderId;
        try {
            orderId = orderService.placeOrder(order);
        }

        catch (IncorrectOrderPersistenceException incorrectOrderPersistenceException) {
            logger.error("{}", incorrectOrderPersistenceException.getMessage());
            return;
        }

        logger.debug("Order Id - {}", orderId);

    }

    private static List<BigDecimal> orderCostInitialization() {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bigDecimals.add(new BigDecimal(i * i * 20 + 10.2 * i + 0.65 * i - 4.35 * i / 2));
        }
        return bigDecimals;
    }

}

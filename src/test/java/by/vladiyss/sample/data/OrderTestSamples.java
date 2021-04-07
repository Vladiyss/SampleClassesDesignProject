package by.vladiyss.sample.data;

import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderDeliveryAddress;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderTestSamples {

    public static List<OrderItem> validOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Laptop Dell Inspiron 5570",
                2, new BigDecimal(565), "DELL"));
        orderItems.add(new OrderItem("Smartphone Xiaomi Redmi Note 9",
                3, new BigDecimal(77675), "Xiaomi"));
        orderItems.add(new OrderItem("Chair 34f23", 5,
                new BigDecimal(52), "Some company"));
        return orderItems;
    }

    public static List<OrderItem> invalidOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Laptop Dell Inspiron 5570",
                -45, new BigDecimal(565), "DELL"));
        orderItems.add(new OrderItem("Smartphone Xiaomi Redmi Note 9",
                -67, new BigDecimal(77675), "Xiaomi"));
        return orderItems;
    }

    public static Order validOrderWithoutItems() {
        OrderDeliveryAddress orderDeliveryAddress = new OrderDeliveryAddress(
                "Belarus", "Minsk region", "Minsk", "Some street", "245405");
        Order order = new Order("", OrderStatus.ON_CONFIRMATION, orderDeliveryAddress, LocalDate.now());
        return order;
    }

    public static Order validOrderWithItems() {
        OrderDeliveryAddress orderDeliveryAddress = new OrderDeliveryAddress(
                "Belarus", "Minsk region", "Minsk", "Some street", "245405");
        Order order = new Order("", OrderStatus.ON_CONFIRMATION, orderDeliveryAddress, LocalDate.now());
        List<OrderItem> orderItems = validOrderItems();
        order.getItems().addAll(orderItems);
        return order;
    }

    /*public static Order invalidOrderWithoutItems() {
        OrderDeliveryAddress orderDeliveryAddress = new OrderDeliveryAddress(
                "Belarus", "Minsk region", "Minsk", "Some street", "245405");
        Order order = new Order("", OrderStatus.FINISHED, orderDeliveryAddress, LocalDate.now());
        return order;
    }*/

    public static Order invalidOrderWithItems() {
        OrderDeliveryAddress orderDeliveryAddress = new OrderDeliveryAddress(
                "Belarus", "Minsk region", "Minsk", "Some street", "245405");
        Order order = new Order("", OrderStatus.ON_DELIVERY, orderDeliveryAddress, LocalDate.now());
        List<OrderItem> orderItems = validOrderItems();
        order.getItems().addAll(orderItems);
        return order;
    }

}

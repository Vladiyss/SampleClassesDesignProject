package by.vladiyss.sample.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private final String userId;

    private OrderStatus status;
    private final List<OrderItem> items = new ArrayList<OrderItem>();

    private final OrderDeliveryAddress deliveryAddress;
    private final LocalDate dateOfPlacing;
    private LocalDate deliveryDate;

    public Order(String userId, OrderStatus status,
                 OrderDeliveryAddress deliveryAddress, LocalDate dateOfPlacing) {
        this.userId = userId;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.dateOfPlacing = dateOfPlacing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderDeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDate getDateOfPlacing() {
        return dateOfPlacing;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}

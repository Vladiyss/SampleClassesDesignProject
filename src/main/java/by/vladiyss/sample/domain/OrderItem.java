package by.vladiyss.sample.domain;

import java.math.BigDecimal;

public class OrderItem {
    private String name;
    private final int count;
    private final BigDecimal cost;

    private String producer;
    private Order order;

    public OrderItem(String name, int count, BigDecimal cost, String producer) {
        this.name = name;
        this.count = count;
        this.cost = cost;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Order getOrder() {
        return order;
    }

}

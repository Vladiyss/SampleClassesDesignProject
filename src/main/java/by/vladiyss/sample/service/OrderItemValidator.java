package by.vladiyss.sample.service;

import by.vladiyss.sample.domain.OrderItem;

public class OrderItemValidator {

    public boolean validateOrderItemBeforeAdding(OrderItem orderItem) {

        if (orderItem.getName() == null) {
            return false;
        }

        if (orderItem.getCount() <= 0) {
            return false;
        }

        if (orderItem.getProducer() == null) {
            return false;
        }

        if (orderItem.getCost() == null) {
            return false;
        }

        //orderItem.order --- field to be set, so it hasn't been passed for validation

        return true;
    }
}

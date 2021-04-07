package by.vladiyss.sample.service;

import by.vladiyss.sample.domain.Order;
import by.vladiyss.sample.domain.OrderItem;
import by.vladiyss.sample.domain.OrderStatus;

public class OrderValidator {

    public boolean validateOrder(Order order) {

        if (order.getStatus() != OrderStatus.ON_CONFIRMATION) {
            return false;
        }

        if (order.getUserId() == null) {
            return false;
        }

        if ( (order.getItems() == null) || (order.getItems().size() == 0) ) {
            return false;
        }

        if (order.getDeliveryAddress() == null) {
            return false;
        }

        if (order.getDateOfPlacing() == null) {
            return false;
        }

        // deliveryDate will be set later
        //id will be set by database

        return true;
    }
}

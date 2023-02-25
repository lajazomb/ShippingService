package com.bookstore.shippingservice.port.order.exception;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException() {
        super("The requested order(s) could not be found");
    }

}

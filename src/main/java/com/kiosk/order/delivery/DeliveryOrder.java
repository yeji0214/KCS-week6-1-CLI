package com.kiosk.order.delivery;

public class DeliveryOrder {
    private static int idCounter = 0;
    private final int orderId;

    public DeliveryOrder() {
        this.orderId = ++idCounter;
    }

    public int getOrderId() {
        return orderId;
    }
}

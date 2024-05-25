package com.kiosk.order.delivery;

public class OrderProcessor extends Thread {
    private final DeliveryOrder order;

    public OrderProcessor(DeliveryOrder order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            // 메뉴 포장 (3초)
            Thread.sleep(3000);
            System.out.println("Order " + order.getOrderId() + " is packaged.");

            // 배달 기사 도착 (5초)
            Thread.sleep(5000);
            System.out.println("Delivery person arrived for order " + order.getOrderId());

            // 배달 완료 (10초)
            Thread.sleep(10000);
            System.out.println("Order " + order.getOrderId() + " delivered.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("OrderProcessor for order " + order.getOrderId() + " interrupted");
        }
    }
}

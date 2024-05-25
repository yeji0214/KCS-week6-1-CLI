package com.kiosk.order.delivery;

import java.util.Scanner;

public class OrderReceiver extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Thread.sleep(10000);
                DeliveryOrder order = new DeliveryOrder();
                System.out.println("New delivery order received: " + order.getOrderId());

                OrderProcessor orderProcessorThread = new OrderProcessor(order);
                orderProcessorThread.start();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("OrderReceiver interrupted");
                break;
            }
        }
    }
}

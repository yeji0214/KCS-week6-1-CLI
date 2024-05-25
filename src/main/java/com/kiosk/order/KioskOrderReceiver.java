package com.kiosk.order;

import java.util.Scanner;

public class KioskOrderReceiver extends Thread {
    private final Order order;

    public KioskOrderReceiver(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        handleUserOrders();
    }

    private void handleUserOrders() {
        order.start();
    }
}

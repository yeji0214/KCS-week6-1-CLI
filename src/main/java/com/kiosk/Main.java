package com.kiosk;

import com.kiosk.order.Order;
import com.kiosk.thread.OrderPreparationThread;
import com.kiosk.thread.DisplayBoardThread;

public class Main {
    public static void main(String[] args) {
        // 기존 사용자 주문 처리 로직
        new Order().start();

        // 결제 완료 후 주문 번호 생성 및 처리
        int orderNumber = OrderPreparationThread.generateOrderNumber();
        System.out.println("주문 번호: " + orderNumber);

        // 전광판 스레드 생성 및 시작
        DisplayBoardThread displayBoardThread = new DisplayBoardThread(orderNumber);
        displayBoardThread.start();

        // 주문 준비 스레드 생성 및 시작
        OrderPreparationThread orderThread = new OrderPreparationThread(orderNumber, displayBoardThread);
        orderThread.start();

        try {
            // 주문 준비 스레드가 완료될 때까지 대기
            orderThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }
    }
}

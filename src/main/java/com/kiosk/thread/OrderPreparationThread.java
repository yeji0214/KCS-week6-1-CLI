package com.kiosk.thread;

import java.util.Random;

public class OrderPreparationThread extends Thread {
    private int orderNumber;
    private DisplayBoardThread displayBoardThread;

    public OrderPreparationThread(int orderNumber, DisplayBoardThread displayBoardThread) {
        this.orderNumber = orderNumber;
        this.displayBoardThread = displayBoardThread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(orderNumber * 1000);  // 주문 번호에 해당하는 시간(초)만큼 대기
            displayBoardThread.setOrderReady();
            System.out.println("\n메뉴가 준비되었습니다. 기다려주셔서 감사합니다.");
            System.out.println("맛있게 드세요!😋");
        } catch (InterruptedException e) {
            System.err.println("Order preparation interrupted.");
        }
    }

    public static int generateOrderNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }
}


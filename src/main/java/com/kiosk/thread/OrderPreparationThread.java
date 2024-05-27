package com.kiosk.thread;

import com.kiosk.util.Constants;

import java.util.Random;

// 주문 준비를 담당하는 스레드
// 주문 번호에 해당하는 시간(초)만큼 대기한 후, 준비 완료 메시지를 출력
public class OrderPreparationThread extends Thread {
    private int orderNumber; // 주문 번호
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
            System.out.println(Constants.ORDER_READY_MESSAGE);
            System.out.println(Constants.ENJOY_MESSAGE);
        } catch (InterruptedException e) {
            System.err.println(Constants.ORDER_PREPARATION_INTERRUPTED_MESSAGE);
        }
    }

    // 1부터 20까지의 랜덤한 주문 번호를 생성
    public static int generateOrderNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }
}


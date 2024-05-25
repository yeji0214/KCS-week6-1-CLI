package com.kiosk.thread;

public class DisplayBoardThread extends Thread {
    private volatile boolean isOrderReady = false;
    private int maxOrderNumber;

    public DisplayBoardThread(int maxOrderNumber) {
        this.maxOrderNumber = maxOrderNumber;
    }

    @Override
    public void run() {
        int currentNumber = 1;
        while (!isOrderReady && currentNumber <= maxOrderNumber) {
            System.out.print("\r준비 완료: " + currentNumber + "번"); // 같은 줄에 출력
            currentNumber++;
            try {
                Thread.sleep(1000);  // 1초 대기
            } catch (InterruptedException e) {
                System.err.println("Display board interrupted.");
            }
        }
        System.out.println(); // 마지막에 줄 바꿈 추가
    }

    public void setOrderReady() {
        isOrderReady = true;
    }
}


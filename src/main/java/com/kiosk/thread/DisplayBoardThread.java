package com.kiosk.thread;

import com.kiosk.util.Constants;

// 전광판에 주문 준비 상태를 표시하는 스레드
// 1초마다 숫자를 증가시켜 "준비 완료: X번" 메시지를 같은 줄에 출력
public class DisplayBoardThread extends Thread {
    private volatile boolean isOrderReady = false; // 주문 준비 완료 여부를 나타내는 상태 변수
    private int maxOrderNumber; // 최대 주문 번호

    public DisplayBoardThread(int maxOrderNumber) {
        this.maxOrderNumber = maxOrderNumber;
    }

    @Override
    public void run() {
        int currentNumber = 1;
        while (!isOrderReady && currentNumber <= maxOrderNumber) {
            System.out.print(Constants.ORDER_READY_LABEL + currentNumber + Constants.NUMBER_SUFFIX); // 같은 줄에 출력
            currentNumber++;
            try {
                Thread.sleep(1000);  // 1초 대기
            } catch (InterruptedException e) {
                System.err.println(Constants.DISPLAY_BOARD_INTERRUPTED_MESSAGE);
            }
        }
        System.out.println(); // 마지막에 줄 바꿈 추가
    }

    // 주문 준비 완료 상태를 설정
    public void setOrderReady() {
        isOrderReady = true;
    }
}


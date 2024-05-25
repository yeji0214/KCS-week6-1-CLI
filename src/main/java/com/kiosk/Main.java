package com.kiosk;

import com.kiosk.order.KioskOrderReceiver;
import com.kiosk.order.Order;
import com.kiosk.order.delivery.OrderReceiver;

public class Main {
    public static void main(String[] args) {
        // 키오스크 주문 수신 스레드 시작
        Order kioskOrder = new Order();
        KioskOrderReceiver kioskOrderReceiverThread = new KioskOrderReceiver(kioskOrder);
        kioskOrderReceiverThread.start();

        // 배달 주문 수신 스레드 시작
        OrderReceiver orderReceiverThread = new OrderReceiver();
        orderReceiverThread.start();

        // 기존 사용자 주문 처리 로직
//        new Order().start();


        // 프로그램 종료 시 스레드 종료
        try {
            orderReceiverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

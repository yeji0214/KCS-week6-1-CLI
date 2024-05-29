# 이삭토스트 키오스크

이삭토스트 키오스크 CLI 프로그램입니다.

![Toast, Hash Brown, and Cola](images/toast_hashbrown_cola.webp)

## 프로젝트 구조
````css
src
└── main
    └── java
        └── com
            └── kiosk
                ├── Main.java
                ├── menu
                │   ├── drink
                │   │   ├── CaffeineDrink.java
                │   │   ├── Drink.java
                │   │   └── NonCaffeineDrink.java
                │   ├── side
                │   │   └── Side.java
                │   ├── toast
                │   │   └── Toast.java
                │   └── MenuItem.java
                ├── order
                │   ├── DrinkOrderProcessor.java
                │   ├── InputHandler.java
                │   ├── Menu.java
                │   ├── MenuDisplayer.java
                │   ├── Order.java
                │   ├── PaymentProcessor.java
                │   ├── SetOrderProcessor.java
                │   ├── SideOptionSelector.java
                │   ├── SideOrderProcessor.java
                │   ├── ToastOptionSelector.java
                │   └── ToastOrderProcessor.java
                ├── thread
                │   ├── DisplayBoardThread.java
                │   └── OrderPreparationThread.java
                └── util
                    └── Constants.java

````

### 디렉토리 설명

- **src/main/java/com/kiosk/**: 프로젝트의 주 패키지 디렉토리입니다.
    - `Main.java`: 프로그램의 진입점입니다.
    - **menu/**: 메뉴 관련 클래스들이 위치하는 디렉토리입니다.
        - **drink/**: 음료 관련 클래스들이 위치하는 디렉토리입니다.
            - `CaffeineDrink.java`: 카페인이 포함된 음료를 나타내는 클래스입니다.
            - `Drink.java`: 음료의 기본 클래스입니다.
            - `NonCaffeineDrink.java`: 카페인이 포함되지 않은 음료를 나타내는 클래스입니다.
        - **side/**: 사이드 메뉴 관련 클래스들이 위치하는 디렉토리입니다.
            - `Side.java`: 사이드 메뉴를 나타내는 클래스입니다.
        - **toast/**: 토스트 메뉴 관련 클래스들이 위치하는 디렉토리입니다.
            - `Toast.java`: 토스트 메뉴를 나타내는 클래스입니다.
        - `MenuItem.java`: 메뉴 아이템을 나타내는 클래스입니다.
    - **order/**: 주문 처리 관련 클래스들이 위치하는 디렉토리입니다.
        - `DrinkOrderProcessor.java`: 음료 주문을 처리하는 클래스입니다.
        - `InputHandler.java`: 입력을 처리하는 클래스입니다.
        - `Menu.java`: 메뉴 관련 클래스입니다.
        - `MenuDisplayer.java`: 메뉴를 표시하는 클래스입니다.
        - `Order.java`: 주문 정보를 나타내는 클래스입니다.
        - `PaymentProcessor.java`: 결제 처리를 담당하는 클래스입니다.
        - `SetOrderProcessor.java`: 세트 주문을 처리하는 클래스입니다.
        - `SideOptionSelector.java`: 사이드 옵션을 선택하는 클래스입니다.
        - `SideOrderProcessor.java`: 사이드 주문을 처리하는 클래스입니다.
        - `ToastOptionSelector.java`: 토스트 옵션을 선택하는 클래스입니다.
        - `ToastOrderProcessor.java`: 토스트 주문을 처리하는 클래스입니다.
    - **thread/**: 스레드 관련 클래스들이 위치하는 디렉토리입니다.
        - `DisplayBoardThread.java`: 전광판에 준비 완료된 메뉴 번호를 표시하는 스레드 클래스입니다.
        - `OrderPreparationThread.java`: 주문 번호 발급 후 준비가 완료될 때까지 대기하는 스레드 클래스입니다.
    - **util/**: 유틸리티 클래스들이 위치하는 디렉토리입니다.
        - `Constants.java`: 프로젝트 전역에서 사용하는 상수들을 정의한 클래스입니다.

## 기능 설명

- **메뉴 관리**: 다양한 메뉴 항목(음료, 사이드, 토스트)을 관리합니다.
- **주문 처리**: 사용자의 주문을 받아 처리하고, 전광판에 완료된 주문 번호를 표시합니다.
- **결제 처리**: 사용자의 결제 정보를 처리합니다.
- **스레드 관리**: 주문 준비 상태와 전광판 업데이트를 위한 스레드를 관리합니다.
- **유틸리티**: 상수를 제공합니다.

## 동작 방식

1. `Main.java`를 실행하여 프로그램을 시작합니다.
2. 메뉴를 선택하고 주문을 완료합니다.
3. 결제를 완료합니다.
4. 주문 번호를 확인하고, 전광판에서 주문 상태를 확인합니다.


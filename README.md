# 이삭토스트 키오스크

이삭토스트 키오스크 CLI 프로그램입니다.

<div align="center">
    <img src="src/images/toast_hashbrown_cola.webp" alt="Toast, Hash Brown, and Cola" width="300"/>
</div>

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

## 동작 방식

사용자는 주문하고 싶은 메뉴와 옵션을 선택한 뒤,

1. 담기 (장바구니에 담고 계속 주문 진행)
2. 주문하기 (이때까지 장바구니에 담긴 메뉴 계산)
3. 취소 (지금 선택한 메뉴를 담지 않음)

중 선택할 수 있다.

- 토스트, 사이드, 음료를 단품으로 주문할 수 있으며 토스트 옵션에서 세트로 바꿀 수 있다.
- 토스트마다 빵 선택 가능 여부, 계란 선택 가능 여부는 달라질 수 있다.
- 사이드마다 케첩 선택 가능 여부는 달라질 수 있다.
- 토스트 메뉴판에서 0번을 선택하면, 각 토스트의 재료를 확인할 수 있다.
- 음료 메뉴판에서 0번을 선택하면, 각 음료의 카페인 함량을 확인할 수 있다.
- 결제의 경우 한 번에 결제, 나눠서 결제 중에 선택할 수 있다.
- 결제가 완료되면 1부터 20까지의 정수 중 랜덤으로 주문 번호가 생성된다.
- 주문 번호의 초만큼 대기하면 메뉴가 준비된다. (ex. 5번 → 5초)

## 상속 관계
<img src="src/images/UML_diagram.png" alt="UML diagram.png"/>

## 클래스 별 설명

### 
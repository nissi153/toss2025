//연습문제 - 클래스 상속
//
//부모클래스 - 나무     Wood
//          속성 가격 int price = 1000
//         행동 불탄다 burn()
//자식클래스 - 나무책상 WoodDesk
//          속성  color  "흰색"
//          행동  study   "공부를 한다."
//         - 나무의자 WoodChair
//          속성  color  "갈색"
//           행동  sit    "앉는다"
//자식클래스의 객체를 생성하고 속성과 행동을 출력하시오.
class Wood {
    int price = 1000;

    void burn() {
        System.out.println("불에 잘 탄다.");
    }
}

class WoodDesk extends Wood {
    String color = "흰색";

    void study() {
        System.out.println("공부한다.");
    }
}

class WoodChair extends Wood {
    String color = "갈색";

    void sit() {
        System.out.println("앉는다.");
    }
}

public class ex29 {
    public static void main(String[] args) {
        WoodDesk desk = new WoodDesk();
        System.out.println(desk.price);
        System.out.println(desk.color);
        desk.burn();
        desk.study();
        WoodChair chair = new WoodChair();
        System.out.println(chair.price);
        System.out.println(chair.color);
        chair.burn();
        chair.sit();
    }
}

//객체지향프로그래밍(OOP)
//  : 모든 사물을 객체(물건,사물)로 추상화(모델링,설계)하여
//    프로그래밍하는 기법
//  : C언어 - main()함수과 일반함수로 모든 코드를 구현했다.
//    main.c 5000행이다.
// 예) 자동차
//    속성과 행동으로 정의한다.
//    변수,필드   함수,메소드

//클래스 선언
class Car {
    //속성(변수)
    int price = 1000;
    //행동(메소드)
    void run() {
        System.out.println("차가 달린다.");
    }
}

public class ex19 {
    public static void main(String[] args) {
        //클래스이름 객체(인스턴스)이름 = new 클래스이름();
        Car car = new Car();

        //멤버변수 접근하려면, 객체이름 뒤에 점.을 찍는다.
        System.out.println(car.price);
        //멤버함수 접근하려면, 객체이름 뒤에 점.을 찍는다.
        car.run();

        //System.out.println( car.run() ); //void변환값을 출력X
    }
}

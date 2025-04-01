//추상화클래스와 인터페이스 차이점

//추상화(일반) 클래스 : 다중상속은 안됨. 다단계 상속은 가능
class A {
}
class B extends A{
}
class C extends B{
}
//class D extends A, B, C {
//}

interface IA {
}
interface IB{
}
class E implements IA, IB { //다중상속
}

// 추상화 클래스 1개 상속받고, 인터페이스 다중상속(구현)하는 경우
class SupermanClass extends C implements IA, IB {

}


public class ex39 {
    public static void main(String[] args) {

    }
}

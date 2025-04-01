// final 키워드
// 1. final 변수 - 상수형 변수를 선언할 때
// 2. final class : 상속 불가
// 3. final 메소드 : 오버라이드 불가
//final
class FinalClass {
    String name = "파이널 클래스";
    int age; // 0으로 초기화됨.
    final int price = 1000; //상수형 변수, 초기화 필수!
    final void disp() { } //오버라이드 불가
}
class LastClass extends FinalClass {
//    @Override
//    void disp() { }
}

public class ex33 {
    public static void main(String[] args) {
        int i = 10;
        final int j = 20; //상수로 지정됨.
        //j = 30;
    }
}

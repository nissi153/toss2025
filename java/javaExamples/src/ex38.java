//인터페이스 Interface
//  : 가상함수(추상메소드)만 있는 코드 뭉치

//용도 : 추상화 메소드의 설계/구현의 기능과 유사함.
//          추상화 클래스      인터페이스
//1.가상함수  있음             있음
//2.일반함수  있음             없음(default메소드)
//3.예약어    abstract class  interface
//           abstract 메소드명  abstract생략가능
//           extends          implements
//4.다중상속  불가능             가능
//5.객체생성  불가능(상속해야)    불가능(구현해야)
//6.접근제한자 public/protected/private  public만 가능
//7.필드 선언  가능             public static만 가능

interface Drawing {
    //가상함수만 사용가능
    abstract void draw();
    void sketch();
    //일반함수 사용불가
}
class Painter implements Drawing {
    @Override
    public void draw() {
        System.out.println("드로윙");
    }

    @Override
    public void sketch() {
        System.out.println("스케치");
    }
}

public class ex38 {
    public static void main(String[] args) {
        Painter p = new Painter();
        p.draw();
        p.sketch();
    }
}

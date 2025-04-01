//추상화 클래스 abstract class
//   : 일반 클래스 + 가상함수(추상화 메소드)
//가상함수 : 함수의 선언만 있고, 본체(코드)가 없는 것.
//        : 본체는 하위클래스에서 재정의(Override)해서 사용함.

//사용하는 이유 :
//1. 설계와 구현의 관점에서 생각
// 설계 : 건축에서 설계도의 역할, 단시간에 전체구조와 기능명세를 설계할 수 있다.
// 구현 :         시공의 역할, 실제 기능구현은 코더(Coder)가 구현한다.
//2. 기능을 정의하고 실제 구현은 나중에 한다.
//    추상화         구체화
//    그림을 그린다.  동양화를 그린다.
//                  서양화를 그린다.
//3. 코드를 업데이트시에 기존에 있던 코드를 놔두고 업데이트 가능하다.

//추상화 클래스
abstract class Picture {
    //가상함수
    abstract void draw(); //선언만 존재
    //일반함수
    void sale(){
        System.out.println("판다.");
    }
}
class Picasso extends Picture {
    @Override
    void draw() {
        System.out.println("피카소가 그림을 그린다.");
    }
}
class SuperPicasso extends Picture {
    @Override
    void draw() {
        System.out.println("수퍼피카소가 그림을 그린다.");
    }
}

public class ex37 {
    public static void main(String[] args) {
        Picasso picasso = new Picasso();
        picasso.draw();
        SuperPicasso superPicasso = new SuperPicasso();
        superPicasso.draw();

    }
}

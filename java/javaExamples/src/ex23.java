//연습문제 - 클래스 Getter/Setter 설계
// 책상(Desk)을 클래스로 설계해보자.
// 속성 : price 가격은 1000으로 초기화한다.
//       접근권한 private으로
// 행동 : Getter/Setter 함수를 만들어보자.
// 출력값 : price을 2000으로 바꾸고 가격을 출력하시오.
// Getter/Setter자동생성 : 우클릭->생성->Getter 및 Setter
class Desk {
    private int price = 1000;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class ex23 {
    public static void main(String[] args) {
        Desk desk = new Desk();
        desk.setPrice( 2000 );
        System.out.println( desk.getPrice() );
    }
}

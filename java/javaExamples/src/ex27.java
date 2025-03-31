//생성자 함수(Constructor)
//   : 클래스 객체가 생성될 때(new) 자동으로 호출되는 메소드
//   : 용도 - 클래스 필드 초기화 할 때
class Book {
    int price = 1000;
    //생성자 함수
    //패턴 : public 반환타입X 클래스이름(){ }
    public Book() {
        System.out.println("생성자 호출됨!");
        this.price = 2000;
    }
    void read () {
        System.out.println("읽는다.");
    }
}

public class ex27 {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println( book.price );
    }
}

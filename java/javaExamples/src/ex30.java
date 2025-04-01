//메소드 오버라이딩(Over riding), 올라타기
//  : 상속관계에서 자식클래스의 메소드가
//   부모클래스의 메소드를 재정의 하는 것
class Cable {
    int price = 1000;
    void sale(){
        System.out.println("Cable 판매");
    }
}
class PowerCable extends Cable {
    int price = 2000;
    @Override // 어노테이션 : 컴파일지시어
    void sale(){
        System.out.println("PowerCable 판매");
    }
}
public class ex30 {
    public static void main(String[] args) {
        PowerCable pc = new PowerCable();
        System.out.println(pc.price);
        pc.sale();
    }
}

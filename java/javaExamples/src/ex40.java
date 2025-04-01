//익명 객체(이름없는 객체 - Anonymous Object)
//   : 일회성 메소드(코드뭉치) 재정의시 사용한다.
//   : 한번 쓰고 버릴 코드에 굳이 이름을 붙여서 사용할 필요가 없다.
interface NormalCar {
    void run();
}
//class SuperCar implements NormalCar {
//    @Override
//    public void run() {
//        System.out.println("수퍼카가 달린다.");
//    }
//}
public class ex40 {
    public static void main(String[] args) {
//        SuperCar sc = new SuperCar();
//        sc.run();
        //일회성 익명 인터페이스 구현 객체를 생성한다.
        NormalCar normalCar = new NormalCar(){
          @Override
          public void run(){
              System.out.println("수퍼카가 달린다.");
          }
        };
        normalCar.run();
    }
}

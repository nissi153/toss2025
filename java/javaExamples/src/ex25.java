//싱글톤(Singleton)
//  : 프로그램안에서의 유일한 클래스 객체
//  : new를 통해서 여러개의 객체를 반복적으로 찍어낼 수 있다.
//  : 예) 붕어빵1, 붕어빵2, ....
//      절대붕어빵(유일한 붕어빵)
//유일한 객체가 필요한 이유
//  : 유일한 정보를 저장하기 위해서
class FishBun { //일반붕어빵
    int bunNo = 10;
}
class UniqueFishBun {
    int bunNo = 30;
    private static UniqueFishBun singleton; //null
    static UniqueFishBun getInstance() {
        if (singleton == null) {
            singleton = new UniqueFishBun();
        }
        return singleton;
    }
}
public class ex25 {
    public static void main(String[] args) {
        UniqueFishBun uBun1 = UniqueFishBun.getInstance();
        UniqueFishBun uBun2 = UniqueFishBun.getInstance();
        System.out.println( uBun1 ); //119d7047
        System.out.println( uBun2 ); //119d7047
        uBun1.bunNo = 40;
        System.out.println( uBun1.bunNo );
        System.out.println( uBun2.bunNo );

        FishBun bun1 = new FishBun();
        FishBun bun2 = new FishBun();
        System.out.println(bun1); //4eec7777
        System.out.println(bun2); //3b07d329
        bun1.bunNo = 20;
        System.out.println( bun1.bunNo);
        System.out.println( bun2.bunNo);
        //일반 객체는 일관된 데이터를 저장하기 어렵다.
        //dynamic 객체는 Heap 영역에 저장된다.
        //GC(Garbage Collector)가 자동으로 메모리를 자동회수한다.
    }
}

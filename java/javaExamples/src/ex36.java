class People {
    void think(){
        System.out.println("생각한다.");
    }
}
class Man extends People {
    @Override
    void think() {
        System.out.println("남자가 생각한다.");
    }
    void shave() {
        System.out.println("면도한다.");
    }
}
class Woman extends People {
    @Override
    void think() {
        System.out.println("여자가 생각한다.");
    }
    void makeup(){
        System.out.println("화장한다.");
    }
}

public class ex36 {
    public static void main(String[] args) {
        //1.업캐스팅
        People people = new Man();
        people.think();
        //2.다운캐스팅
        ((Man)people).shave();

        //다형성을 이용하여 Man객체, Woman객체도 전달할 수 있다.
        myFunc( new People() );
        myFunc( new Man() );
        myFunc( new Woman() );
    }

    static void myFunc( People p ) {
        //instanceof 연산자 : 객체 타입을 확인하는 연산자
        if( p instanceof Man ) {
            Man m = (Man)p;
            m.shave();
        }
        else if( p instanceof Woman) {
            Woman w = (Woman)p;
            w.makeup();
        }
    }

}

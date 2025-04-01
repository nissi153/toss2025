//다형성 : 폴리모피즘
//   : 자식클래스 객체가 자기클래스 또는 부모클래스의 타입을
//      모두 가질 수 있는 것.
//이유 : 타입의 유연성을 가지기 위해서.
//     : 타입이 정확하지 않더라도 객체(참조변수)를 전달 가능.
class Parent {
    String name = "Parent";
    void parentMethod(){
        System.out.println("Parent 내 이름은 " + this.name);
    }
}
class Child extends Parent {
    String name = "Child";
    void childMethod(){
        System.out.println("Child 내 이름은 " + this.name);
    }
}
public class ex35 {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        System.out.println( p1.name );
        Child c1 = new Child();
        System.out.println( c1.name );

        //1. 업캐스팅(Up Cast) : 자식객체가 부모클래스 타입을 가지는 것
        //1) 대입연산자를 통해서
        Parent p2 = new Child();
        System.out.println( p2.name );
        //2) 강제형변환 연산자를 통해서
        Parent p3 = (Parent) c1;
        System.out.println( p3.name );

        //2. 다운캐스팅(Down Cast) : 자식객체가 자식클래스 타입을 가지는 것
        Child c2 = (Child)p2;
        System.out.println( c2.name );

        //4가지 형태
        Parent a = new Parent();
        Child b = new Child();
        Parent c = new Child();
        Child d = (Child)c;

        //Child e = new Parent(); 불가능하다.
    }
}

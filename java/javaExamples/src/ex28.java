//코드 중복 : 10개의 똑같은 코드가 있다면? 유지보수가 힘들다.
//코드 중복을 줄이는 방법
//0. 반복문이나 배열/리스트를 사용한다.
//1. 함수로 재사용한다.
//2. 클래스(필드+함수)로 재사용한다.
//3. 클래스 상속을 이용한다. => 타입의 유연성 - 다형성
//4. 추상화 클래스나 인터페이스를 사용한다.

//클래스의 상속
//   : 부모(상위) 클래스의 유산(자원-함수와 변수)를 자식(하위) 클래스가
//      물려받은 것.
//  사용이유
// 1. 코드 중복 피할 수 있다.
// 2. 계층적인 구조로 코드를 설계할 수 있다.
//예)  강아지 : 동물 속성/행동 + 강아지고유의 속성/행동
//     고양이 : 동물 속성/행동 + 고양이고유의 속성/행동
class Animal {
    int age = 20;
    void eat() {
        System.out.println("먹는다.");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("짖는다.");
    }
}
class Cat extends Animal{
   void grooming() {
       System.out.println("손질한다.");
   }
}

public class ex28 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        System.out.println( dog.age );
        dog.eat();
    }
}

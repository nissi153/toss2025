public class ex24 {
    static void echo(){
        System.out.println("echo");
    }
    static void echo(String str){
        System.out.println("echo "+str);
    }
    static void echo(int i){
        System.out.println("echo "+i);
    }
    static void echo(int i, int j){
        System.out.println("echo "+i+" "+j);
    }

    public static void main(String[] args) {
        echo();
        echo("hey~");
        echo( 10 );
        echo( 10, 20 );

        //메소드 오버로딩(Overloading), 과적
        //  : 매개변수의 타입과 갯수를 다르게 함으로
        //    함수의 기능을 확장하는 것
        //  : 같은 이름의 함수를 여러번 사용할 수 있다.
        //  : println( 정수형 ) => printlnInt
        //    println( 문자열 ) => printlnStr

        //메소드 오버라이딩(Over riding), 올라타기
        //  : 상속관계에서 자식클래스의 메소드가
        //   부모클래스의 메소드를 재정의 하는 것

        //기술면접 질문
        //1. 오버로딩 vs 오버라이드
        // 오버라이드 : 상속관계에서 자식클래스가 부모클래스
        //   메소드를 재정의하는 것.
        //2. 추상화 클래스 vs 인터페이스
        //3. 다형성
        //4. 상속
        //5. 생성자

    }
}

public class ex53 {
    public static void main(String[] args) {
        //래퍼 클래스 (Wrapper Class)
        //1. 기본자료형 8개를 감싸서 클래스로 만든 것
        //2. 클래스로 만들어야 다형성을 이용가능하다.

        //기본자료형 8개: int long short byte char boolean float double
        //래퍼클래스: Integer Long Short Byte Character Boolean Float Double
        //숫자클래스: Number <= int long short byte float double

        Integer intValue1 = new Integer( 10 ); //JDK9부터는 비추천
        Integer intValue2 = 10;  //추천하는 방법
        System.out.println( intValue2 );
        System.out.println( intValue2.byteValue() );
        System.out.println( intValue2.doubleValue() );

        Number number1 = 30;
        Number number2 = 3.14d;
        System.out.println( number1.intValue() );
        System.out.println( number2.byteValue() );
    }
}

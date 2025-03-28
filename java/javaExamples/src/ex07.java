public class ex07 {
    public static void main(String[] args) {
        //산술 : + - * / %     << >> >>>(비트단위 이동연산자)
        int i = 10;
        int j = 3;
        System.out.println( i + j );
        System.out.println( i - j );
        System.out.println( i * j );
        System.out.println( i / j );//나눗셈의 몫
        System.out.println( i % j );//나눗셈의 나머지

        //나머지 연산자 %
        int k = 123;
        //연습문제 - 나머지연산자를 이용하여
        //1. 일의 자릿수 3을 출력하시오.
        System.out.println( k % 10 );
        //2. 십의 자릿수 2를 출력하시오.
        System.out.println( (k / 10) % 10 );
        //3. 백의 자릿수 1을 출력하시오.
        System.out.println( (k / 100) % 10 );
        double d = 3.567;
        //4. 소숫점 첫째자리를 출력하시오.
        //출력예) 5
        System.out.println( (int)(d*10 % 10) );
        //*소숫점 없애기
        //1. Math.floor
        //2. (int) 형변환연산자

        //5. 소숫점 첫째자리에서 반올림하여 출력하시오.
        //출력예) 4.0
        System.out.println(Math.round(d));
        //Math.round() 첫째자리 반올림

        //1. 0.5을 더해준다.
        //2. (int)형변환연산자로 소수점을 날린다.
        //3. 결과적으로 반올림이 된다.
        //예) 3.49 => 3 +0.5 (int)3.99  => 3
        //    3.5 => 4  +0.5 (int)4.0 => 4
        //    3.99 => 4

        //6. 소숫점 둘째자리에서 반올림하여 출력하시오.
        //출력예) 3.6
        System.out.println(Math.round(d*10) / 10.0);
    }
}

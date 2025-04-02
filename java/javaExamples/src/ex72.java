public class ex72 {
    public static void main(String[] args) {
        //재귀함수로 팩토리얼(Factorial)을 구현해보자.
        //int n = 5;
        //5! = 5*4*3*2*1
        //형식 : int result = factorial( n )
        int n = 5;
        int result = factorial( n );
        System.out.println("result = " + result);

        //연습문제 1
        //1부터 N까지의 합계를 출력하시오.
        // int n = 5;
        // sum( n )을 호출하면, 5+4+3+2+1 까지의 합이 반환된다.
        System.out.println( sum(n) );

        //연습문제 2
        // 십진정수를 2진수로 변환하여 출력하시오.
        // printBin( int n )
        // printBin( 10 ) 호출시, 1010으로 출력됨.
        //   2 )  10
        //         5 - 0
        //         2 - 1
        //         1 - 0
        printBin( 10 );

        //연습문제 3
        // 문자열을 역으로 출력하기
        // 예) "abcde" => "edcba"
        System.out.println();
        reverseWord("abcde");
    }
    static int factorial(int n ){
        //탈출조건
        if( n == 1 ){
            System.out.println("n:1");
            return 1;
        }
        System.out.println("n:"+n);
        System.out.println("n-1:"+(n-1));
        return n * factorial(n - 1);
    }
    static int sum( int n ){
        if( n == 1 ) {
            System.out.println("n:1");
            return 1;
        }
        System.out.println( "n:"+n );
        System.out.println( "n-1:"+(n-1) );
        return n + sum( n - 1 );
    }
    static void printBin(int n){
        if( n < 2 ){
            System.out.print( n );
        }else{
            printBin( n / 2 );
            System.out.print( n % 2 );
        }
    }
    static void reverseWord(String str){
        if( str.length()==0 ){
            return;
        }
        else{
            //substring(인덱스) : 인덱스부터 마지막까지 문자열을 가져옴.
            //"abcde"
            //"bcde"
            //"cde"
            //"de"
            //"e"
            //""
            reverseWord(str.substring(1));
            //첫글자만 출력함.
            System.out.print(str.charAt(0));
        }
    }
}

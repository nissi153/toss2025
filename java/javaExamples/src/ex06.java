public class ex06 {
    public static void main(String[] args) {
        //연산자의 종류 - 이항연산자(산비논대)
        //단항 : ++ -- !(논리반전) (타입) ~(비트반전) 우선순위가 가장 높다
        //산술 : + - * / %     << >> >>>(비트단위 이동연산자)
        //비교 : < > <= >= == !=  instanceof(객체비교연산자)
        //논리 : && ||         & | ^(비트단위 논리연산자)
        //삼항 : ? :
        //대입 : = 복합대입(+= -= *= /= %= ...)      우선순위가 가장 낮다.

        //단항연산자 ++ -- !(논리반전)
        int i = 10;
        i++;
        System.out.println("i = " + i);
        i--;
        System.out.println("i = " + i);

        System.out.println( !true );

        int j = 20;
        short s = (short)j; //작은 타입 <= 큰 타입 : 강제형변환

        int k = 10;  //32bit 000000....1010
        int m = ~k;  //      111111....0101
        System.out.println( Integer.toBinaryString(k) );
        System.out.println( Integer.toBinaryString(m) );

        String binaryString = String.format("%32s", Integer.toBinaryString(k)).replace(" ","0");
        System.out.println(binaryString);
    }
}

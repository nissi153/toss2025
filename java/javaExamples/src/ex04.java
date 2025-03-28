public class ex04 {
    public static void main(String[] args) {
        //형변환 type casting
        //형변환 공식
        //1. 작은 정수형 -> 큰 정수형 (문제없음)
        //2. 큰 정수형 -> 작은 정수형 (표현범위 벗어나면 값잘림)
        //3. 실수형 -> 정수형(값잘림, 소숫점 날아감)
        //4. 정수형 -> 실수형(문제없음)

        //자동 형변환 : 대입(산술)연산자를 통해 자동으로 형변환 됨.
        //수동 형변환 : 형변환 연산자 (타입)을 통해 형변환 할때.
        
        //자동 형변환
        //1. 같은 타입끼리 연산될 때
        //  int * int => int
        //  long * long => long
        int i = 10 * 20;
        System.out.println("i = " + i);
        //2. 다른 타입끼리 연산될 때
        // int * long => long
        // long * float => float
        long l = 10 * 20L;
        //3. 작은 타입에서 큰 타입으로 대입될 때
        long a = 10;

        //수동(강제) 형변환
    }
}

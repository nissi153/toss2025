public class ex09 {
    public static void main(String[] args) {
        //삼항연산자 : ? : 물음표 연산자
        // 패턴 : (조건절) ? A값 : B값

        int i =  10 < 20 ? 10 : 20;
        System.out.println( i );

        //삼항연산자는 중복해서 쓰지 않기를 권장함.
        int j = (10<20) ? ((20<30) ? 20 : 30) : 40;
        System.out.println( j );

        //대입연산자
        // A = B  : B값을 A에 덮어쓰기 한다.
        // 값의 전달 방향이 오른쪽에서 왼쪽,
        // 단항연산자이므로 연산순서도 오른쪽에서 왼쪽으로
        int i2 = 10;
        int j2 = 20;
        int k2 = 30;
        i2 = j2 = k2 = 40;
        System.out.println( i2 );
        //복합대입연산자
        // A += B : A = A + B
        // A -= B : A = A - B
        // A *= B : A = A * B
        // A /= B : A = A / B
    }
}

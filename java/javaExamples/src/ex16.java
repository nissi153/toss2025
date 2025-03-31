public class ex16 {
    public static void main(String[] args) {
        //while do-while

        //패턴
        //for( 초기식; 조건식; 증감식 ){
        //   실행문;
        //}

        //초기식;
        //while( 조건식 ){
        //  실행문;
        //  증감문; //맨마지막
        //}
        int i = 0;
        while( i<5 ){
            System.out.println( i );
            i++;
        }

        i = 0;
        do {
            System.out.println( i );
            i++;
        } while ( i < 5);

        //* 적어도 한번은 실행후 조건 비교한다.
        //초기식
        //do {
        //  실행문;
        //  증감문;
        //} while( 조건식 );
    }
}

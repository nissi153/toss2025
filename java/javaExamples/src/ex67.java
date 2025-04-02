import java.util.LinkedList;
import java.util.List;

public class ex67 {
    public static void main(String[] args) {
        //LinkedList
        //   : ArrayList와 사용법은 비슷함.
        //   : 내부적으로 처리하는 방법이 다름.
        //   : 한 요소가 다음의 요소의 주소값을 가지는 구조를 가짐.
        //   : 흩어진 데이타를 접근할 때 빠르다.
        //   : 인터페이스 List구현체, Queue의 구현체
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add( 10 );
        nums.add( 20 );
        nums.add( 30 );
        System.out.println( nums );
        nums.add( 0, 40 );
        System.out.println( nums );

        //차별화된 함수들
        System.out.println( nums.getFirst() );
        System.out.println( nums.getLast() );
        //자료구조(알고리즘)에서 사용하는 함수들
        System.out.println( nums.peek() ); //처음 요소 반환
        System.out.println( nums );
        System.out.println( nums.poll() ); //처음 요소 반환 후 삭제
        System.out.println( nums );
        nums.push( 50 ); //맨 왼쪽(처음)으로 추가
        System.out.println( nums );
        System.out.println( nums.pop() ); //맨 왼쪽 요소를 지우면서
        //지운 값을 반환함.
        System.out.println( nums );
    }
}

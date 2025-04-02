import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ex66 {
    public static void main(String[] args) {
        //ArrayList 사용 예
        //ArrayList는 가변용량 - 넣은 만큼 추가됨.

        ArrayList<Integer> nums1 = new ArrayList<Integer>();//타입명시
        ArrayList<Integer> nums2 = new ArrayList<>(); //타입생략
        ArrayList<Integer> nums3 = new ArrayList<>(10);//10개 공간
        //다른 리스트로 초기화
        ArrayList<Integer> nums4 = new ArrayList<>( nums1 );
        //선언과 동시에 초기화
        ArrayList<Integer> nums5 = new ArrayList<>(
                Arrays.asList(10,20,30,40,50)
        );
        System.out.println( nums5 );

        //전체 리스트 순환
        //일반 for문
        for(int i=0; i<nums5.size(); i++){
            System.out.println( nums5.get( i ) );
        }
        //향상된 for문
        for( Integer num : nums5 ){
            System.out.println( num );
        }
        //이터레이터(Iterator) : 열거자
        //콜렉션(리스트,맵,셋)의 순차적인 처리를 도와주는 클래스
        // hasNext() : 다음 요소를 가지고 있는지 true/false로 반환.
        // next() : 다음 요소값을 반환함.(값을 반환하고 it카운터 ++)
        Iterator<Integer> it = nums5.iterator();
        while( it.hasNext() ) {
            System.out.println( it.next() );
        }
        // 10,20,30,40,50
        //값을 포함하는지 확인?
        if( nums5.contains( 30 ) ){
            System.out.println("30을 포함함.");
        }
        //특정 요소의 인덱스 알아오기
        System.out.println( nums5.indexOf(40) );
    }
}

import java.util.ArrayList;
import java.util.Collections;

public class ex65 {
    public static void main(String[] args) {
        //데이타를 담는 그릇 - 데이타구조
        //1.변수 : 단 하나의 값(숫자,문자열,논리)
        //2.배열 : 인덱스가 있는 연속된 공간에 담음.(타입과 길이 고정)
        //3.리스트 : 인덱스가 있는 연속된 공간
        //          추가/삭제/교체가 간편하다.
        //          제네릭(가변타입)이 가능.
        //4.맵 : Key-Value 형태의 데이타. 순서없음.
        //5.세트 : 집합구조의 데이타(중복없음). 순서없음.

        // 콜렉션 프레임워크 : List, Map, Set
        //1. 리스트(List)
        //   List 인터페이스를 구현해서 ArrayList(일반), LinkedList(알고리즘기반) 클래스
        //  ArrayList : 순차적으로 데이타가 나열되어 있다. 순차적인 데이타에 대한 접근속도가 빠름.
        //  LinkedList : 다음 요소의 주소값을 이전 요소가 가지고 있다. 흩어져있는 데이타에 대한 접근속도가 빠름.
        //2. 맵(Map)
        //   Map 인터페이스를 구현해서 HashMap클래스 사용
        //3. 집합(Set)
        //   Set 인터페이스를 구현해서 HashSet클래스 사용
        //해쉬(HashCode) : 내부데이타간의 연결을 위한 유일한 키(정수)

        //ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println( fruits );//[]
        //아이템을 뒤로 추가 add()
        fruits.add("수박");
        System.out.println( fruits );
        fruits.add("망고");
        System.out.println( fruits );
        fruits.add("딸기");
        System.out.println( fruits );

        //맨앞에 추가
        fruits.add(0, "레몬");
        System.out.println( fruits );
        //중간에 추가
        fruits.add(1, "사과");
        System.out.println( fruits );
        //삭제
        fruits.remove( 1 );
        System.out.println( fruits );
        //오름차순 정렬
        Collections.sort( fruits );
        System.out.println( fruits );
        //내림차순 정렬
        Collections.sort( fruits, Collections.reverseOrder());
        System.out.println( fruits );
        //리스트 길이
        System.out.println( fruits.size() );
        //데이타 변경/치환
        fruits.set( 1, "복숭아");
        System.out.println( fruits );
        //전체 지우기
        fruits.clear();
        System.out.println( fruits );
    }
}

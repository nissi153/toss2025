import java.util.*;

public class ex69 {
    public static void main(String[] args) {
        //맵(Map) : 키와 값으로 된 데이타 구조
        //        : Key(문자열형) - Value(객체,기본데이타형)
        //        : JSON, XML 데이타와 연결
        //        : 인덱스나 순서 없음.
        //Hash : 해쉬테이블을 이용한 Map데이타구조를 구현한 구현클래스
        //Hash Table : 데이타를 빨리 검색하기 위한 데이타구조
        Map<String, String> map = new HashMap<>();
        map.put("username", "hong"); //아이디
        map.put("password", "1234"); //비밀번호
        System.out.println( map );
        //Map(key-value)객체 = {  }로 표현
        //List객체 = [ ]로 표현

        System.out.println( map.get("username") );
        System.out.println( map.get("password") );

        //전체 순환
        //일반for문 안됨 - 인덱스없음

        //향상된 for문
        //Set타입으로 키 문자열들을 받아옴.
        Set<String> keys = map.keySet();
        for( String key : keys ){
            System.out.println( map.get(key) );
        }
        //이터레이터를 이용
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println( map.get(key) );
        }
    }
}

import java.util.Optional;

public class ex64 {
    public static void main(String[] args) {
        //Optional 클래스
        //   : JDK 1.8부터 지원
        //   : 널값 체크을 위해 사용
        //   : NullPointException 발생 빈도를 줄여주고자 만들어짐.
        String nullValue = null;
        //System.out.println( nullValue.toLowerCase() ); //NullPointException 발생!

        //기존의 널체크 방법
        if( nullValue != null ){
            System.out.println( nullValue.toLowerCase() );
        }

        //ofNullable 함수 : 널값일 수 있는 값을 입력한다.
        Optional optional1 = Optional.ofNullable( nullValue );
        //널인지 아닌지 true/false로 반환
        System.out.println( optional1.isPresent() );
        //값이 비어있는지 true/false로 반환
        System.out.println( optional1.isEmpty() );
        if( optional1.isPresent() ){
            System.out.println( optional1.get() );
        }

        String normalValue = "abc";
        Optional optional2 = Optional.ofNullable( normalValue );
        System.out.println( optional2.isPresent() );
        if( optional2.isPresent() ){
            System.out.println( optional2.get() );
        }

        //of() 함수 : 절대 null이 아닌 값으로 초기화할 때
        Optional optional3 = Optional.of( normalValue );
        System.out.println( optional3.isPresent() );
        if( optional3.isPresent() ){
            System.out.println( optional3.get() );
        }

        //orElse() 함수 : null경우 대체 값을 설정한다.
        String strResult = Optional.ofNullable(nullValue)
                .orElse("Null이군요.");
        System.out.println( strResult );

        //filter() 함수
        //  : 람다식이 true이면 Optional객체값이 그대로 전달되고,
        //    false이면, orElse에 정의된 값이 전달된다.
        String strResult2 = Optional.ofNullable(normalValue)
                .filter(/*람다식-코드뭉치*/ (val) -> val.contains("abc123"))
                .orElse("abc값 없네요.");
        System.out.println( strResult2 );

        //map() 함수
        // String::toUpperCase : 람다식의 간결한 표현
        String strResult3 = Optional.ofNullable(normalValue)
                .map(String::toUpperCase)
                .orElse("대문자로 변환이 실패하였습니다.");
        System.out.println( strResult3 );
    }
}

import java.util.Arrays;

public class ex05 {
    public static void main(String[] args) {
        //문자열 관련 함수들
        String str1 = "Hello Java!";
        String str2 = "안녕하세요! 반갑습니다.";
        //문자열 길이
        System.out.println( str1.length() );
        System.out.println( str2.length() );
        System.out.println();
        //문자 한자만 가져오기
        char c1 = str1.charAt( 0 ); //0은 맨 첫문자를 가져옴.
        System.out.println( c1 );
        char c2 = str1.charAt( 1 ); //1은 두번째 문자
        System.out.println( c2 );
        //문자열 위치(인덱스) 가져오기
        System.out.println( str1.indexOf("Java") );
        //마지막 문자(열)의 위치 가져오기
        //"Hello Java!"
        System.out.println( str1.lastIndexOf("a") );

        String str3 = "Java Study";
        //대문자로 바꾸기
        System.out.println( str3.toUpperCase() );
        //소문자로 바꾸기
        System.out.println( str3.toLowerCase() );
        //문자열로 검색시 다 소문자로 바꿔서 검색한다.
        System.out.println( str3.toLowerCase().indexOf("java") );
        //문자열 치환하기
        System.out.println( str3.replace("Study", "공부") );
        //문자열 일부 가져오기           시작인덱스 끝인덱스
        System.out.println( str3.substring(0, 4) );
        //문자열을 분리해서 문자열 배열로 가져오기
        String[] strArray = "abc/def-ghi jkl".split("/|-| ");
        System.out.println( strArray.length );
        //Arrays.toString() : 배열을 문자열로 변환해주는 함수
        System.out.println( strArray );
        System.out.println(Arrays.toString(strArray));
        //문자열의 처음과 끝의 공백만 제거 - 가운데 공백은 안함
        System.out.println(" abc ".trim());
        System.out.println(" abc def ".trim());
        //모든 공백을 제거하기
        System.out.println(" abc def ".replaceAll(" ",""));
        //문자열 연결 함수
        System.out.println("abc".concat("123"));
        //문자열을 포함하는지 true/false로 반환하는 함수
        System.out.println("abc123".contains("123"));

        //문자열 내용 비교하기
        String str4 = "Java";
        String str5 = "java";
        //주소값 정수 비교
        System.out.println( str4 == str5 );
        //내용 비교
        System.out.println( str4.equals( str4 ) );
        //대부분의 언어들은 문자열 비교시 ==
        //단 자바는 equals함수를 사용해야 됨.
    }
}

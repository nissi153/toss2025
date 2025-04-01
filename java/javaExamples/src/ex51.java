public class ex51 {
    public static void main(String[] args) {
        //기본 API 클래스들
        //패키지명은 java.lang.*  java.util.*

        //패키지는 폴더이다. 클래스명이 중복되는 경우에 클래스명으로 구분.
        //  인천.인수동.김길동  서울.중림동.김길동

        //JDK 온라인 문서 : 영어
        //https://docs.oracle.com/en/java/javase/17/

//API : Application Programming Interface, 함수/클래스/통신 호출의 접점.
//SDK : Softwear Development Kit, 소프트웨어 개발 툴 모음
//라이브러리 : Library 도서관. 함수나 클래스들의 모임.
//프레임워크 : Framework 뼈대. 어떤 소프트웨어를 만드는데 사용하는 근간. 모듈.
//콜렉션 : Collection. SW 모음.
//JDK : Java Development Kit. Java + SDK
//DLL : 동적 링크 라이브러리(dynamic-link library). 함수 및 클래스모임.
//JAR : Java Archive, 자바 아카이브. .class파일과 리소스(이미지,텍스트),
//      메타파일을 모아둔 것. 실행가능한 압축파일. 타임리프/스프링부트
//WAR : JAR와 유사한 자바 압축 파일, Web관련 환경설정이 추가된 것.
//      JSP/스프링 레거시

// 프레임워크 > 라이브러리 > 콜렉션 > SDK > API

        //자바의 최상위 클래스 : 모든 클래스가 상속받는 클래스
        // Object 클래스
        //    : 다형성을 이용하여 모든 클래스 객체를 전달할 수 있다.
        Object object1 = new Object();
        Object object2 = new Object();

        //해쉬코드 : 객체생성시 자동부여되는 ID값
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        //equals()
        System.out.println( object1.equals( object2 ) );

        //toString()
        System.out.println( object1.toString() );

    }
}

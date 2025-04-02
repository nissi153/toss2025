import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ex62 {
    public static void main(String[] args) {
        //장소 : 행정주소(서울시 중구 충정로), GPS(위도,경도)
        //       구글 행정주소 API

        //날짜와 시간 클래스
        // 1. Date : 약한 수준의 기능 제공
        // 2. Calendar : 높은 수준의 기능 제공
        //             : 내부적으로 달력을 가지고 있음.
        //             (윤년, 1년 12달 356일의 데이타를 포함)
        // 윤년 : 4년마다 2월의 하루를 증가시킨다.
        //     : 지구의 공전주기 약 365.2422일

        //양력 달력 : 그레고리안 달력
        //한국시간 = 국제표준시(GMT) + 9시간
        //국제표준시(GMT) : 영국 그리니치천문대 0시
        //한국표준시(KST) : GMT + 9시간
        Calendar cal = new GregorianCalendar(Locale.KOREA);
        //캘린더에서 Date 객체 가져오기
        System.out.println( cal.getTime() );
        //타임스탬프 정수값 출력 : 1970-01-01부터 증가하는 정수값
        System.out.println( cal.getTimeInMillis() );

        //년도
        // Calendar.YEAR : static final 상수
        int year = cal.get(Calendar.YEAR);
        System.out.println( year );
        //달 : 1월은 0이다. 2월 1이다. 주의!!
        int month = cal.get(Calendar.MONTH);
        System.out.println( (month + 1)+"월" );
        //일
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println( dayOfMonth );
        //요일
        //1 일요일, 2 월, 3 화, 4 수, 5 목, 6 금, 7 토
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println( dayOfWeek );
        //올해의 몇주차인가?
        int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println( weekOfYear );
        //이달의 몇주차인가?
        int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);
        System.out.println( weekOfMonth );
        //시 : 12시간제
        int hour = cal.get(Calendar.HOUR);
        //시 : 24시간제
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millisecond = cal.get(Calendar.MILLISECOND);
        System.out.println( hour );
        System.out.println( hourOfDay );
        System.out.println( minute );
        System.out.println( second );
        System.out.println( millisecond );

        //전후 시간 구하기
        // 예) 1년후 무료회원 마감일 구하기
        // 10시간 후
        cal.add( Calendar.HOUR, 10 );
        echoTime( cal );
        // 10시간 전
        cal.add( Calendar.HOUR, -10 );
        echoTime( cal );
        // 한달 후
        cal.add( Calendar.MONTH, 1 );
        echoTime( cal );
        // 일년 후
        cal.add( Calendar.YEAR, 1 );
        echoTime( cal );
    }//main

    static void echoTime( Calendar cal ) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format( cal.getTime() );
        System.out.println( strTime );
    }

}//class

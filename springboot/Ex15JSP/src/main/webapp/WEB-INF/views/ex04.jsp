<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<%@ page import="java.util.Date" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- 페이지 지시어 --%>
<%-- <%@ %> --%>
<%-- contentType: 기본값(text/html) --%>
<%--            : JSP문서의 MIME(ContentType) 타입과 문자 인코딩 타입 지정 --%>
<%--            : MIME(Multipurpose Internet Mail Extension) --%>
<%--            : 메일 동봉시 문서의 종류 지정 -> 통신문서 타입지정 --%>
<%--            :   ContentType : text/html, Application/xml, Application/json --%>
<%--            :   Application/x-www-form-urlencode, text/plain, text/xml --%>
<%--            :   multipart/formed-data(파일) --%>
<%--            : charset: UTF-8(유니코드), iso-8859-1(기본값,MS윈도우즈 한글, EUC-KR의 확장판) --%>
<%--                EUC-KR(완성형한글), ASCII(영문)     --%>
<%-- import : 기본값(없음) --%>
<%--        : 자바 클래스 임포트 --%>
<%-- session : 기본값(true) --%>
<%--         : 세션 사용 여부 --%>
<%-- buffer : 기본값(8kb) --%>
<%--        : 출력버퍼(Memory)의 크기 지정 --%>
<%-- autoFlush : 기본값(true) --%>
<%--           : 출력버퍼가 다 찼을 경우 자동으로 내보낼지 결정 --%>
<%-- info : JSP 페이지에 대한 설명 기술 --%>
<%-- errorPage : JSP 페이지 실행중 에러발생시 보여줄 페이지 기술(error.jsp) --%>
<%-- isErrorPage : 기본값(false)
                    현재 페이지가 에러 페이지 여부인지 지정 --%>
<%-- pageEncoding : JSP 페이지 소스 코드의 문자 인코딩을 지정함 --%>
<%-- charset과 pageEncoding의 차이점 --%>
<%-- charset은 서버가 웹브라우저에게 보내는 문자 인코딩 타입(통신) --%>
<%-- pageEncoding은 소스 코드 자체의 문자 인코딩 타입(파일) --%>

<%-- isELIgnored : 기본값(false) --%>
<%--             : 표현언어(Expression Language)의 사용 여부 --%>
<%--             : 출력문의 형식(표현식:간략한 표현) --%>

<%-- deferredSyntaxAllowedAsLiteral: 기본값(false) --%>
<%--                               : #{} 문자가 문자열 값으로 사용될지 여부 --%>

<%-- trimDirectiveWhitespaces : 기본값(false) --%>
<%--                          : 출력결과에서 공백문자를 제거할지 여부 --%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex04.jsp</title>
  </head>
  <body>
       <%
            Date now = new Date();
       %>
       현재시간 : <%= now %>
  </body>
</html>

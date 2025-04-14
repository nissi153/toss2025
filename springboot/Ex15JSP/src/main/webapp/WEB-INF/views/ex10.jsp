<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex10.jsp</title>
  </head>
  <body>
    <!-- JSTL(자바 서버 페이지 표준 태그 라이브러리) -->
    <!-- HTML처럼 표현식을 간단히 출력하기 위해 만듦. -->
    <!-- JSTL + EL 형태로 표현식을 간편하게 하기 위해 사용 -->

    <!-- 표현식을 간단하게 EL로 표현 -->
    <!-- < % = student % >    $ { student } -->
    <!-- 표현식을 간단하게 JSTL로 표현  -->
    <!-- < % if  % >  < c : if > -->
    <!-- < % for  % >  < c : for > -->

    <!-- JSTL core 태그들 -->
    <!--
        < c :set> : 변수 선언
        < c :out> : 출력
        < c :if> : 조건문
        < c :choose> : switch문과 유사
        < c :when> : case문과 유사
        < c :otherwise> : defalut문과 유사
        < c :forEach> for문(향상된)
     -->
     JSP 스크립트릿의 변수 선언<br>
     <% String name1 = "홍길동"; %>
     name1 : <%= name1 %> <br><br>

     JSTL에서 변수 선언<br>
     <c:set var="name2" value="변사또" />
     name2 : ${ name2 } <br><br>

     JSTL에서 변수 제거<br>
     <c:remove var="name2" scope="page" />
     name2 : ${ name2 } <br><br>

  </body>
</html>

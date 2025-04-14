<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex02.jsp</title>
  </head>
  <body>
    <!-- XML 타입의 주석문 -->
    <%-- JSP 타입의 주석문 --%>

    <!-- JSP란?  -->
    <!-- JSP( Java Server Page )로서 제작사는 썬마이크로시스템즈이다. -->
    <!-- 지금 오라클에 인수합병되었음. -->

    <!--  과거 3대 서버 동적 페이지 프로그램 -->
    <!-- 1. PHP : 중소형 회사에서 주로 사용  -->
    <!-- 2. JSP : 중대형 회사에서 주로 사용하나 
                요즘은 다른 서버프론트템플릿들이 사용되기 시작함.
    -->
    <!-- 3. ASP : 중소형 회사에서 주로 사용, MS사 제품으로
                윈도우즈 서버에서만 지원(SQL-SERVER DB)해서 비용문제발생.
    -->

    <!-- JSP : 서버사이드 뷰템플릿 엔진 -->
    <!-- HTML안에 Java코드나 EL, JSTL를 사용하여 동적인 페이지를 구성  -->
    <!-- 하는 SW이다. -->

    <!-- JAJA코드를 넣을 수 있다. -->
    현재시간 : <%= new java.util.Date() %> <br />
    <button onclick="window.location.reload();">새로고침</button>
  </body>
</html>

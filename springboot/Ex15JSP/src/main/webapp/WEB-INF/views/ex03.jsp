<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex03.jsp</title>
  </head>
  <body>
    <%-- 페이지 지시어 <%@ %> --%>
    <%-- 출력문(표현식) <%= %> --%>
    <%-- 전역변수,함수 선언부 <%! %> --%>
    <%-- 자바코드(스크립트릿) <%  %>  --%>
    <%!
      int globalVar = 10;
      public int sum(int x, int y) {
        return x + y;
      }
    %>
    <%
      //스크립트릿 : JSP안의 java 코드
      String title = "java coding";
      System.out.println( title );
    %>
    <!-- 표현식 -->
    전역변수 : <%= globalVar %> <br>
    타이틀 문자열 : <%= title %> <br>
    합계 함수 : <%= sum(10, 20) %>

  </body>
</html>

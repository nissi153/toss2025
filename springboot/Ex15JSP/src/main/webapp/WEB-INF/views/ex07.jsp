<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex07.jsp</title>
  </head>
  <body>
    <!-- JSP 페이지 간의 데이터 전달 -->
    <!-- 1. application 객체 -->
    <!-- 2. pageContext 객체 -->
    <!-- 3. request 객체:servlet객체, Model객체: 스프링MVC객체 -->
    <!-- 4. response 객체 -->
    <!-- 5. session 객체 -->
    <!-- 6. input type=hidden submit -->
    <!-- 7. jsp:forward jsp:param -->
    <!-- 8. c:redirect c:param -->
    <!-- 9. GET 주소줄 -->
    <!-- 10. POST body -->

    <!-- 내장객체의 수명주기 -->
    <!-- pageContext < request < session < application -->
    <!-- 한페이지      단일요청  로그아웃전  웹브라우저 닫을 때까지 -->

    <!-- JSP 액션태그 -->
    <jsp:forward page="ex08.jsp">
        <jsp:param name="id" value="hong" />
        <jsp:param name="pw" value="1234" />
    </jsp:forward>

  </body>
</html>

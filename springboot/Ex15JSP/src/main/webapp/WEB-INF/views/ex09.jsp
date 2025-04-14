<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean
    id="users" scope="request"
    class="com.study.springboot.Users"
/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex09.jsp</title>
  </head>
  <body>
      EL(Expression Language) 표현언어 <br>
      Apache Tomcat/10.1.39 <br>
      Servlet 6.0 <br>
      JSP(Jakarta Pages) 3.1 <br>
      EL 5.0 <br>
      WebSocket 2.1 <br>
      Java 최소버전  11버전 <br>

      <!-- JSP표현식(값 출력)이 복잡하기 때문에 쉽게 사용하려고 -->
      <!-- 나온 것이 EL이다. -->

      <!-- 서버단 JSP를 번역할 때의 순서 -->
      <!-- java빈 -> EL/JSTL -> java코드(스크립트릿) -> HTML/CSS/JS -->

      <!-- 클라단에서 HTML이 번역되는 순서 -->
      <!-- HTML/CSS -> JS -->

      <!-- 스크립트릿 -->
      <% users.setUserName("임꺽정");  %>
      <!-- 표현식 -->
      <%= users.getUserName() %> <br>
      <!-- EL -->
      ${ users.getUserName() } <br>

      <!-- 표현식 : 반복문 -->
      <%
         for(int i=0; i<5; i++) {
      %>
            i: <%= i %> <br>
      <%
         }
      %>

      <!-- EL : 반복문 -->
      <!-- EL에서는 스크립트릿 변수를 바로 접근해서 출력할 수 없다.
      <!-- JSTL을 사용해서 EL을 출력한다. -->
      <%
        for(int i=0; i<5; i++){
      %>
          i: ${ i } <br>
      <%
        }
      %>

  </body>
</html>

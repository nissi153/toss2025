<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ex11.jsp</title>
  </head>
  <body>
    EL(JSTL)에서 스크립트릿 변수에 접근 <br>
    <% String name = "김진사"; %>
    <c:set var="nameEL" value="<%= name %>" />
    nameEL : ${ nameEL } <br>

    스크립트릿에서 JSTL/EL변수에 접근<br>
    <c:set var="nameEL2" value="홍두깨" />
    <%
        String nameScriptlet =
          (String)pageContext.getAttribute("nameEL2");
        out.append("nameEL2 : " + nameScriptlet);
        //document.writeln()
    %>
    <br><br>

    JS에서 JSTL변수에 접근<br>
    <c:set var="nameEL3" value="사임당" />
    <script>
        window.onload = function(){
            var nameJS = '<c:out value="${ nameEL3 }"/>';
            document.body.append(nameJS);
        }
    </script>

    JSTL에서 JS변수에 접근 불가<br>
    <!-- JS변수는 JSTL의 EL구문에서 사용할 수 없다. -->
    <!-- input hidden/GET param 같은 곳에 데이터를 내려준다.  -->

  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex13 JSTL if문 choose문</title>
</head>
<body>
    <c:if test="true">
        항상 true<br>
    </c:if>
    <c:if test="some text...">
        항상 false<br>
    </c:if>
    <c:if test="${ 10 < 20 }">
        10은 20보다 작다<br>
    </c:if>

    <c:set var="name" value="홍길동" />
    <c:if test="${ name eq '홍길동' }">
        name은 홍길동이다.<br>
    </c:if>

    <!-- if else구문은 없다. choose문을 사용 -->
    <c:set var="grade" value="골드회원" />
    <c:choose>
        <c:when test="${ grade eq '우수회원'}">
            회원등급은 우수회원입니다.<br>
        </c:when>
        <c:when test="${ grade eq '골드회원'}">
            회원등급은 골드회원입니다.<br>
        </c:when>
        <c:when test="${ grade eq '일반회원'}">
            회원등급은 일반회원입니다.<br>
        </c:when>
        <c:otherwise>
            그외의 회원등급이니다.<br>
        </c:otherwise>
    </c:choose>

</body>
</html>
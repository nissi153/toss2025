<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex14 JSTL forEach문</title>
</head>
<body>
    forEach태그 사용: 리스트 출력시<br>
    <c:forEach var="i" begin="0" end="4" step="1">
        i : ${ i } <br>
    </c:forEach>
    <br>
    배열을 출력해보자.<br>
    <c:set var="intArray" value="<%= new int[]{10,20,30} %>" />
    <c:forEach var="intValue" items="${ intArray }">
        intValue : ${ intValue } <br>
    </c:forEach>

    <!-- varStatus 사용 -->
	<!--
	- status.index : 0부터 시작하는 루프의 인덱스.
	- status.count : 현재 몇번째 루프인지 값입니다. 1부터 시작합니다.
	- status.current : 현재 아이템입니다. var 속성의 값과 같습니다.
	- status.first : 현재가 첫번째 루프이면 참입니다.
	- status.last : 현재가 마지막 루프이면 참입니다.
	- status.begin : begin  속성을 사용했을 경우 그 값이 나옵니다.
	- status.end : end 속성을 사용했을 경우 그 값이 나옵니다.
	- status.step :  step 속성을 사용했을 경우 그 값이 나옵니다.
	-->
    <br>
    <c:forEach var="value" items="${ intArray }" varStatus="status">
        value : ${ value }<br>
        index : ${ status.index }<br>
        count : ${ status.count }<br>
        current : ${ status.current }<br>
    </c:forEach>

    <br><br>
    자바의 map데이타를 출력해보자<br>
    <%
        java.util.Map<String, Object> map =
            new java.util.HashMap<>();
        map.put("name", "홍길동");
        map.put("now", new java.util.Date());
    %>
    <br>
    <c:set var="mapData" value="<%= map %>"/>
    <c:forEach var="mapKV" items="${ mapData }" >
        ${ mapKV.key } = ${ mapKV.value }<br>
    </c:forEach>

    <!-- 연습문제 -->
	<!--
		1. forEach를 이용하여 1부터 100까지의 합을 구하시오.
		2. 구구단 7단을 출력하시오.
		3. 1부터 100사이의 2의 배수이면서 5의 배수인 수만 출력하시오.
		JSTL/EL로 출력하시오.
	-->
	<c:set var="sum" value="0" scope="page" />
    <c:forEach var="i" begin="0" end="100" step="1">
        <c:set var="sum" value="${sum + i}" />
    </c:forEach>
    <p>결과 : ${sum}</p>
    <br>
    <c:forEach var="i" begin="1" end="9" step="1" > <br>
       7 x ${i} = ${ i*7 }
    </c:forEach>

    <c:forEach var="i" begin="1" end="100" step="1">
       <c:if test="${i%2 == 0 && i%5 == 0}" > <br>
           i : ${i}
       </c:if>
   </c:forEach>

</body>
</html>
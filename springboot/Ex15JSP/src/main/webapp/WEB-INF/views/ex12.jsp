<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ex12 EL의 연산자</title>
</head>
<body>
      <!--
		수치연산자 : +, -, *, / or div, % or mod, 단항연산자 -부호
		           : ++,--연산자 지원안함.
		비교연산자 : == or eq, != or ne, < or lt, > or gt,
		             <= or le, >= or ge
		논리연산자 : && or and, || or or, ! or not
		empty 연산자 : empty <값>
		               null이면, true
		               빈 문자열이면, true
		               길이가 0인 배열, true
		               빈 Map이면, true
		               빈 Collection이면, true
		               그외의 값은 false
		삼항 연산자 : ? 연산자
	  -->
      ${ 10 + 1 } <br>
      ${ 10 /3 } <br>
      ${ 20 == 20 } <br>
      ${ "hong" == "hong" } <br>
      ${ 10 < 20 } <br>
      ${ 10 lt 20 } <br>
      ${ empty( null ) } <br>
      ${ empty( "홍길동" ) } <br>
      ${ 10 eq 20 ? "참" : "거짓" } <br>

      <br>
      문자열연결 += 연산자<br>
      +연산자는 안됨<br>
      ${ "대한민국" += "만세" } <br><br>

      <br>
      세미콜론 연산자 ; <br>
      두개의 식을 붙일때, 앞의 식은 무시되고, 뒤의 식이 출력됨.<br>
      ${ 1 + 1; 10 + 10 } <br>

      <br>
      특수문자 출력하고 싶은때<br>
      <!-- JSP에서 "${ 10 }"로 출력하고 싶을 때 -->
      \${ 10 } <br><br>

      표현언어에서 $와 #의 차이점<br>
      $ {  } : 미리 컴파일하고 실행 <br>
      # {  } : 참조시(읽을 때) 컴파일하고 실행<br>

</body>
</html>
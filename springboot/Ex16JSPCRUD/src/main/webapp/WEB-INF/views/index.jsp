<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원목록 조회</title>
  </head>
  <body>
    <h2>회원 목록(총: ${ listcount }명)</h2>

    <table border="1">
      <thead>
        <tr align="center">
          <td>일련번호</td>
          <td>ID</td>
          <td>아이디</td>
          <td>비번</td>
          <td>이름</td>
          <td>권한</td>
          <td>가입일</td>
          <td>단건조회</td>
          <td>삭제</td>
        </tr>
      </thead>

      <tbody>
        <c:forEach var="member" items="${ list }" varStatus="status">
            <tr align="center">
              <td><span>${status.count}</span></td>
              <td><span>${member.id}</span></td>
              <td><span>${member.userId}</span></td>
              <td><span>${member.userPw}</span></td>
              <td><span>${member.userName}</span></td>
              <td><span>${member.userRole}</span></td>
              <td><span>${member.joinDate}</span></td>
              <td>
                <!-- onclick="location.href='viewMember?id=3'" -->
                <button
                  type="button"
                  onclick="location.href='viewMember?id=${member.id}';"
                >
                  단건조회
                </button>
              </td>
              <td>
                <!-- onclick="location.href='/deleteMember?id=5'" -->
                <button
                  type="button"
                  onclick="location.href='deleteMember?id=${member.id}';"
                >
                  삭제
                </button>
              </td>
            </tr>
        </c:forEach>
      </tbody>
    </table>

    <br /><br />
    <button type="button" onclick="location.href='/joinForm'">
      회원가입폼으로 이동
    </button>
  </body>
</html>

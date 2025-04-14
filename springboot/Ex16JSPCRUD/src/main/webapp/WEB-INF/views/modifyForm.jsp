<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원정보 보기/수정</title>
    <script>
      function checkValue() {
        if (!document.userInfo.userId.value) {
          //empty, null, 길이0 체크
          alert("이름을 입력하세요.");
          document.getElementById("userId").focus();
          return false; //form태그의 submit통신이 막힘.
        }
        if (!document.userInfo.userPw.value) {
          //empty, null, 길이0 체크
          alert("암호를 입력하세요.");
          document.getElementById("userPw").focus();
          return false; //form태그의 submit통신이 막힘.
        }
        if (!document.userInfo.userRole.value) {
          //empty, null, 길이0 체크
          alert("권한을 입력하세요.");
          document.getElementById("userRole").focus();
          return false; //form태그의 submit통신이 막힘.
        }

        return true; //form태그의 submit통신이 이루어짐.
      }
    </script>
  </head>
  <body>
    <h2>회원정보 보기/수정</h2>
    <form
      action="modifyAction"
      method="post"
      name="userInfo"
      onsubmit="return checkValue();"
    >
      <input type="hidden" value="${member.id}" name="id" id="id" />
      <table border="1">
        <tr>
          <td>아이디</td>
          <td>
            <input
              value="${member.userId}"
              type="text"
              name="userId"
              id="userId"
              maxlength="20"
            />
          </td>
        </tr>
        <tr>
          <td>비번</td>
          <td>
            <input
              value="${member.userPw}"
              type="password"
              name="userPw"
              id="userPw"
              maxlength="20"
            />
          </td>
        </tr>
        <tr>
          <td>이름</td>
          <td>
            <input
              value="${member.userName}"
              type="text"
              name="userName"
              id="userName"
              maxlength="50"
            />
          </td>
        </tr>
        <tr>
          <td>가입일자</td>
          <td>
            <input
              value="${member.joinDate}"
              type="date"
              name="joinDate"
              id="joinDate"
            />
          </td>
        </tr>
        <tr>
          <td>권한</td>
          <td>
            <label for="userRole">권한을 선택해주세요.</label>
            <select name="userRole">
              <option
                value="ROLE_USER"
                <c:if test="${member.userRole eq 'ROLE_USER'}">selected</c:if>
              >
                일반회원
              </option>
              <option
                value="ROLE_ADMIN"
                <c:if test="${member.userRole eq 'ROLE_ADMIN'}">selected</c:if>
              >
                관리자
              </option>
            </select>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <button type="submit">회원정보수정</button>
            <button type="submit" formaction="/">회원목록</button>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>

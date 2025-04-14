<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입 화면</title>
    <script>
      function checkValue() {
        if (!document.joinForm.userId.value) {
          alert("아이디을 입력하세요.");
          document.joinForm.userId.focus();
          return false; //submit 취소!
        }
        if (!document.joinForm.userPw.value) {
          alert("암호를 입력하세요.");
          document.joinForm.userPw.focus();
          return false; //submit 취소!
        }
        if (!document.joinForm.userRole.value) {
          alert("권한을 입력하세요.");
          document.joinForm.userRole.focus();
          return false; //submit 취소!
        }

        return true; //서버 통신 시작!
      }
    </script>
  </head>
  <body>
    <h2>회원가입 화면</h2>

    <form
      action="joinAction"
      method="post"
      name="joinForm"
      onsubmit="return checkValue();"
    >
      <table border="1">
        <tr>
          <td>아이디</td>
          <td>
            <input type="text" name="userId" id="userId" maxlength="20" />
          </td>
        </tr>
        <tr>
          <td>비번</td>
          <td>
            <input type="text" name="userPw" id="userPw" maxlength="20" />
          </td>
        </tr>
        <tr>
          <td>이름</td>
          <td>
            <input type="text" name="userName" id="userName" maxlength="50" />
          </td>
        </tr>
        <tr>
          <td>가입일자</td>
          <td>
            <input type="text" name="joinDate" id="joinDate" />
          </td>
        </tr>
        <tr>
          <td>권한</td>
          <td>
            <label for="userRole">권한을 선택하세요.</label>
            <select name="userRole">
              <option value="ROLE_USER" selected>일반회원</option>
              <option value="ROLE_ADMIN">관리자</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>주소</td>
          <td>
            <input type="text" name="userAddress" id="userAddress" maxlength="100" />
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <button type="submit">회원가입</button>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>

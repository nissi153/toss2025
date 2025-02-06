// ConditionalRender.jsx
// 조건부 렌더링
// 특정 조건에 따라 컴포넌트나 엘리먼트를 화면에 렌더링하는 기법입니다.
// 자바스크립트의 조건문(예: if-else, 삼항 연산자, 논리 연산자(AND) 등)을 활용하여
// 동적으로 UI를 제어할 수 있습니다.

//조건부 렌더링 방법
//1. if문 사용
//2. 삼항 연산자 (? :) 사용
//3. 논리 연산자 (&&, ||) 사용

import React, { useState } from "react";

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;

  //1. if문 사용
  if (isLoggedIn == "true") {
    return <h3>환영합니다!</h3>;
  } else {
    return <h3>로그인이 필요합니다.</h3>;
  }
}

export function Conditional1(props) {
  return <Greeting isLoggedIn={props.isLoggedIn} />;
}

const styles = {
  wrapper: {
    padding: 16,
    display: "flex",
    flexDirection: "row",
    borderBottom: "1px solid grey",
  },
  greeting: {
    marginRight: 8,
    color: "green",
  },
};

function Toolbar(props) {
  const { isLoggedIn, onClickLogin, onClickLogout } = props;

  return (
    <div style={styles.wrapper}>
      {/* 2. 논리 연산자 && 사용 */}
      {isLoggedIn && <span style={styles.greeting}>환영합니다.</span>}

      {/* 3. 삼항 연산자 사용 */}
      {isLoggedIn ? (
        <button onClick={onClickLogout}>로그아웃</button>
      ) : (
        <button onClick={onClickLogin}>로그인</button>
      )}
    </div>
  );
}

export function LandingPage() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const onClickLogin = () => {
    setIsLoggedIn(true);
  };
  const onClickLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div>
      <Toolbar
        isLoggedIn={isLoggedIn}
        onClickLogin={onClickLogin}
        onClickLogout={onClickLogout}
      />
      <div style={{ padding: 16 }}>랜딩 페이지에 오신 것을 환영합니다.</div>
    </div>
  );
}

//자바스크립트의 Truthy 값
// 자바스크립트에서 Truthy란 불리언 값으로 변환했을 때 true로 평가되는 값을 의미합니다.

// Falsy 값 목록
// 다음 값들은 falsy입니다.
// 이 값들은 if 문이나 조건부 연산에서 거짓(false)으로 평가됩니다:
// false          // boolean false
// 0              // 숫자 0
// -0             // 음수 0
// 0n             // BigInt 0
// ""             // 빈 문자열
// null           // null 값
// undefined      // undefined 값
// NaN            // 숫자가 아님 (Not-a-Number)
// * 위에 나열된 값 외에는 모두 truthy로 간주됩니다.

// Truthy 값의 예
// 다음과 같은 값들은 truthy로 평가됩니다:

// "문자열"          // 비어있지 않은 문자열
// 42                // 0이 아닌 숫자
// -1                // 음수도 truthy
// 3.14              // 소수도 truthy
// []                // 빈 배열도 truthy
// {}                // 빈 객체도 truthy
// function() {}     // 함수도 truthy
// new Date()        // Date 객체
// "false"           // 문자열 "false" (불리언 false와는 다름)

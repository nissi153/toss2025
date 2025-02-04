// JSX란?
// JSX는 JavaScript XML의 약자로, React에서 UI를 정의하기 위해 사용되는 문법입니다.
// JSX는 HTML과 비슷해 보이지만 JavaScript 코드 안에서 작성되며 컴파일러에 의해
// 순수한 JavaScript로 변환됩니다.
// React 컴포넌트는 JSX로 UI 구조를 선언하고 이를 렌더링할 수 있습니다.
// 예를 들어, JSX를 사용하면 HTML 구조를 정의하는 것처럼 React 컴포넌트를 정의할 수 있습니다.

// 1. JSX의 주요 특징
// HTML과 비슷한 문법으로 UI를 정의할 수 있음
// 브라우저에서 직접 실행되지 않으며 Babel 같은 도구에 의해 JavaScript로 변환됨
// 동적 데이터 바인딩 가능 ({} 중괄호로 JavaScript 표현식을 삽입)
//
// 2. JSX의 장점
// 가독성: HTML과 비슷하여 코드를 이해하기 쉬움
// 직관적인 동적 데이터 렌더링: 중괄호를 사용해 JavaScript 변수를 쉽게 렌더링할 수 있음
// 컴포넌트 기반 개발: 작은 UI 컴포넌트를 재사용 가능하게 함

import React from "react";
// React 17 이상에서는 import 없이도 JSX 사용 가능

//JSX문법
export const E1 = <h1 className="greeting">Hello JSX!</h1>;

//바벨(Babel)을 통해서 순수 자바스크립트로 변환이 된다.
export const E2 = React.createElement(
  "h1",
  { className: "greeting" },
  "Hello JSX!"
);

export const E3 = (
  <div>
    <h1>Hello JSX!</h1>
    <p>This is simple text.</p>
  </div>
);

export const E4 = React.createElement(
  "div",
  null,
  React.createElement("h1", null, "Hello JSX!"),
  React.createElement("p", null, "This is simple text.")
);

//조건부 렌더링(JSX 사용)
const isLoggedIn = false;
export const E5 = (
  <div>{isLoggedIn ? <h1>Welcome!</h1> : <h1>Plz Sign in</h1>}</div>
);

export const E6 = React.createElement(
  "div",
  null,
  isLoggedIn
    ? React.createElement("h1", null, "Welcome!")
    : React.createElement("h1", null, "Plz Sign in")
);

//리스트 렌더링(JSX 사용)
const items = ["Apple", "Banana", "Cherry"];
export const E7 = (
  <ul>
    {items.map((item) => {
      <li key={item}>{item}</li>;
    })}
  </ul>
);

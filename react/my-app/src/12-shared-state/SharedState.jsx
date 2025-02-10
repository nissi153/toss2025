// SharedState.jsx
/**
 * 리액트의 Shared State (공유 상태)
    Shared State(공유 상태)란 
    리액트 애플리케이션에서 둘 이상의 컴포넌트가 동일한 상태를 공유할 때 사용하는 개념입니다. 
    리액트는 단방향 데이터 흐름(부모 → 자식) 구조를 따르기 때문에 상태를 공유하려면 
    공통 부모 컴포넌트에서 상태를 관리하고, 
    이를 자식 컴포넌트에 props로 전달하는 방식이 일반적입니다.

    하지만 컴포넌트 간의 상태 공유가 더 복잡할 경우 
    useContext 훅(전역), Redux, Zustand 같은 상태 관리 라이브러리를 사용하기도 합니다.
 */
/**
 * 예제 1. 기본적인 Shared State 예제 (Props 전달)
    구조
    부모 컴포넌트에서 상태를 관리하고, 
    자식 컴포넌트에 상태와 상태 업데이트 함수를 전달하는 방식.
 */
import React, { useState } from "react";
//자식 컴퍼넌트1
function CounterDisplay1(props) {
  return <h2>현재 카운트: {props.count}</h2>;
}
//자식 컴퍼넌트2
function CounterDisplay2(props) {
  return <button onClick={props.increment}>카운트 증가</button>;
}
//부모 컴퍼넌트
export function SharedState() {
  const [count, setCount] = useState(0);

  const incrementCount = () => {
    setCount((prevCount) => prevCount + 1);
  };
  return (
    <div>
      <h2>Shared State 예제</h2>
      <CounterDisplay1 count={count} />
      <CounterDisplay2 increment={incrementCount} />
    </div>
  );
}

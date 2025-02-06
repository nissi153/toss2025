// 리액트 훅(React Hooks)은 함수형 컴포넌트에서도
// 클래스 컴포넌트의 기능(예: 상태 관리, 생명 주기 관리)을 사용할 수 있도록 도와주는 기능입니다.
// 훅은 리액트 v16.8부터 도입되었으며,
// useState, useEffect, useContext 등 다양한 훅이 제공됩니다.

// Hook이라는 영단어는 갈고리라는 뜻인데,
// 프로그래밍에서는 원래 존재하는 어떤 기능에 갈고리를 거는 것처럼
// 끼어 들어가 같이 수행되는 것

//1. useState 훅
// 컴퍼넌트 내에서 상태를 관리할 수 있도록 도와주는 훅이다.
// 상태 변수와 상태를 업데이트하는 함수를 반환합니다.
import React, { useState, useEffect } from "react";

//App7.js  import * as E from "7-hook/Hook"
//index.js import App from "App7"
export function Counter1() {
  let count = 0;

  return (
    <div>
      {/* 리렌더링이 안되는 이슈 발생 */}
      <h1>Counter: {count}</h1>
      <button onClick={() => count + 1}>증가</button>
    </div>
  );
}

export function Counter2() {
  const [count, setCount] = useState(0);
  return (
    <div>
      {/* 상태변수가 업데이트시 리렌더링됨. */}
      <h1>Counter: {count}</h1>
      <button onClick={() => setCount(count + 1)}>증가</button>
    </div>
  );
}

//2. useEffect 훅 : 사이드 이펙트 관리 훅
// 함수형 컴퍼넌트의 생명주기 함수를 지원한다.
// 1. 마운트 : useEffect( ()=>{}, [] );
// 2. 언마운트 : useEffect( ()=>{ return ()=>{} } );
// 3. 업데이트(props, state가 업데이트될 때) :
//      useEffect(()=>{}, [state1, state2]);
export function Counter3() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log("컴퍼넌트가 마운트되었습니다.");
  }, []);

  useEffect(() => {
    return () => {
      console.log("컴퍼넌트가 언마운트되었습니다.");
    };
  }, []);

  useEffect(() => {
    console.log("컴퍼넌트가 업데이트되었습니다.");
  }, [count]); //의존성 변수(배열)가 바뀌면 호출됨.

  return (
    <div>
      <p>총 {count}번 클릭했습니다.</p>
      {/* <button onClick={ () => { setCount(count + 1); } }>증가</button> */}
      <button onClick={() => setCount(count + 1)}>증가</button>
    </div>
  );
}

//3. useMemo 훅
//  useMemo는 특정 연산의 결과를 메모이제이션(저장)하여
//  불필요한 재계산을 방지하는데 사용된다.
//  컴퍼넌트가 렌더링 될때마다 매번 계산하는 대신
//  의존성 배열에 명시된 값이 변경될 때만 해당 연산을 다시 수행한다.
//  용도
//  1. 비용이 큰 연산을 최적화할 때(통신, 큰 데이터 연산...)
//  2. 렌더링 성능을 개선할 때

export function Counter4() {
  const [number, setNumber] = useState(0);
  coust[(inputValue, setInputValue)] = useState("");

  return (
    <div>
      <h1>useMemo</h1>
      <h1>입력한 숫자: {number}</h1>
      <h2>두 배 결과: {double}</h2>

      <input
        type="number"
        value={number}
        onChange={(e) => setNumber(parseInt(e.target.value))}
      />
      <br />
      <input
        type="text"
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}
        placeholder="입력하세요."
      />
    </div>
  );
}

//Lifecycle.jsx
// 리액트 라이프사이클(생애주기)의 개념
// 리액트의 라이프사이클은 컴포넌트가 생성되고, 업데이트되며,
// 제거될 때 일어나는 일련의 과정을 의미합니다.
// 클래스형 컴포넌트에서 더 명확하게 사용되었지만,
// 함수형 컴포넌트에서는 useEffect Hook을 통해 비슷한 동작을 구현할 수 있습니다.

// 리액트 컴포넌트 라이프사이클의 3단계
// 1. 마운트 (Mount): 컴포넌트가 처음 DOM에 추가될 때 발생하는 단계
// 2. 업데이트 (Update): 상태나 props가 변경되어 컴포넌트가 다시 렌더링될 때 발생하는 단계
// 3. 언마운트 (Unmount): 컴포넌트가 DOM에서 제거될 때 발생하는 단계

// 클래스형 컴포넌트의 주요 라이프사이클 메서드
// componentDidMount(): 컴포넌트가 처음 렌더링된 후 실행
// componentDidUpdate(): 컴포넌트가 업데이트된 후 실행
// componentWillUnmount(): 컴포넌트가 언마운트(제거)되기 직전에 실행

import React, { Component, useEffect, useState } from "react";

//extends : 상속
export class LifecycleClass extends Component {
  constructor(props) {
    //자식생성자 함수
    super(props); //부모생성자 함수 호출
    this.state = {
      //상태변수 선언
      count: 0,
    };
  }

  //마운트 발생시 호출됨.
  componentDidMount() {
    console.log("컴퍼넌트가 마운트되었습니다.");
  }
  //언마운트 발생시 호출됨.
  componentWillUnmount() {
    console.log("컴퍼넌트가 언마운트되었습니다.");
  }
  //상태나 props가 변경시 호출됨(update)
  componentDidUpdate() {
    console.log(`컴퍼넌트가 업데이트되었습니다.${this.state.count}`);
  }
  render() {
    return (
      <div>
        <h1>리액트 라이프사이클(클래스형)</h1>
        <p>Count: {this.state.count}</p>
        <button
          onClick={() => {
            // setState : 클래스형 컴퍼넌트의 상태변경 함수
            this.setState({ count: this.state.count + 1 });
          }}
        >
          +1
        </button>
      </div>
    );
  }
}

// 함수형 컴포넌트에서는 useEffect Hook로 라이프사이클을 관리
// useEffect는 다음과 같은 역할을 할 수 있습니다:
// useEffect(() => {}, []): 컴포넌트가 마운트될 때 실행
// useEffect(() => {}, [state]): 의존성 배열이 변경될 때 실행
// return () => {}: 컴포넌트가 언마운트될 때 실행 (클린업 함수)

//함수형 컴퍼넌트
export function LifecycleFunc() {
  //     상태변수 상태설정함수      초기값
  const [count, setCount] = useState(0);
  const [total, setTotal] = useState(0);

  //마운트 & 언마운트
  useEffect(() => {
    console.log("컴퍼넌트가 마운트되었습니다.");
    return () => {
      console.log("컴퍼넌트가 언마운트되었습니다.");
    };
  }, []); //빈배열을 넣으면, 마운트/언마운트시 한번만 호출
  //업데이트
  useEffect(() => {
    console.log("컴퍼넌트가 업데이트되었습니다.");
  }, [count]); //의존성 상태변수 배열을 설정한다.

  return (
    <div>
      <h1>리액트 라이프사이클(함수형 컴퍼넌트)</h1>
      <p>Count: {count}</p>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        +1
      </button>
    </div>
  );
}

//부모 컴포넌트
export function Lifecycle() {
  //       상태변수  상태설정함수                  초기값
  const [showComponent, setShowComponent] = useState(true);

  //조건부 렌더링
  //1. if else
  //2. 삼항연산자
  //3. 논리연산자(&& ||)
  return (
    <div style={{ padding: "20px" }}>
      {showComponent && <LifecycleFunc />}
      <button
        onClick={() => {
          setShowComponent(!showComponent);
        }}
      >
        {showComponent ? "컴퍼넌트 제거" : "컴퍼넌트 추가"}
      </button>
    </div>
  );
}

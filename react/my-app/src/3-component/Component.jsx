// Component.jsx
// 리액트(React) 컴포넌트는 리액트 애플리케이션을 구성하는 기본 단위입니다.
// 리액트는 UI를 재사용 가능한 작은 컴포넌트로 나누어 개발할 수 있게 해 주는 라이브러리로,
//   각 컴포넌트는 독립적인 기능을 가지며 재사용할 수 있습니다.

// 리액트 컴포넌트 개념
// 1. Props를 입력받고, 리액트 엘리먼트를 반환해 주는 것
// 2. 컴포넌트의 이름은 항상 대문자로 시작(파스칼)

// 컴포넌트의 종류
// 1. 함수형 컴포넌트 (Functional Component): 리액트 훅(Hooks)을 사용하여 상태 관리가 가능합니다.
// 2. 클래스형 컴포넌트 (Class Component): React.Component를 상속받아 사용합니다.
//      이전에는 상태 관리에 주로 사용되었으나, 최근에는 함수형 컴포넌트와 훅을 더 선호하는 추세입니다.

// Props와 State
// 1. Props: 부모 컴포넌트가 자식 컴포넌트에 전달하는 데이터입니다. 읽기 전용입니다.
// 2. State: 컴포넌트 내부에서 관리하는 데이터입니다. 변경 시 UI가 재렌더링됩니다.
//         부모의 State가 변경되면, 자식 컴퍼넌트가 재렌더링 됨.
import React from "react";

//클래스형 컴퍼넌트
class GreetingClass extends React.Component {
  render() {
    //오버라이딩(over ride) : 부모클래스의 함수를 자식클래스가 재정의한다.
    //오버로딩(over loading) : 함수(메서드)의 매개변수의 갯수와 타입을 다르게 함으로 확장하는 것.
    return <h1>Hello React! {this.props.name}</h1>;
  }
}
// <GreetingClass name="hong" />

//함수형 컴퍼넌트
function GreetingFunc(props) {
  return <h1>Hello React! {props.name}</h1>;
}

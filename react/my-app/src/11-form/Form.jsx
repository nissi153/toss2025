//Form.jsx
/**
 * 리액트 입력폼에 대한 개념
리액트에서 입력폼(input form)은 사용자의 입력을 받아 상태(state)로 관리하는 중요한 요소입니다. 
일반적으로 입력폼을 만들 때는 리액트의 **상태(state)**와 이벤트 핸들러를 사용하여 입력 데이터를 관리합니다.

리액트 폼은 크게 두 가지로 나뉩니다:
1. 제어 컴포넌트(Control Component): 입력값이 리액트 상태에 의해 제어되는 컴포넌트입니다.
2. 비제어 컴포넌트(Uncontrolled Component): 입력값이 DOM 노드에 의해 관리되고 상태로 제어하지 않는 방식입니다.

항목	            제어 컴포넌트 (Controlled)	            비제어 컴포넌트 (Uncontrolled)
데이터 관리 방식	리액트 상태(state)로 관리	            DOM의 값(ref)으로 직접 접근
실시간 입력 반영	입력값이 상태 업데이트로 즉각 반영됨	상태 업데이트 없이, 필요 시 ref를 사용해 읽음
사용 사례	        유효성 검사, 입력에 따라 즉각 반응이 필요한 경우	간단한 폼이나 초기값만 설정하고 나중에 읽을 때
*/

import React, { useState, useRef } from "react";

//제어 컴퍼넌트 예제
export function ControledForm() {
  const [inputValue, setInputValue] = useState("");
  const [textareaValue, setTextareaValue] = useState("");
  const [selectValue, setSelectValue] = useState("option1");

  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  const handleTextareaChange = (e) => {
    setTextareaValue(e.target.value);
  };

  const handleSelectChange = (e) => {
    setSelectValue(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault(); //submit 통신 방지
    alert(
      `입력값: ${inputValue}, 텍스트: ${textareaValue}, 선택값: ${selectValue}`
    );
  };

  return (
    <form action="#" onSubmit={handleSubmit}>
      <div>
        <label>이름: </label>
        <input type="text" value={inputValue} onChange={handleInputChange} />
        <label>설명: </label>
        <textarea
          value={textareaValue}
          onChange={handleTextareaChange}
        ></textarea>
        <div>
          <label>선택: </label>
          <select value={selectValue} onChange={handleSelectChange}>
            <option value="option1">옵션 1</option>
            <option value="option2">옵션 2</option>
            <option value="option3">옵션 3</option>
          </select>
        </div>
      </div>
      <button type="submit">제출</button>
    </form>
  );
}

//비제어 컴퍼넌트
// ref를 사용하여 입력값을 직접 DOM에서 읽는 방식이다.
export function UncontrolledForm() {
  const inputRef = useRef(null);
  const textareaRef = useRef(null);
  const selectRef = useRef(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(
      `입력값: ${inputRef.current.value}, 텍스트: ${textareaRef.current.value}, 
      선택값: ${selectRef.current.value}`
    );
  };

  return (
    <form action="#" onSubmit={handleSubmit}>
      <h3>Ref 폼</h3>
      <div>
        <label>이름: </label>
        <input type="text" ref={inputRef} />
        <label>설명: </label>
        <textarea ref={textareaRef}></textarea>
        <div>
          <label>선택: </label>
          <select ref={selectRef}>
            <option value="option1">옵션 1</option>
            <option value="option2">옵션 2</option>
            <option value="option3">옵션 3</option>
          </select>
        </div>
      </div>
      <button type="submit">제출</button>
    </form>
  );
}

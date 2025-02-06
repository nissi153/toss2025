//Event.jsx
//리액트 이벤트 개요
//리액트에서 이벤트는 일반적인 HTML DOM 이벤트와 유사하지만 약간의 차이점이 있습니다.
//리액트 이벤트는 기본적으로 synthetic event(합성 이벤트) 시스템을 사용합니다.

// 리액트 이벤트의 특징
// 1. 합성 이벤트(SyntheticEvent):
//    리액트는 이벤트 핸들러에 전달되는 이벤트 객체가 브라우저의
//    기본 이벤트 객체를 래핑한 SyntheticEvent라는 것을 의미합니다.
// 2. 브라우저 간 호환성 보장: 다양한 브라우저 간
//    이벤트 처리를 신경 쓰지 않아도 됩니다.
// 3. DOM 요소에만 사용 가능: 커스텀 컴포넌트에는 직접 이벤트를 전달할 수 없습니다.
//    반드시 DOM 요소에만 onClick, onChange와 같은 이벤트를 사용할 수 있습니다.
// 4. 기본 동작 취소: 이벤트 핸들러에서 preventDefault()
//    또는 stopPropagation() 같은 메서드를 사용할 수 있습니다.
//    <input type="submit" />
//     e.preventDefault();

import React, { use, useState } from "react";

export function Event1() {
  const [message, setMessage] = useState("버튼을 클릭하세요.");

  const handleClick = () => {
    setMessage("버튼이 클릭되었습니다!");
  };
  const style = { textAlign: "center", marginTop: "50px" };

  return (
    <div style={style}>
      <h3>{message}</h3>
      {/* handleClick() : 즉시 실행이 되므로 주의!*/}
      <button onClick={handleClick}>클릭</button>
    </div>
  );
}

export function Event2() {
  const [message, setMessage] = useState("버튼을 클릭하세요.");

  const handleClick = (e, id) => {
    e.preventDefault(); //이벤트 기본동작을 방지
    setMessage(`버튼 ${id}이 클릭됨.`);
  };

  return (
    <div>
      <form action={"http://myserver.com"}>
        <h3>{message}</h3>
        {/* 이벤트 함수는 이벤트객체를 전달받을 수 있다. */}
        <button type="submit" onClick={(event) => handleClick(event, 1)}>
          첫번째 버튼
        </button>
        <button type="submit" onClick={(event) => handleClick(event, 2)}>
          두번째 버튼
        </button>
      </form>
    </div>
  );
}

//이벤트 객체의 주요 속성:
// e.target: 이벤트가 발생한 요소를 가리킵니다.
// e.currentTarget: 이벤트가 바인딩된 요소를 가리킵니다.
// e.preventDefault(): 기본 동작 방지.
// e.stopPropagation(): 이벤트 전파 방지.
//  이벤트 버블링이란,
//   특정 요소에서 이벤트가 발생했을 때
//   그 이벤트가 부모 요소로 전파(버블링)되는 현상을 의미합니다.
//   이벤트 버블링(Event Bubbling)을 중단하는 데 사용됩니다.

//주요 리액트 이벤트들
// 이벤트 이름	설명	                                사용 예제
// onClick	    클릭했을 때 발생하는 이벤트	            버튼, 링크
// onChange	    입력값이 변경될 때 발생하는 이벤트	    <input>, <textarea> 등
// onSubmit	    폼이 제출될 때 발생하는 이벤트	        <form>
// onKeyPress	키보드 키가 눌렸을 때 발생하는 이벤트	<input>, <textarea>
// onMouseEnter	마우스가 요소 위로 올라갈 때 발생하는 이벤트	특정 박스나 이미지
// onFocus	    입력 필드에 포커스가 들어갈 때 발생	    <input>, <textarea>
// onBlur	    포커스가 해제될 때 발생하는 이벤트	    <input>, <textarea>

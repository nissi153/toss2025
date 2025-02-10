//LiftingStateUp.jsx
/**
 * State 끌어올리기 (Lifting State Up)
    개념
    리액트에서 state 끌어올리기는 여러 자식 컴포넌트가 동일한 데이터를 필요로 할 때
    상태를 공통 부모 컴포넌트로 끌어올려 한 곳에서 관리하는 패턴입니다.

    리액트는 단방향 데이터 흐름을 따르기 때문에, 상위 컴포넌트에서 상태를 관리하면 
    그 상태를 props를 통해 자식 컴포넌트에 전달하여 일관된 상태를 유지할 수 있습니다.
 */

/**
 * 예제 1: 두 입력 필드의 동기화 (상태 끌어올리기)
    문제:   
    두 개의 입력 필드가 있고, 두 입력 필드에 입력한 값을 상위 컴포넌트에서 
    한 번에 관리해야 합니다.
*/
import React, { useState } from "react";

// 자식 컴포넌트 1 - 첫 번째 입력 필드
function InputField1({ value, onChange }) {
  return (
    <div>
      <label>자식1: 입력 필드 1: </label>
      <input
        type="text"
        value={value}
        onChange={(e) => onChange(e.target.value)}
      />
    </div>
  );
}

// 자식 컴포넌트 2 - 두 번째 입력 필드
function InputField2({ value, onChange }) {
  return (
    <div>
      <label>자식2: 입력 필드 2: </label>
      <input
        type="text"
        value={value}
        onChange={(e) => onChange(e.target.value)}
      />
    </div>
  );
}

// 부모 컴포넌트 (상태 관리)
export function LiftingStateUp() {
  const [text1, setText1] = useState("");
  const [text2, setText2] = useState("");

  return (
    <div>
      <h1>State 끌어올리기 예제</h1>
      <InputField1 value={text1} onChange={setText1} />
      <InputField2 value={text2} onChange={setText2} />
      <h3>부모:입력된 값 1: {text1}</h3>
      <h3>부모:입력된 값 2: {text2}</h3>
    </div>
  );
}

//CustomHook.jsx
// 커스텀 훅
// 개념: 커스텀 훅은 리액트의 기본 훅(useState, useEffect, useRef 등)을 조합하여
//   재사용할 수 있는 로직을 만드는 훅입니다.
// 1. 커스텀 훅은 반복되는 로직을 분리하여 다른 컴포넌트에서도 재사용할 수 있도록 만듭니다.
// 2, 이름 규칙: use로 시작하는 함수로 작성해야 합니다. 예: useCounter

import { useState } from "react";

//커스텀 훅 정의
function useCounter(initValue = 0) {
  const [count, setCount] = useState(0);

  const increase = () => setCount((prev) => prev + 1);
  const decrease = () => setCount((prev) => prev - 1);
  const reset = () => setCount(initValue);

  return { count, increase, decrease, reset };
}

//import useCounter from "./useCounter"; // 커스텀훅 인포트
function Counter() {
  const { count, increase, decrease, reset } = useCounter(0);

  return (
    <div>
      <h3>Counter: {count}</h3>
      <button onClick={increase}>증가</button>
      <button onClick={decrease}>감소</button>
      <button onClick={reset}>리셋</button>
    </div>
  );
}

export default Counter;

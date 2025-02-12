// App.js: 사용자 인터페이스와 Redux 상태 관리를 연결합니다.
import React from "react";
import { useSelector, useDispatch } from "react-redux";

function App() {
  // Redux Store에서 count 상태를 가져옵니다.
  const count = useSelector((state) => state.count);
  // 액션을 디스패치할 수 있는 함수
  const dispatch = useDispatch();

  return (
    <div style={{ textAlign: "center", padding: "50px" }}>
      <h1>Redux Counter</h1>
      <h2>{count}</h2> {/* 현재 카운터 값 표시 */}
      {/* 버튼 클릭 시 INCREMENT 액션 디스패치 */}
      <button onClick={() => dispatch({ type: "INCREMENT" })}>증가</button>
      {/* 버튼 클릭 시 DECREMENT 액션 디스패치 */}
      <button onClick={() => dispatch({ type: "DECREMENT" })}>감소</button>
    </div>
  );
}

export default App;

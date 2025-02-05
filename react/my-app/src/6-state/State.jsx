//State.jsx
// 리액트의 state 개념
// state는 리액트 컴포넌트에서 동적인 데이터를 관리하기 위해 사용되는 객체입니다.
// 컴포넌트의 상태를 관리하고, 상태가 변경되면 해당 변경 사항이 UI에 반영됩니다.
// 예를 들어, 버튼을 클릭하면 숫자가 증가하거나 입력 폼의 내용을 실시간으로
// 화면에 업데이트하는 것 같은 작업들이 state로 관리됩니다.

// 특징
// 1.동적 데이터 관리: UI에서 사용자가 상호작용하면서 발생하는 동적 데이터를 관리.
// 2.변경 시 자동 렌더링: state가 변경되면 컴포넌트가 자동으로 다시 렌더링됨.
// 3.지역적 관리: 각 컴포넌트는 독립적으로 자신만의 state를 가질 수 있음.

import React, { useState } from "react";

export function Counter() {
  //count라는 상태와 이를 변경하는 setCount함수, 초기값은 0
  //const를 사용하는 이유: 상태 참조 자체가 변경되지 않기 때문이다.
  // setCount를 통해서 상태 변경이 이루어 지기 때문이다.
  const [count, setCount] = useState(0);

  return (
    <div>
      {/* JSX 주석문 */}
      <p>{count}</p>
      {/* 버튼 클릭시 count를 1 증가시키는 이벤트 핸들러 */}
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        1씩 증가
      </button>
    </div>
  );
}

export function LikeButton() {
  const [liked, setLiked] = useState(false);

  const toggleLike = () => {
    setLiked(!liked);
  };

  return (
    <div>
      <button onClick={toggleLike}>{liked ? "좋아요 취소" : "좋아요"}</button>
      <p>{liked ? "이 게시물을 좋아합니다." : "좋아요!를 눌러주세요~"}</p>
    </div>
  );
}

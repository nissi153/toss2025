//Props.jsx
// 리액트의 Props 개념
// 1. Props란?
//  a. Props는 **"Properties"**의 줄임말로, 리액트 컴포넌트에 데이터를 전달하는 방법입니다.
//  b. 부모 컴포넌트에서 자식 컴포넌트로 데이터를 전달할 때 사용되며, 읽기 전용입니다.
//    (자식 컴포넌트에서 직접 props를 변경할 수 없습니다.)
//  c. Props는 JSX 속성처럼 작성하며, 컴포넌트 내에서 객체 형태로 접근할 수 있습니다.
// 2. Props의 특징
//  a. 컴포넌트 간 데이터 전달 용도
//  b. 불변성 (읽기 전용, 자식에서 수정할 수 없음)
//  c. 동적 데이터 렌더링 지원(props, state가 변경되면 리렌더링됨)

function DisplayList(props) {
  return (
    <div>
      <h2>{props.title}</h2>
      <ul>
        {props.items.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
    </div>
  );
}

export function Props1() {
  return (
    <div>
      <DisplayList title="과일 목록" items={["사과", "바나나", "포도"]} />
      <DisplayList
        title="언어 목록"
        items={["자바스크립트", "파이썬", "자바"]}
      />
    </div>
  );
}

//Ex.jsx
// 1. 문제 1: 단일 Props 전달하기
// 목표: 단일 `props`를 활용하여 간단한 문구를 출력하는 컴포넌트를 작성하세요.
// 요구사항:
// - `Greeting`이라는 자식 컴포넌트를 만드세요.
// - `name`이라는 `props`를 받아 "환영합니다,
//   [이름]님!"이라는 문구를 렌더링합니다.
// - 부모 컴포넌트에서 여러 사람의 이름을 넘겨 출력합니다.
function Greeting(props) {
  return <h1>환영합니다, {props.name}님!</h1>;
}

export function Problem1() {
  return (
    <div>
      <Greeting name="홍길동" />
      <Greeting name="김민수" />
      <Greeting name="이영희" />
    </div>
  );
}

// 2. 문제 2: 여러 Props 전달하기
// 목표: 여러 개의 `props`를 활용하여 사용자의 정보를 출력하는 컴포넌트를 작성하세요.
// 요구사항:
// - `UserCard`라는 자식 컴포넌트를 작성하세요.
// - `name`, `age`, `job`을 `props`로 받아 사용자 정보를 표시합니다.
// - 부모 컴포넌트에서 두 명의 사용자 정보를 전달해 렌더링합니다.
function UserCard(props) {
  return (
    <div>
      <h2>이름: {props.name}</h2>
      <p>나이: {props.age}세</p>
      <p>직업: {props.job}</p>
    </div>
  );
}

export function Problem2() {
  return (
    <div>
      <UserCard name="홍길동" age={30} job="개발자" />
      <UserCard name="김민수" age={25} job="디자이너" />
    </div>
  );
}

// 3. 문제 3: 배열 Props 전달하기
// 목표: 배열 데이터를 `props`로 전달하여 리스트 형태로 출력하는 컴포넌트를 작성하세요.
// 요구사항:
// - `ItemList`라는 자식 컴포넌트를 작성하세요.
// - `items`라는 배열을 `props`로 받아 `<li>` 태그로 각 항목을 렌더링합니다.
// - 부모 컴포넌트에서 두 개의 다른 배열을 전달해 두 개의 목록을 출력합니다.

function ItemList(props) {
  return (
    <div>
      <h3>리스트</h3>
      <ul>
        {props.items.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
    </div>
  );
}

export function Problem3() {
  return (
    <div>
      <ItemList items={["사과", "바나나", "포도"]} />
      <ItemList items={["축구", "농구", "야구"]} />
    </div>
  );
}
// 4. 문제 4: 이벤트 Props 전달하기
// 목표: 버튼을 클릭했을 때 이벤트를 처리하는 컴포넌트를 작성하세요.
// 요구사항:
// - `ClickButton`이라는 자식 컴포넌트를 작성하세요.
// - 부모 컴포넌트에서 클릭 시 경고창이 뜨도록 이벤트 핸들러를 전달하세요.

function ClickButton(props) {
  return <button onClick={props.onClick}>버튼을 클릭하세요</button>;
}

export function Problem4() {
  function handleClick() {
    alert("버튼이 클릭되었습니다!");
  }

  return (
    <div>
      <h2>이벤트 핸들링 연습</h2>
      <ClickButton onClick={handleClick} />
    </div>
  );
}

// 5. 문제 5: children을 이용한 컴포넌트 구성
// 목표: `children`을 활용하여 컴포넌트 내부에서 콘텐츠를 자유롭게 구성하는 연습을 합니다.
// 요구사항:
// - `InfoCard`라는 자식 컴포넌트를 작성하세요.
// - `title`이라는 `props`와 `children`을 사용하여 제목과 본문 콘텐츠를 렌더링합니다.
// - 부모 컴포넌트에서 두 개의 카드를 렌더링하세요.

function InfoCard(props) {
  return (
    <div
      style={{ border: "1px solid gray", padding: "10px", borderRadius: "5px" }}
    >
      <h2>{props.title}</h2>
      {props.children}
    </div>
  );
}
// 자식 컴퍼넌트(child component)
// 자식 요소 (child element) : props.children
export function Problem5() {
  return (
    <div>
      <InfoCard title="첫 번째 카드">
        <p>이곳은 첫 번째 카드의 내용입니다.</p>
      </InfoCard>
      <InfoCard title="두 번째 카드">
        <p>이곳은 두 번째 카드의 내용입니다.</p>
        <button>더보기</button>
      </InfoCard>
    </div>
  );
}

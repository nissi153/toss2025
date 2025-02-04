// 연습문제1: 동적 표현식 렌더링
// 목표: props로 받은 이름을 화면에 출력하는 간단한 컴포넌트 연습
// 요구사항
// 1. Namecard 컴포넌트를 만들고, user 객체의 정보를 JSX에 넣어서
//   표현한다.
// 2. props는 사용안함.

const user = {
  firstName: "김",
  lastName: "민수",
  age: 30,
};
export const Namecard = () => {
  return (
    <div>
      <h3>{user.firstName}</h3>
      <h3>{user.lastName}</h3>
      <h3>{user.age}</h3>
    </div>
  );
};

//연습문제2: props를 이용해 이름과 나이 출력하기
// 목표: props로 전달받은 이름과 나이를 사용자 정의 컴퍼넌트에 출력한다.
// 요구사항
// 1. Greeting 함수형 컴퍼넌트를 만들고, props로 전달받은 name과 age를
//   출력한다.
// 2. 출력양식 : 안녕하세요, 홍길동님! 당신의 나이는 25살입니다.
export const Greeting = (props) => {
  return (
    <div>
      <p>
        안녕하세요, {props.name}님! 당신의 나이는 {props.age}살 입니다. <br />
        `안녕하세요, ${props.name}님! 당신의 나이는 ${props.age}살 입니다.`
      </p>
    </div>
  );
};

//연습문제3: 다음의 객체배열의 데이터를 출력하시오.
//목표: props로 전달받은 객체 배열의 데이터를 조작할 수 있다.
//요구사항
// 1. 상품이름 - 가격(원)으로 출력한다.
// 출력 예) 1. 노트북 - 8000원
//          2. 스마트폰 - 4000원
const products = [
  { id: 1, name: "노트북", price: 8000 },
  { id: 2, name: "스마트폰", price: 4000 },
  { id: 3, name: "태블릿", price: 6000 },
];

export const ProductList = () => {
  return (
    <>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {products.map((item, index) => (
          <li key={index + 1}>
            {index + 1}. {item.name} - {item.price}원
          </li>
        ))}
      </ul>
    </>
  );
};

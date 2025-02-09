import * as E from "./1-element/Element";
// import * as ex from "./1-element/Ex";

function App() {
  //이 방식은 JSX로 렌더링하지 않고
  // React 컴퍼넌트 자체 또는 JSX 요소로 작성된 변수를 반환하는 경우.
  // React.createElement(E.E6)로 실행한다.
  return E.E6;

  //이 방식은 React의 함수형(클래스형) 컴퍼넌트를
  // JSX 문법으로 호출하여 반환하는 경우.
  // return <E.Hello name="홍길동" />;
  // return <E.ConfirmDialog />;

  //연습문제
  // return <ex.Namecard />;
  // return <ex.Greeting name="홍길동" age="30" />;
  // return <ex.ProductList />;
}

export default App;

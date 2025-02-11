// StyledComponent1.jsx
import styled from "styled-components";

//styled-components 모듈 사용 : JSX-html문법, SC는 css문법을 그대로 따름.
// 모듈 설치
// npm i styled-components

const Button = styled.button`
  //css 문법 사용
  color: red;
  font-size: 24px;
  /* background-color: lightblue; */
  background-color: ${(props) => (props.dark ? "black" : "lightblue")};
  border: 1px solid green;
`;

function StyledComponent1() {
  return (
    <div>
      <Button>Normal</Button>
      <Button dark="dark">Dark</Button>
    </div>
  );
}

export default StyledComponent1;

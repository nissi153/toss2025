import styled from "styled-components";

const Button = styled.button`
  color: grey;
  background-color: yellow;
  border: 2px solid green;
`;

//Button에 style을 추가할 수 있다.
const RoundedButton = styled(Button)`
  border-radius: 16px;
`;

function StyledComponent2() {
  return (
    <div>
      <Button>Normal</Button>
      <RoundedButton>Rounded</RoundedButton>
    </div>
  );
}

export default StyledComponent2;

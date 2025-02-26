import React from "react";
import styled from "styled-components";

interface MyButtonProps {
  primary?: boolean;
}

const MyButton = styled.button<MyButtonProps>`
  background: ${(props) => (props.primary ? "blue" : "gray")};
  color: white;
  padding: 10px;
`;

export function CustomButton() {
  return <MyButton primary={true}>Click me</MyButton>;
}

//리액트에서 함수형 컴퍼넌트의 타입 정의(생략 가능)
//React.FC
interface ButtonProps {
  label: string;
}

export const Button: React.FC<ButtonProps> = ({ label }: ButtonProps) => {
  return <button>{label}</button>;
};

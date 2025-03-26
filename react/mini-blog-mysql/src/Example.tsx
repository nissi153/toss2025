import React, { useState, useRef } from "react";
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

interface User {
  id: number;
  name: string;
}

export const ExampleFunc: React.FC = () => {
  const [count, setCount] = useState<number>(0);
  const [user, setUser] = useState<User | null>(null);
  const inputRef = useRef<HTMLInputElement | null>(null);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    console.log(event.target.value);
  };
  const handleClick = (event: React.MouseEvent<HTMLInputElement>) => {
    console.log("button clicked");
  };

  return <div></div>;
};

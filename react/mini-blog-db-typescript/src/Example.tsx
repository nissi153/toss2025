import React from "react";

//리액트에서 함수형 컴퍼넌트의 타입 정의(생략 가능)
//React.FC
interface ButtonProps {
  label: string;
}

const Button: React.FC<ButtonProps> = ({ label }) => {
  return <button>{label}</button>;
};

export default Button;

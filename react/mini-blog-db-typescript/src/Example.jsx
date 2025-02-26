import React from "react";
import styled from "styled-components";

export const MyButton = styled.button`
  background: blue;
  color: white;
  padding: 10px;
  ${(props) => props.height && `height: ${props.height}px;`};
`;

export function CustomButton() {
  return <MyButton height={50}>Click me</MyButton>;
}

export const Button = ({ label }) => {
  return <button>{label}</button>;
};

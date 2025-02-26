import React from "react";
import styled from "styled-components";

interface TextInputProps {
  height?: number;
  value: string;
  onChange: (event: React.ChangeEvent<HTMLTextAreaElement>) => void;
}

const StyledTextarea = styled.textarea<{ height?: number }>`
  width: calc(100% - 32px);
  ${({ height }) => (height ? `height: ${height}px;` : "")}
  padding: 16px;
  font-size: 16px;
  line-height: 20px;
`;

const TextInput: React.FC<TextInputProps> = ({ height, value, onChange }) => {
  return <StyledTextarea height={height} value={value} onChange={onChange} />;
};

export default TextInput;

import React from 'react'
import styled from 'styled-components'

const StyledButton = styled.button`
  padding: 8px 16px;
  font-size: 20px;
  border-width: 1px;
  border-radius: 8px;
  cursor: pointer;
`

interface ButtonProps {
  title?: string
  onClick?: () => void
}

const Button: React.FC<ButtonProps> = ({ title = 'button', onClick }) => {
  return <StyledButton onClick={onClick}>{title}</StyledButton>
}

export default Button

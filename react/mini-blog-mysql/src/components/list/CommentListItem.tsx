import React from 'react'
import styled from 'styled-components'

// 댓글 타입 정의
interface Comment {
  comment_no: number
  comment_content: string
  comment_post_no: number
}

interface CommentListItemProps {
  comment: Comment
}

const Wrapper = styled.div`
  width: calc(100% - 32px);
  padding: 16px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
  border: 1px solid grey;
  border-radius: 8px;
  cursor: pointer;
  background: white;
  :hover {
    background: lightgrey;
  }
`

const ContentText = styled.p`
  font-size: 14px;
`

const CommentListItem: React.FC<CommentListItemProps> = ({ comment }) => {
  return (
    <Wrapper>
      <ContentText>{comment.comment_content}</ContentText>
    </Wrapper>
  )
}

export default CommentListItem

import React from 'react'
import styled from 'styled-components'
import CommentListItem from './CommentListItem'

// 댓글 타입 정의
interface Comment {
  comment_no: number
  comment_content: string
  comment_post_no: number
}

interface CommentListProps {
  comments: Comment[]
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* 오타 수정: 'aligh-items' → 'align-items' */
  justify-content: center;

  & > * {
    :not(:last-child) {
      margin-bottom: 16px;
    }
  }
`

const CommentList: React.FC<CommentListProps> = ({ comments }) => {
  return (
    <Wrapper>
      {comments.map((comment) => (
        <CommentListItem key={comment.comment_no} comment={comment} />
      ))}
    </Wrapper>
  )
}

export default CommentList

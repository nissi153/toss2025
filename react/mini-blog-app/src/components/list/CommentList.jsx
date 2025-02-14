import React from "react";
import styled from "styled-components";
import CommentListItem from "./CommentListItem";

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  aligh-items: flex-start;
  justify-content: center;

  & > * {
    :not(:last-child) {
      margin-bottom: 16px;
    }
  }
`;

function CommentList(props) {
  const { comments } = props;

  return (
    <Wrapper>
      {comments.map((coment) => {
        return <CommentListItem key={coment.id} comment={comment} />;
      })}
    </Wrapper>
  );
}

export default CommentList;

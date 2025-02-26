import React from "react";
import styled from "styled-components";

// 게시글 타입 정의
interface Post {
  _id: string;
  title: string;
  content: string;
}

interface PostListItemProps {
  post: Post;
  onClick: () => void;
}

const Wrapper = styled.div`
  width: calc(100% - 32px);
  padding: 16px;
  display: flex;
  flex-direction: column;
  gap: 10px;
  align-items: flex-start;
  justify-content: center;
  border: 1px solid grey;
  border-radius: 8px;
  cursor: pointer;
  background: white;
  :hover {
    background: lightgrey;
  }
`;

const TitleText = styled.p`
  font-size: 20px;
  font-weight: 500;
  width: 100%;
`;

const PostListItem: React.FC<PostListItemProps> = ({ post, onClick }) => {
  return (
    <Wrapper onClick={onClick}>
      <TitleText>{post.title}</TitleText>
    </Wrapper>
  );
};

export default PostListItem;

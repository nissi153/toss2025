import React from "react";
import styled from "styled-components";
import PostListItem from "./PostListItem";

// 게시글 타입 정의
interface Post {
  _id: string; // MongoDB 기반이라면 `_id`가 일반적
  title: string;
  content: string;
}

interface PostListProps {
  posts: Post[];
  onClickItem: (post: Post) => void;
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* 오타 수정: 'aligh-items' -> 'align-items' */
  justify-content: center;
  gap: 10px;

  /* 부모 선택자 적용 */
  & > * {
    :not(:last-child) {
      margin-bottom: 16px;
    }
  }
`;

const PostList: React.FC<PostListProps> = ({ posts, onClickItem }) => {
  return (
    <Wrapper>
      {posts.map((post) => (
        <PostListItem
          key={post._id} // 'id' -> '_id' 변경
          post={post}
          onClick={() => onClickItem(post)}
        />
      ))}
    </Wrapper>
  );
};

export default PostList;

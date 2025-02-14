import React from "react";
import styled from "styled-components";
import PostListItem from "./PostListItem";

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  aligh-items: flex-start;
  justify-content: center;
  gap: 10px;

  /* & : 부모선택자 scss/sass문법 */
  & > * {
    :not(:last-child) {
      margin-bottom: 16px;
    }
  }
`;

function PostList(props) {
  const { posts, onClickItem } = props;

  return (
    <Wrapper>
      {posts.map((post, index) => {
        return (
          <PostListItem
            key={post.id}
            post={post}
            onClick={() => {
              onClickItem(post); //navigete : 페이지이동을 한다.
            }}
          />
        );
      })}
    </Wrapper>
  );
}

export default PostList;

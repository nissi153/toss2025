import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom"; //하이퍼링크-바로가기
import styled from "styled-components";
import Button from "../ui/Button";
import PostList from "../list/PostList";
import data from "../../../data.json";

//모든 콘텐츠를 감싸는 최상위 DIV
const Wrapper = styled.div`
  padding: 16px;
  width: calc(100% - 32px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;
const Container = styled.div`
  width: 100%;
  max-width: 720px;
  display: flex;
  flex-direction: column;
`;

function MainPage() {
  //const [posts, setPosts] = useState(data);
  const [posts, setPosts] = useState([]);
  const navigate = useNavigate();

  //console.log(data);

  useEffect(() => {
    const storedPosts = JSON.parse(localStorage.getItem("posts")) || [];
    setPosts(storedPosts);
  }, []);

  return (
    <Wrapper>
      <Container>
        <Button
          title="글 작성하기"
          onClick={() => {
            navigate("/post-write");
          }}
        ></Button>

        <div style={{ height: "10px" }}></div>

        <PostList
          posts={posts}
          onClickItem={(item) => {
            navigate(`/post/${item.id}`);
          }}
        ></PostList>
      </Container>
    </Wrapper>
  );
}

export default MainPage;

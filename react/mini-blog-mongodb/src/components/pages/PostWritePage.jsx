import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";

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
  gap: 10px;
`;

function PostWritePage() {
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  //게시글 작성 함수
  const handleSubmit = () => {
    if (!title || !content) {
      alert("제목과 내용을 입력해주세요.");
      return;
    }
    const newPost = {
      title,
      content,
      comments: [], //빈 배열
    };
    fetch("http://localhost:5000/posts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newPost), //stringify() : JS객체를 json형태의 문자열로 변환
    })
      .then((res) => res.json())
      .then((msg) => {
        console.log(msg);
        // 홈 페이지로 이동
        navigate("/");
      });
  };

  return (
    <Wrapper>
      <Container>
        <TextInput
          height={20}
          value={title}
          onChange={(event) => {
            setTitle(event.target.value);
          }}
        />
        <TextInput
          height={180}
          value={content}
          onChange={(event) => {
            setContent(event.target.value);
          }}
        />
        <Button title="글 작성하기" onClick={handleSubmit} />
      </Container>
    </Wrapper>
  );
}

export default PostWritePage;

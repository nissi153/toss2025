import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";

// 스타일 정의
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

  // 📌 게시글 작성 함수
  const handleSubmit = () => {
    if (!title || !content) {
      alert("제목과 내용을 입력해주세요.");
      return;
    }

    const newPost = {
      title,
      content,
      comments: [], // 초기 댓글 배열
    };

    fetch("http://localhost:5000/posts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newPost),
    })
      .then((res) => res.json())
      .then(() => {
        navigate("/"); // 게시글 작성 후 홈으로 이동
      })
      .catch((err) => console.error("Error creating post:", err));
  };

  return (
    <Wrapper>
      <Container>
        <TextInput
          height={20}
          placeholder="제목을 입력하세요"
          value={title}
          onChange={(event) => setTitle(event.target.value)}
        />
        <TextInput
          height={180}
          placeholder="내용을 입력하세요"
          value={content}
          onChange={(event) => setContent(event.target.value)}
        />
        <Button title="글 작성하기" onClick={handleSubmit} />
      </Container>
    </Wrapper>
  );
}

export default PostWritePage;

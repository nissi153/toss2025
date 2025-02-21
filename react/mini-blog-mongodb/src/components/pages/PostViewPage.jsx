import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
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

const PostContainer = styled.div`
  padding: 8px 16px;
  border: 1px solid grey;
  border-radius: 8px;
`;

const TitleText = styled.p`
  font-size: 20px;
  font-weight: 500;
`;

const ContentText = styled.p`
  font-size: 16px;
  line-height: 32px;
  white-space: pre-wrap;
`;

const CommentLabel = styled.p`
  font-size: 16px;
  font-weight: 500;
`;

const CommentContainer = styled.div`
  padding: 8px 16px;
  border: 1px solid #ddd;
  border-radius: 4px;
  margin-top: 8px;
`;

function PostViewPage(props) {
  const navigate = useNavigate();
  const { postId } = useParams();

  const [post, setPost] = useState(null);
  const [comment, setComment] = useState("");

  //백엔드에서 게시글 단건 조회하기
  useEffect(() => {
    fetch(`http://localhost:5000/posts/${postId}`)
      .then((res) => res.json())
      .then((data) => {
        if (data) {
          setPost(data);
        } else {
          console.error("Post not found");
        }
      });
  }, [postId]);

  //댓글 추가 함수
  const handleAddComment = () => {
    if (!comment) return;

    fetch(`http://localhost:5000/posts/${postId}/comments`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ content: comment }),
    })
      .then((res) => res.json())
      .then((updatedPost) => {
        setPost(updatedPost); //업데이트된 게시글 상태 반영
        setComment("");
      })
      .catch((err) => console.error("Error adding comment:", err));
  };

  //게시글 삭제하기
  const handleDeletePost = () => {
    fetch(`http://localhost:5000/posts/${postId}`, {
      method: "DELETE",
    })
      .then((res) => res.json())
      .then((msg) => {
        console.log(msg);
        navigate("/");
      })
      .catch((err) => console.error("Error deleting post", err));
  };

  if (!post) {
    console.log("포스트를 찾을 수 없습니다.");
    return <Wrapper>포스트를 찾을 수 없습니다.</Wrapper>;
  }

  return (
    <Wrapper>
      <Container>
        <Button
          title="뒤로 가기"
          onClick={() => {
            navigate("/");
          }}
        />

        <PostContainer>
          <TitleText>{post.title}</TitleText>
          <ContentText>{post.content}</ContentText>
        </PostContainer>

        {post.comments.length > 0 && <CommentLabel>댓글</CommentLabel>}
        {post.comments.map((comment) => (
          <CommentContainer key={comment._id}>
            <ContentText>{comment.content}</ContentText>
          </CommentContainer>
        ))}
        <TextInput
          height={40}
          value={comment}
          onChange={(event) => {
            setComment(event.target.value);
          }}
        />

        <Button title="댓글 작성하기" onClick={handleAddComment} />
        <Button title="포스트 삭제하기" onClick={handleDeletePost} />
      </Container>
    </Wrapper>
  );
}

export default PostViewPage;

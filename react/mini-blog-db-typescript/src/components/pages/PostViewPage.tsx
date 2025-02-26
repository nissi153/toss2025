import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import styled from "styled-components";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";

// 📌 게시글 및 댓글 타입 정의
interface Comment {
  _id: string;
  content: string;
}

interface Post {
  _id: string;
  title: string;
  content: string;
  comments: Comment[];
}

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

const PostViewPage: React.FC = () => {
  const navigate = useNavigate();
  const { postId } = useParams<{ postId: string }>();

  const [post, setPost] = useState<Post | null>(null);
  const [comment, setComment] = useState<string>("");

  // 📌 백엔드에서 게시글 정보 불러오기
  useEffect(() => {
    fetch(`http://localhost:5000/posts/${postId}`)
      .then((res) => res.json())
      .then((data: Post) => {
        if (data) {
          setPost(data);
        } else {
          console.error("Post not found");
        }
      })
      .catch((err) => console.error("Error fetching post:", err));
  }, [postId]);

  // 📌 댓글 추가 함수
  const handleAddComment = () => {
    if (!comment.trim()) return;

    fetch(`http://localhost:5000/posts/${postId}/comments`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ content: comment }),
    })
      .then((res) => res.json())
      .then((updatedPost: Post) => {
        setPost(updatedPost); // 업데이트된 게시글 상태 반영
        setComment("");
      })
      .catch((err) => console.error("Error adding comment:", err));
  };

  // 📌 게시글 삭제 함수
  const handleDeletePost = () => {
    fetch(`http://localhost:5000/posts/${postId}`, {
      method: "DELETE",
    })
      .then(() => {
        navigate("/"); // 삭제 후 메인 페이지로 이동
      })
      .catch((err) => console.error("Error deleting post:", err));
  };

  if (!post) {
    return <Wrapper>포스트를 찾을 수 없습니다.</Wrapper>;
  }

  return (
    <Wrapper>
      <Container>
        <Button title="뒤로 가기" onClick={() => navigate("/")} />

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
          onChange={(event) => setComment(event.target.value)}
        />

        <Button title="댓글 작성하기" onClick={handleAddComment} />
        <Button title="포스트 삭제하기" onClick={handleDeletePost} />
      </Container>
    </Wrapper>
  );
};

export default PostViewPage;

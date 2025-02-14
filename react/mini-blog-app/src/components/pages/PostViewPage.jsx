import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import styled from "styled-components";
import PostList from "../list/PostList";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";
import data from "../../../data.json";

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

  // const post = data.find((item) => {
  //   return item.id == postId;
  // });

  const [post, setPost] = useState(null);
  const [comment, setComment] = useState("");

  //useEffect : 컴퍼넌트 생명주기(Mount, Update)
  useEffect(() => {
    const storedPosts = JSON.parse(localStorage.getItem("posts")) || [];
    console.log("storedPosts:" + storedPosts);
    const foundPost = storedPosts.find((item) => item.id == postId);
    console.log("postId:" + postId);
    console.log("foundPost:" + foundPost);
    setPost(foundPost);
  }, [postId]);

  const handleAddComment = () => {
    if (!comment) return;

    const newComment = {
      id: Date.now().toString(),
      content: comment,
    };

    const updatedPost = {
      ...post,
      comments: [...post.comments, newComment],
    };

    const storedPosts = JSON.parse(localStorage.getItem("posts")) || [];
    const updatedPosts = storedPosts.map((item) =>
      //post목록에서 수정된 post아이템만 업데이트한다.
      item.id == postId ? updatedPost : item
    );

    localStorage.setItem("posts", JSON.stringify(updatedPosts));
    setPost(updatedPost);
    setComment("");
  };

  const handleDeletePost = () => {
    const storedPosts = JSON.parse(localStorage.getItem("posts")) || [];
    const updatedPosts = storedPosts.filter((item) => item.id != postId);

    localStorage.setItem("posts", JSON.stringify(updatedPosts));
    navigate("/");
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
          <CommentContainer key={comment.id}>
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

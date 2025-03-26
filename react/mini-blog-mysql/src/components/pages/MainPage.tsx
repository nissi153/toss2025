import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom' // 페이지 이동
import styled from 'styled-components'
import Button from '../ui/Button'
import PostList from '../list/PostList'

// 게시글 타입 정의
interface Post {
  post_no: number
  post_title: string
  post_content: string
}

// 모든 콘텐츠를 감싸는 최상위 DIV
const Wrapper = styled.div`
  padding: 16px;
  width: calc(100% - 32px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`

const Container = styled.div`
  width: 100%;
  max-width: 720px;
  display: flex;
  flex-direction: column;
`

const MainPage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]) // 게시글 목록 상태
  const navigate = useNavigate()

  // 백엔드에서 게시글 목록 가져오기
  useEffect(() => {
    fetch('http://localhost:5000/posts') // 백엔드 API 호출
      .then((res) => res.json())
      .then((data: Post[]) => setPosts(data)) // TypeScript에서 `data`의 타입을 `Post[]`로 명시
      .catch((err) => console.error('Error fetching posts:', err))
  }, [])

  return (
    <Wrapper>
      <Container>
        {/* 글 작성 페이지로 이동 */}
        <Button title="글 작성하기" onClick={() => navigate('/post-write')} />

        <div style={{ height: '10px' }}></div>

        {/* 게시글 리스트 출력 */}
        <PostList
          posts={posts}
          onClickItem={(item: Post) => navigate(`/post/${item.post_no}`)} //몽고DB의 _id 사용함.
        />
      </Container>
    </Wrapper>
  )
}

export default MainPage

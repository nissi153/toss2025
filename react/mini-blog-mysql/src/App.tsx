import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import styled from 'styled-components'

// Pages
import MainPage from './components/pages/MainPage'
import PostWritePage from './components/pages/PostWritePage'
import PostViewPage from './components/pages/PostViewPage'

const MainTitleText = styled.p`
  font-size: 24px;
  font-weight: bold;
  text-align: center;
`

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <MainTitleText>홍길동의 미니블로그</MainTitleText>
      <Routes>
        <Route index element={<MainPage />} />
        <Route path="post-write" element={<PostWritePage />} />
        <Route path="post/:postId" element={<PostViewPage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App

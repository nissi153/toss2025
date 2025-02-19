//ex13-parameter.js
//라우트(URL) 파라미터로 동적 URL 처리하기

const express = require('express')
const app = express()
const port = 3000

//인덱스 페이지
app.get('/', () => {})
//게시글 목록 조회
app.get('/posts', () => {})
//게시글 단건 조회
app.get('/posts/:id', () => {})
//게시글 추가
app.post('/posts', () => {})
//게시글 수정
app.put('/posts/:id', () => {})
//게시글 삭제
app.delete('/posts/:id', () => {})

app.listen(port, () => {
  console.log(`${port}번 포트에서 서버 실행 중...`)
})

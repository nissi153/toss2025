//ex12-routing.js
//라우팅(routing) : 경로 요청에 따른 처리하기

const express = require('express')
const app = express()
const port = 3000

//인덱스(루트,시작) 페이지 요청
//요청: localhost:3000/
app.get('/', (req, res) => {
  res.status(200)
  res.send('Hello Express~')
})
//요청: localhost:3000/login-form
app.get('/login-form', (req, res) => {
  res.status(200)
  res.send('로그인 페이지입니다.')
})
//요청: localhost:3000/login
app.get('/login', (req, res) => {
  res.status(200)
  res.send('로그인 성공했습니다.')
})
app.get('/join-form', () => {})
app.get('/join', () => {})
//요청: localhost:3000/posts
app.get('/posts', (req, res) => {
  res.status(200)
  res.send('게시글 목록입니다.')
})

app.listen(port, () => {
  console.log(`${port}번 포트에서 서버 실행 중...`)
})

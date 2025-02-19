//ex16-practice.js

//요청과 응답 연습문제 - DM제출
//1.
// ‘/users’ 경로로 요청할 때 사용자의 이름을 받아서(라우트 파라미터 사용)
// send()으로 ‘Hello, Hong!’문자열을 반환하는 API를 작성해 보세요.
const express = require('express')
const app = express()
const port = 3000

app.get('/users/:name', (req, res) => {
  res.status(200)
  const name = req.params.name
  res.send(`Hello, ${name}`)
})

//2.
// " /" 경로로 접속하면 send()로 "Welcome"을 반환하고
// "/about" 경로로 접속하면 "This is the about page."텍스트를 반환하는 라우트 작성하세요.
//http://localhost:3000/
app.get('/', (req, res) => {
  res.status(200)
  res.send('Welcome')
})
app.get('/about', (req, res) => {
  res.status(200)
  res.send('This is the about page.')
})

//3.
// 사용하여 사용자가 입력한 숫자를 받아 해당 숫자의 제곱을 반환하는 API를 작성하세요.
// (예) "/square/5" 경로로 접속하면 25를 반환합니다. (라우트 파라미터 사용)
//http://localhost:3000/square/9
app.get('/square/:number', (req, res) => {
  res.status(200)
  const number = req.params.number
  res.send(`${number ** 2}`)
})

// 서버 실행
app.listen(port, () => {
  console.log('Server is running on port 3000')
})

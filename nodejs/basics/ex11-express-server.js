//ex11-express-server.js
const express = require('express')
const app = express()
const PORT = 3000

//get메소드를 지원하는 서버를 생성
app.get('/', (req, res) => {
  res.status(200) //상태코드를 200(OK)으로 설정
  // res.send('Hello Express~')
  // res.send("{ 'email': 'abc@mail.com'  }")
  res.send('<!Doctype html><html></html>')
})

app.listen(PORT, () => {
  console.log(`${PORT}번 포트에서 서버 실행 중...`)
})

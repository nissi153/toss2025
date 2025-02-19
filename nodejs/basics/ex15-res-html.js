//ex15-res-html.js
//정적 HTML로 응답하기

const express = require('express')
const app = express()
const port = 3000

//assets/index.html
app.get('/', (req, res) => {
  res.status(200)
  res.sendFile(__dirname + '/assets/index.html')
})

app.listen(port, () => {
  console.log(`${port}번 포트에서 서버 실행 중...`)
})

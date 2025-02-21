//ex20-cookie.js

//웹 애플리케이션에서 사용자 인증하기

//HTTP 비연결지향 - 한번의 요청과 한번의 응답으로 끝남.

//1.쿠키 - 클라이언트(PC,Mobile)에 저장되는 임시데이터
//2.세션 - 서버에 저장되는 데이터(DB, 메모리)
//3.토큰 - 클라이언트와 서버에 저장되는 암호된 데이터

//쿠키파서, JWT(Json Web Token) 미들웨어 설치
//npm i cookie-parser jsonwebtoken

//쿠키 데이터 다루기
const express = require('express')
const cookieParser = require('cookie-parser')

const app = express()
app.use(cookieParser())

app.get('/', (req, res) => {
  // HTTP 응답 헤더의 set-cookie에 값을 넣어서 응답하면, 클라가 쿠키를 저장한다.
  // 클라는 서버에 재접속시 저장된 쿠키값을 헤더에 넣어서 온다.
  res.cookie('id-number', '1234')
  res.send('쿠키 생성했음.')
})

app.listen(5000, () => {
  console.log(`5000번 포트에서 서버 실행 중...`)
})

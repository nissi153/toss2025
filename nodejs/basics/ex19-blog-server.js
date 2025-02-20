// ex19-blog-server.js
// npm i mongoose cors : 몽고DB 연결 모듈, 크로스오리진 처리

const express = require('express')
const mongoose = require('mongoose')
const cors = require('cors')

const app = express()
const PORT = process.env.PORT || 5000

app.use(cors()) //모든 도메인(포트)의 요청을 허용(테스트서버용)
app.use(express.json())

// MongoDB Atlas 연결
const MONGO_URI =
  'mongodb+srv://admin:1234@mongodb-cluster.i7qod.mongodb.net/posts'
mongoose
  .connect(MONGO_URI)
  .then(() => console.log('MongoDB Connected'))
  .catch((err) => console.log(err))

// Mongoose 모델 정의
const PostSchema = new mongoose.Schema({
  title: String,
  content: String,
  comments: [{ content: String }],
})

//몽고DB 도큐먼트 객체
const Post = mongoose.model('Post', PostSchema)

// 게시글 목록 조회
// 게시글 단건 조회
// 게시글 추가
// 게시글 수정
// 게시글 삭제
// 댓글 추가

//서버 실행
app.listen(PORT, () => {
  console.log(`블로그 REST API 서버(${PORT}) 실행중...`)
})

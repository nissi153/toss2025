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
  'mongodb+srv://admin:1234@mongodb-cluster.i7qod.mongodb.net/blog'
mongoose
  .connect(MONGO_URI)
  .then(() => console.log('MongoDB Connected'))
  .catch((err) => console.log(err))

// Mongoose 모델 정의
const PostSchema = new mongoose.Schema(
  {
    title: String,
    content: String,
    comments: [{ content: String }],
  },
  { collection: 'posts' } // 컬렉션 이름 강제 지정
)

//몽고DB 도큐먼트 객체
//몽고DB에서는 모델 이름의 소문자+복수형(s)가 자동으로 컬렉션 이름이 됩니다.
const Post = mongoose.model('Post', PostSchema)

// 게시글 목록 조회
app.get('/posts', async (req, res) => {
  try {
    //select * from posts
    //posts 콜렉션의 모든 도큐먼트리스트를 가져온다.
    const posts = await Post.find()
    console.log(posts)
    res.json(posts)
  } catch (err) {
    res.status(500).json({ errer: err.message })
  }
})
// 게시글 단건 조회
app.get('/posts/:id', async (req, res) => {
  try {
    const post = await Post.findById(req.params.id)
    if (!post) {
      return res.status(404).json({ message: 'Post Not Found' })
    }
    res.status(200).json(post)
  } catch (err) {
    res.status(500).json({ errer: err.message })
  }
})
// 게시글 추가
// 게시글 수정
// 게시글 삭제
// 댓글 추가

//서버 실행
app.listen(PORT, () => {
  console.log(`블로그 REST API 서버(${PORT}) 실행중...`)
})

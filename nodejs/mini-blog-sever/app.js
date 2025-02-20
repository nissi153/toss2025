const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

const app = express();
const PORT = process.env.PORT || 5000;

// Middleware 설정
app.use(cors()); //모든 도메인에서 요청 허용(보안이 필요하지 않은 테스트 환경)
app.use(express.json());

// MongoDB Atlas 연결
const MONGO_URI = "mongodb+srv://admin:1234@cluster0.i7qod.mongodb.net/posts";
mongoose
  .connect(MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log("MongoDB Connected"))
  .catch((err) => console.log(err));

// Mongoose 모델 정의
const PostSchema = new mongoose.Schema({
  title: String,
  content: String,
  comments: [{ content: String }],
});

const Post = mongoose.model("Post", PostSchema);

// 📌 1. 게시글 목록 조회
app.get("/posts", async (req, res) => {
  try {
    const posts = await Post.find();
    res.json(posts);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 2. 특정 게시글 조회
app.get("/posts/:id", async (req, res) => {
  try {
    const post = await Post.findById(req.params.id);
    if (!post) return res.status(404).json({ message: "Post not found" });
    res.json(post);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 3. 새 게시글 작성
app.post("/posts", async (req, res) => {
  try {
    const { title, content } = req.body;
    const newPost = new Post({ title, content, comments: [] });
    await newPost.save();
    res.status(201).json(newPost);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 4. 게시글 수정
app.put("/posts/:id", async (req, res) => {
  try {
    const { title, content } = req.body;
    const updatedPost = await Post.findByIdAndUpdate(
      req.params.id,
      { title, content },
      { new: true } // 업데이트된 문서를 반환
    );
    if (!updatedPost)
      return res.status(404).json({ message: "Post not found" });
    res.json(updatedPost);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 4. 게시글 삭제
app.delete("/posts/:id", async (req, res) => {
  try {
    await Post.findByIdAndDelete(req.params.id);
    res.json({ message: "Post deleted" });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 5. 댓글 추가
app.post("/posts/:id/comments", async (req, res) => {
  try {
    const { content } = req.body;
    const post = await Post.findById(req.params.id);
    if (!post) return res.status(404).json({ message: "Post not found" });

    post.comments.push({ content });
    await post.save();
    res.json(post);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 서버 실행
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

const express = require("express");
const app = express();
const mysql = require("mysql2");
const cors = require("cors");

const PORT = process.env.PORT || 5000;

app.use(
  cors({
    origin: "*",
  })
);

// Middleware 설정
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

let conn = mysql
  .createConnection({
    host: "localhost",
    user: "root",
    password: "mysql123",
    database: "blog",
  })
  .promise();

conn.connect();

// 📌 1. 게시글 목록 조회
app.get("/posts", async (req, res) => {
  try {
    const [posts] = await conn.query("SELECT * FROM posts");
    res.json(posts);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 2. 특정 게시글 조회
app.get("/posts/:id", async (req, res) => {
  try {
    const [post] = await conn.query("SELECT * FROM posts WHERE post_no = ?", [
      req.params.id,
    ]);
    if (!post) return res.status(404).json({ message: "Post not found" });
    res.json(post[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 3. 새 게시글 작성
app.post("/posts", async (req, res) => {
  try {
    const { title, content } = req.body;
    const newPost = await conn.query(
      "INSERT INTO posts (post_no, post_title, post_content) VALUES (0, ?, ?)",
      [title, content]
    );
    res.status(201).json(newPost);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 4. 게시글 수정
app.put("/posts/:id", async (req, res) => {
  try {
    const { title, content } = req.body;
    const updatedPost = await conn.query(
      "UPDATE posts SET post_title = ?, post_content = ? WHERE post_no = ?",
      [title, content, req.params.id]
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
    await conn.query("DELETE FROM posts WHERE post_no = ?", [req.params.id]);
    res.json({ message: "Post deleted" });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 📌 5. 댓글 추가
app.post("/posts/:id/comments", async (req, res) => {
  try {
    const { content } = req.body;
    const [comment] = await conn.query(
      "INSERT INTO comments (comment_content, comment_post_no) VALUES (?, ?)",
      [content, req.params.id]
    );

    const newComment = {
      comment_no: comment.insertId,
      comment_content: content,
      comment_post_no: req.params.id,
    };
    res.json(newComment);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

app.get("/posts/:id/comments", async (req, res) => {
  try {
    const [comments] = await conn.query(
      "SELECT * FROM comments WHERE comment_post_no = ?",
      [req.params.id]
    );
    if (comments.length === 0)
      return res
        .status(404)
        .json({ message: "No comments found for this post" });
    res.json(comments);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 서버 실행
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

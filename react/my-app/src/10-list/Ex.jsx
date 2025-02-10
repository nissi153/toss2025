// Ex.jsx
// 연습문제 1: 조건부 렌더링과 키 사용
// 아래의 tasks 배열을 활용하여, 완료된 작업과 완료되지 않은 작업을 분리하여 렌더링하는 컴포넌트를 작성하세요.
// 요구사항
// 1. 완료된 작업은 <h3>완료된 작업</h3> 아래에 리스트로 렌더링합니다.
// 2. 완료되지 않은 작업은 <h3>할 일 목록</h3> 아래에 렌더링합니다.
// 3. filter()함수를 사용하여, tasks 배열을 2개 생성후 사용한다.

import React, { useEffect, useState } from "react";

export function TaskList() {
  const tasks = [
    { id: 1, text: "React 공부하기", completed: true },
    { id: 2, text: "운동하기", completed: false },
    { id: 3, text: "저녁 먹기", completed: false },
    { id: 4, text: "독서하기", completed: true },
  ];
  const completedTasks = tasks.filter((task) => task.completed);
  const incompleteTasks = tasks.filter((task) => !task.completed);

  return (
    <div>
      <h3>할 일 목록</h3>
      <ul>
        {incompleteTasks.map((task) => (
          <li key={task.id}>{task.text}</li>
        ))}
      </ul>

      <h3>완료된 작업</h3>
      <ul>
        {completedTasks.map((task) => (
          <li key={task.id}>{task.text}</li>
        ))}
      </ul>
    </div>
  );
}

//연습문제 2: 리스트 정렬과 키
// 아래의 products 배열을 가격 순으로 정렬하여 렌더링하는 컴포넌트를 작성하세요.
// 요구사항
// 1. 최저가부터 최고가 순으로 정렬하여 <ul>로 렌더링합니다.
// 2. 각 제품은 상품명 - 가격 형태로 표시합니다.
// 3. sort()함수를 사용합니다.

export function ProductList() {
  const products = [
    { id: 1, name: "Laptop", price: 1000 },
    { id: 2, name: "Phone", price: 600 },
    { id: 3, name: "Tablet", price: 800 },
  ];

  const sortedProducts = [...products].sort((a, b) => a.price - b.price);

  return (
    <div>
      <h3>제품 목록 (최저가 순)</h3>
      <ul>
        {sortedProducts.map((product) => (
          <li key={product.id}>
            {product.name} - {product.price}원
          </li>
        ))}
      </ul>
    </div>
  );
}

//연습문제 3: 입력 폼과 리스트 추가
// 사용자가 입력한 새로운 항목을 리스트에 추가하는 컴포넌트를 작성하세요.
// 요구사항
// 1. 초기 리스트는 빈 배열입니다.
// 2. 사용자가 입력하고 버튼을 누르면 입력한 항목이 리스트에 추가됩니다.
// 3. 각 리스트 항목은 고유한 키를 가져야 합니다.
export function DynamicList() {
  const [items, setItems] = useState([]);
  const [newItem, setNewItem] = useState("");

  const handleAddItem = () => {
    if (newItem.trim()) {
      setItems([...items, { id: items.length + 1, text: newItem }]);
      setNewItem("");
    }
  };

  return (
    <div>
      <h3>동적 리스트</h3>
      <input
        type="text"
        value={newItem}
        onChange={(e) => setNewItem(e.target.value)}
        placeholder="항목 입력"
      />
      <button onClick={handleAddItem}>추가하기</button>
      <ul>
        {items.map((item) => (
          <li key={item.id}>{item.text}</li>
        ))}
      </ul>
    </div>
  );
}

// 연습문제4: jsonplaceholder사이트의 JSON응답을 리스트로 출력하시오.
//URL : https://jsonplaceholder.typicode.com/posts
// 요구사항
// 1. React로 jsonplaceholder.typicode.com/posts API를 호출하여
//    id, title, body를 출력하는 간단한 리스트를 구성하세요.
// 2. useEffect와 fetch: API 호출을 처리합니다.
// 3. useState: 데이터를 저장합니다.
// 4. 데이터 로딩 중 상태와 오류 처리도 간단히 포함합니다.

export function PostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // API 호출
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setPosts(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error.message}</p>;
  }

  return (
    <div style={{ padding: "10px" }}>
      <h1>Posts</h1>
      <ul>
        {posts.map((post) => (
          <li
            key={post.id}
            style={{ borderBottom: "1px solid #ccc", padding: "10px 0" }}
          >
            <p>
              <strong>id:</strong> {post.id}
            </p>
            <p>
              <strong>User ID:</strong> {post.userId}
            </p>
            <p>
              <strong>Title:</strong> {post.title}
            </p>
            <p>
              <strong>Body:</strong> {post.body}
            </p>
          </li>
        ))}
      </ul>
    </div>
  );
}

//연습문제5
//연습문제4에서 가져온 posts에다가
// 입력 폼을 통해 새로운 post를 동적으로 추가하고 초기에는 10개의 post만 보여주는 리액트 컴포넌트를 작성했습니다.
// 요구사항
// 1. 처음에는 API로 가져온 10개의 post만 보여줍니다.
// 2. 사용자가 입력 폼에 id, User ID, Title, Body를 입력하고 제출하면 새로운 post가 동적으로 추가됩니다.

export function DynamicPostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [newPost, setNewPost] = useState({ userId: "", title: "", body: "" });

  // API 호출로 초기 10개 포스트 가져오기
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setPosts(data.slice(0, 10)); // 처음 10개만 설정
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, []);

  const handleChange = (e) => {
    // name : key이름
    // value : 실제 값
    const { name, value } = e.target;
    setNewPost((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleAddPost = (e) => {
    e.preventDefault();
    const nextPost = {
      id: posts.length + 1,
      userId: newPost.userId || "Unknown",
      title: newPost.title,
      body: newPost.body,
    };
    setPosts((prevPosts) => [...prevPosts, nextPost]);
    setNewPost({ userId: "", title: "", body: "" });
  };

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error.message}</p>;
  }

  return (
    <div>
      <h1>Posts</h1>
      <ul style={{ padding: "0", listStyleType: "none" }}>
        {posts.map((post) => (
          <li
            key={post.id}
            style={{
              marginBottom: "10px",
              borderBottom: "1px solid #ddd",
              paddingBottom: "10px",
            }}
          >
            <p>
              <strong>id:</strong> {post.id}
            </p>
            <p>
              <strong>userId:</strong> {post.userId}
            </p>
            <p>
              <strong>Title:</strong> {post.title}
            </p>
            <p>
              <strong>Body:</strong> {post.body}
            </p>
          </li>
        ))}
      </ul>

      {/* 입력 폼 */}
      <form onSubmit={handleAddPost} style={{ marginTop: "20px" }}>
        <h2>Add a New Post</h2>
        <div>
          <label>User ID: </label>
          <input
            type="text"
            name="userId"
            value={newPost.userId}
            onChange={handleChange}
            style={{ marginBottom: "10px", display: "block" }}
          />
        </div>
        <div>
          <label>Title: </label>
          <input
            type="text"
            name="title"
            value={newPost.title}
            onChange={handleChange}
            style={{ marginBottom: "10px", display: "block" }}
          />
        </div>
        <div>
          <label>Body: </label>
          <textarea
            name="body"
            value={newPost.body}
            onChange={handleChange}
            style={{
              marginBottom: "10px",
              display: "block",
              width: "100%",
              height: "50px",
            }}
          />
        </div>
        <button type="submit">Add Post</button>
      </form>
    </div>
  );
}

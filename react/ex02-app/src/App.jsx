import React from "react";

function App() {
  return (
    <div className="App">
      {/* 네비게이션 바 */}
      <div className="navbar bg-base-100">
        <div className="flex-1">
          <a className="btn btn-ghost normal-case text-xl">DaisyUI Navbar</a>
        </div>
        <div className="flex-none">
          <ul className="menu menu-horizontal p-0">
            <li>
              <a>홈</a>
            </li>
            <li>
              <a>소개</a>
            </li>
            <li>
              <a>연락처</a>
            </li>
          </ul>
        </div>
      </div>

      {/* 히어로 섹션 */}
      <div className="hero min-h-screen bg-base-200">
        <div className="hero-content text-center">
          <div className="max-w-md">
            <h1 className="text-5xl font-bold">Hello, DaisyUI!</h1>
            <p className="py-6">
              이것은 리액트에서 daisyUI를 활용한 예시 페이지입니다.
            </p>
            <button className="btn btn-primary">시작하기</button>
          </div>
        </div>
      </div>

      {/* 푸터 */}
      <footer className="footer items-center p-4 bg-neutral text-neutral-content">
        <div className="items-center grid-flow-col">
          {/* 필요에 따라 SVG 아이콘을 넣을 수 있습니다 */}
          <p>Copyright © 2025 - All rights reserved</p>
        </div>
      </footer>
    </div>
  );
}

export default App;

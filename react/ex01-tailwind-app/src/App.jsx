// App.js
import React from "react";
import Header from "./components/Header";
import Nav from "./components/Nav";
import Main from "./components/Main";
import Footer from "./components/Footer";

function App() {
  return (
    // body의 padding 20px (p-5 = 1.25rem = 약 20px)
    <div className="p-5">
      {/* #wrap: 가변 너비, 최소 760px, 최대 1080px, 중앙 정렬 */}
      <div id="wrap" className="w-full min-w-[760px] max-w-[1080px] mx-auto">
        <Header />
        <Nav />
        <Main />
        <Footer />
      </div>
    </div>
  );
}

export default App;

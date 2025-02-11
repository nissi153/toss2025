// App.jsx
import React from "react";
import Header from "./components/Header";
import Nav from "./components/Nav";
import Main from "./components/Main";
import Footer from "./components/Footer";

export default function App() {
  return (
    <div className="p-5">
      <div
        id="wrap"
        className="w-full min-w-[760px] max-w-[1080px] mx-auto bg-cyan-300"
      >
        <Header />
        <Nav />
        <Main />
        <Footer />
      </div>
    </div>
  );
}

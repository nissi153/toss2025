// App.jsx
import React from "react";
import Header from "./components/Header";
import Nav from "./components/Nav";
import Main from "./components/Main";
import Footer from "./components/Footer";

function App() {
  return (
    // p-6 : 1.25rem = 20px
    <div className="p-5">
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

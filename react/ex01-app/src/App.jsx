// App.jsx
import React from "react";
import Header from "./components/Header";
import Nav from "./components/Nav";
import Main from "./components/Main";
import Section from "./components/Section";
import Aside from "./components/Aside";
import Footer from "./components/Footer";

const App = () => {
  const appStyle = {
    padding: "20px",
  };

  const wrapStyle = {
    width: "100%",
    minWidth: "760px",
    maxWidth: "1080px",
    margin: "0 auto",
  };

  return (
    <div style={appStyle}>
      <div id="wrap" style={wrapStyle}>
        <Header />
        <Nav />
        <Main>
          <Section />
          <Aside />
        </Main>
        <Footer />
      </div>
    </div>
  );
};

export default App;

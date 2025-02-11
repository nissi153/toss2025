// components/Main.js
import React from "react";

import "../App.css";

const Main = ({ children }) => {
  const mainStyle = {
    backgroundColor: "darkcyan",
    height: "300px",
    // 내부에 Section과 Aside를 flex로 배치
    display: "flex",
    flexFlow: "row nowrap",
  };

  return (
    <div id="main" className="box" style={mainStyle}>
      {children}
    </div>
  );
};

export default Main;

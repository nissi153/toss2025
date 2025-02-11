// components/Header.js
import React from "react";
import "../App.css";

const Header = () => {
  const headerStyle = {
    backgroundColor: "purple",
    height: "50px",
  };

  return (
    <div id="header" className="box" style={headerStyle}>
      Header
    </div>
  );
};

export default Header;

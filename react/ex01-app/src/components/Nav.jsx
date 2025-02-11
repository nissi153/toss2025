// components/Nav.js
import React from "react";
import "../App.css";

const Nav = () => {
  const navStyle = {
    backgroundColor: "green",
    height: "50px",
  };

  return (
    <div id="nav" className="box" style={navStyle}>
      Nav
    </div>
  );
};

export default Nav;

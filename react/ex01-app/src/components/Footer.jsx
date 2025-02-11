// components/Footer.js
import React from "react";
import "../App.css";

const Footer = () => {
  const footerStyle = {
    backgroundColor: "darkolivegreen",
    height: "50px",
  };

  return (
    <div id="footer" className="box" style={footerStyle}>
      Footer
    </div>
  );
};

export default Footer;

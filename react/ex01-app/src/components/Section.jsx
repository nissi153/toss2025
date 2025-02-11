// components/Section.js
import React from "react";
import "../App.css";

const Section = () => {
  const sectionStyle = {
    backgroundColor: "darkcyan",
    height: "100%",
    flex: "2 1 auto", //grow shink basis
  };

  return (
    <div id="section" className="box" style={sectionStyle}>
      Section
    </div>
  );
};

export default Section;

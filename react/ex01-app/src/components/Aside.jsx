// components/Aside.js
import React from "react";
import "../App.css";

const Aside = () => {
  const asideStyle = {
    backgroundColor: "orange",
    height: "100%",
    flex: "1 1 auto", //grow shink basis
  };

  return (
    <div id="aside" className="box" style={asideStyle}>
      Aside
    </div>
  );
};

export default Aside;

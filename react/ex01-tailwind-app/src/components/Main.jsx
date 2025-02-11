// components/Main.js
import React from "react";
import Section from "./Section";
import Aside from "./Aside";

const Main = () => {
  return (
    <div
      id="main"
      className="border border-black text-white bg-[#008B8B] text-[22px] flex flex-row flex-nowrap justify-center items-center h-[300px]"
    >
      <Section />
      <Aside />
    </div>
  );
};

export default Main;

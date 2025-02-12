import Nav from "./Nav.jsx";

export default function SiteHeader() {
  return (
    <div className="bg-[#ffffff] flex flex-row grow basis-full justify-between h-[60px] leading-[60px] shadow-md">
      <div className="text-[24px] text-[#2664eb] font-bold px-[20px] flex">
        TechStore
      </div>
      <Nav />
    </div>
  );
}

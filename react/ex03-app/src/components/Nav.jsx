import "../index.css";

export default function Nav() {
  return (
    <div className="flex max-sm:hidden">
      <ul className="flex flex-row">
        <li className="group menuLi">
          <a href="#">제품</a>
          <ul className="submenu">
            <li className="submenuLi">
              <a href="#">전자기기</a>
            </li>
            <li className="submenuLi">
              <a href="#">의류</a>
            </li>
            <li className="submenuLi">
              <a href="#">도서</a>
            </li>
            <li className="submenuLi">
              <a href="#">액세사리</a>
            </li>
          </ul>
        </li>
        <li className="group menuLi">
          <a href="#">서비스</a>
          <ul className="submenu">
            <li className="submenuLi">
              <a href="#">컨설팅</a>
            </li>
            <li className="submenuLi">
              <a href="#">교육</a>
            </li>
            <li className="submenuLi">
              <a href="#">고객지원</a>
            </li>
            <li className="submenuLi">
              <a href="#">유지보수</a>
            </li>
          </ul>
        </li>
        <li className="group menuLi">
          <a href="#">회사소개</a>
          <ul className="submenu">
            <li className="submenuLi">
              <a href="#">회사정보</a>
            </li>
            <li className="submenuLi">
              <a href="#">팀 소개</a>
            </li>
            <li className="submenuLi">
              <a href="#">채용정보</a>
            </li>
            <li className="submenuLi">
              <a href="#">연락처</a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  );
}

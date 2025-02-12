import "./movieStyle.css";

const UtilHeader = () => {
  return (
    <div className="util_header">
      <div className="util_div1">
        <div className="util_btn">VIP LOUNGE</div>
        <div className="util_btn">멤버십</div>
        <div className="util_btn">고객센터</div>
      </div>
      <div className="util_div2">
        <div className="util_btn">로그인</div>
        <div className="util_btn">회원가입</div>
        <div className="util_btn">빠른예매</div>
      </div>
    </div>
  );
};

const Header = () => {
  return (
    <div className="header">
      <UtilHeader />
      <div className="main_header">
        <div className="icons">
          <img src="https://img.megabox.co.kr/static/pc/images/common/ico/ico-sitemap.png" alt="" />
          <img src="https://img.megabox.co.kr/static/pc/images/common/ico/ico-search.png" alt="" />
        </div>
        <div className="header_btn">
          영화
          <div className="hidden_menu">
            <ul className="menulist">
              <li className="menu_li">전체영화</li>
            </ul>
          </div>
        </div>

        <div className="header_btn">
          예매
          <div className="hidden_menu">
            <ul className="menulist">
              <li className="menu_li">빠른예매</li>
              <li className="menu_li">상영시간표</li>
              <li className="menu_li">더 부티크 프라이빗 예매</li>
            </ul>
          </div>
        </div>
        <div className="header_btn">
          극장
          <div className="hidden_menu">
            <ul className="menulist">
              <li className="menu_li">전체극장</li>
              <li className="menu_li">특별관</li>
            </ul>
          </div>
        </div>
        <div className="logo"></div>
        <div className="header_btn">이벤트</div>
        <div className="header_btn">스토어</div>
        <div className="header_btn">혜택</div>
        <div className="icons">
          <img src="https://img.megabox.co.kr/static/pc/images/common/ico/ico-schedule.png" alt="" />
          <img src="https://img.megabox.co.kr/static/pc/images/common/ico/ico-mymega.png" alt="" />
        </div>
      </div>
    </div>
  );
};

export default Header;

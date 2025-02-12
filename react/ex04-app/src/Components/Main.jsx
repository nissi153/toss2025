import "./movieStyle.css";
import MovieList from "./MovieList";

const Main = () => {
  const movieTitles = [
    "캡틴 아메리카: 브레이브 뉴 월드",
    "말할 수 없는 비밀",
    "미드나잇 인 파리",
    "히트맨2",
    "[아카데미] 플로우",
    "러브레터",
    "[아카데미] 콘클라베",
    "브로큰",
    "서브스턴스",
    "검은 수녀들",
    "브루탈리스트",
    "퇴마록",
  ];
  return (
    <div className="main">
      <div className="main_title">전체영화</div>
      <ul id="movie_menu">
        <li className="menu_selected">박스오피스</li>
        <li className="menu_select">상영예정작</li>
        <li className="menu_select">단독</li>
        <li className="menu_select">필름소사이어티</li>
        <li className="menu_select">클래식소사이어티</li>
      </ul>
      <div className="headline">
        <div className="left_zone">
          <div style={{ width: "100px" }}>
            <div className="onair"></div>
            <div>개봉작만</div>
          </div>
          <p>
            <span>88</span>개의 영화가 검색되었습니다.
          </p>
        </div>
        <div className="search">
          <input type="text" placeholder="영화명 검색" />
          <img src="https://img.megabox.co.kr/static/pc/images/common/btn/btn-search-input.png" alt="" />
        </div>
      </div>
      <div className="movie_list">
        {movieTitles.map((t, idx) => (
          <MovieList key={idx} title={t} />
        ))}
      </div>
    </div>
  );
};

export default Main;

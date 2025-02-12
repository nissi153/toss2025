const MovieList = (props) => {
  return (
    <div className="movie_info">
      <div className="img_area">
        <p className="rank">1</p>
        <img
          className="poster"
          src="https://img.megabox.co.kr/SharedImg/2025/01/06/veoYkRw8THPbrE9FobWUP1BVmEbMOXnp_420.jpg"
          alt="말할 수 없는 비밀"
        />
      </div>
      <div className="info_area" style={{ margin: "15px 0" }}>
        <div className="grade"></div>
        <div style={{ fontSize: "20px" }}>{props.title}</div>
      </div>
      <div className="info_area" style={{ fontSize: "15px", margin: "10px 0" }}>
        <div>예매율 34.8%</div>
        <div className="open_date">개봉일 2025.01.28</div>
      </div>
      <div className="info_area" style={{ justifyContent: "space-between" }}>
        <button className="white_btn">
          <div className="heart"></div>
          654
        </button>
        <button className="purple_btn">예매</button>
        <button className="purple_btn">
          <img
            style={{ marginTop: "2px" }}
            src="https://www.megabox.co.kr/static/pc/images/common/btn/mov_list_db_btn.png"
            alt="dolby 버튼"
          />
        </button>
      </div>
    </div>
  );
};

export default MovieList;

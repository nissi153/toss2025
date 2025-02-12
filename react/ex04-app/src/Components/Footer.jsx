import "./movieStyle.css";

const Footer = () => {
  const footerMenu = [
    "회사소개",
    "인재채용",
    "사회공헌",
    "제휴/광고/부대사업문의",
    "이용약관",
    "위치기반서비스 이용약관",
    "개인정보처리방침",
    "윤리경영",
  ];
  return (
    <div style={{ backgroundColor: "#eeeeee", height: "200px", fontSize: "14px" }}>
      <div>
        <div style={{ padding: "30px 0px 30px 100px" }}>
          <ul style={{ display: "flex", width: "90%" }}>
            {footerMenu.map((m) => (
              <li key={m} style={{ marginRight: "20px" }}>
                {m}
              </li>
            ))}
          </ul>
        </div>
      </div>
      <div style={{ marginLeft: "100px" }}>
        <div style={{ display: "flex" }}>
          <div
            style={{
              width: "200px",
              background:
                "url(https://img.megabox.co.kr/static/pc/images/common/ci/logo-opacity_new2.png) no-repeat center",
            }}
          ></div>

          <div className="footer-info">
            <div>
              <address>서울특별시 강남구 테헤란로 87길 22 도심공항터미널 건물 408호</address>
              <p>ARS 1544-0070 대표이메일 m.dreamcenter@partner.megabox.co.kr</p>
            </div>
            <p>대표자명 홍정인, 남용석</p>
            <p>· 개인정보보호책임자 강병철</p>
            <p>· 사업자등록번호 211-86-59478</p>
            <p>· 통신판매업신고번호 2023-서울성동-0177</p>
            <p>COPYRIGHT © MegaboxJoongAng, Inc. All rights reserved</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Footer;

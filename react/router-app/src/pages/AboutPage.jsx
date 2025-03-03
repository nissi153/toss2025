import { useNavigate } from "react-router-dom";

function AboutPage() {
  const navigate = useNavigate();

  const gotoBack = () => {
    navigate(-1);
  };

  return (
    <div>
      <h1>소개 페이지</h1>
      <p>이곳은 소개 페이지입니다.</p>
      <button onClick={gotoBack}>뒤로 이동</button>
    </div>
  );
}

export default AboutPage;

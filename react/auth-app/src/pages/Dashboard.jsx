import { useAuth } from "../components/AuthProvider";
import { useNavigate } from "react-router-dom";
//npm i react-router-dom

const Dashboard = () => {
  const { currentUser, logout } = useAuth();
  const navigate = useNavigate();

  return (
    <div>
      <h2>대시보드</h2>
      {currentUser ? (
        <div>
          <p>환영합니다. {currentUser.email}님!</p>
          <button
            onClick={() => {
              logout();
              // navigate("/");
            }}
          >
            로그아웃
          </button>
        </div>
      ) : (
        <div>
          <button onClick={() => navigate("/signup")}>회원가입</button>
          &nbsp;
          <button onClick={() => navigate("/login")}>로그인</button>
        </div>
      )}
    </div>
  );
};

export default Dashboard;

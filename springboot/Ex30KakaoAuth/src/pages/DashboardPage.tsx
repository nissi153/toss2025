import React from "react";
import { useAuth } from "../contexts/AuthContext";
import { useNavigate } from "react-router-dom";
import "./DashboardPage.css";

const DashboardPage: React.FC = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <div className="dashboard-page">
      <div className="dashboard-container">
        <h1>대시보드</h1>

        <div className="user-profile">
          {user?.profileImage && (
            <img
              src={user.profileImage}
              alt="프로필"
              className="profile-image"
            />
          )}
          <div className="user-info">
            <h2>{user?.name}</h2>
            <p>{user?.email}</p>
          </div>
        </div>

        <div className="dashboard-content">
          <h3>로그인 성공!</h3>
          <p>카카오 계정으로 로그인되었습니다.</p>
        </div>

        <button onClick={handleLogout} className="logout-button">
          로그아웃
        </button>
      </div>
    </div>
  );
};

export default DashboardPage;

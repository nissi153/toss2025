import React from "react";
import KakaoLogin from "../components/KakaoLogin";
import "./LoginPage.css";

const LoginPage: React.FC = () => {
  return (
    <div className="login-page">
      <div className="login-container">
        <h1>로그인</h1>
        <p>카카오톡 계정으로 간편하게 로그인하세요.</p>
        <div className="login-divider">
          <span>소셜 로그인</span>
        </div>
        <KakaoLogin />
      </div>
    </div>
  );
};

export default LoginPage;

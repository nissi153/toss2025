import React from "react";
import "./KakaoLogin.css";

const KakaoLogin: React.FC = () => {
  const handleLogin = () => {
    const KAKAO_REST_API_KEY = import.meta.env.VITE_KAKAO_REST_API_KEY;
    const REDIRECT_URI = import.meta.env.VITE_REDIRECT_URI;

    const kakaoAuthUrl = `https://kauth.kakao.com/oauth/authorize?client_id=${KAKAO_REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;

    window.location.href = kakaoAuthUrl;
  };

  return (
    <button onClick={handleLogin} className="kakao-login-btn">
      카카오톡으로 로그인하기
    </button>
  );
};

export default KakaoLogin;

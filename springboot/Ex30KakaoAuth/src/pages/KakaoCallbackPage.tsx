import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { apiService } from "../services/api";
import "./KakaoCallbackPage.css";

const KakaoCallbackPage: React.FC = () => {
  const [error, setError] = useState<string | null>(null);
  const navigate = useNavigate();
  const { login } = useAuth();

  useEffect(() => {
    // URL에서 인가 코드 추출
    const code = new URL(window.location.href).searchParams.get("code");

    if (!code) {
      setError("인가 코드를 찾을 수 없습니다.");
      return;
    }

    const processKakaoLogin = async () => {
      try {
        // 백엔드에 인가 코드 전송하여 JWT 토큰 발급
        const authResponse = await apiService.kakaoLogin(code);

        // JWT 토큰 및 사용자 정보 저장
        login(authResponse.token, authResponse.refreshToken, authResponse.user);

        // 메인 페이지로 리다이렉트
        navigate("/dashboard");
      } catch (error) {
        console.error("카카오 로그인 처리 중 오류 발생:", error);
        setError("로그인 처리 중 오류가 발생했습니다.");
      }
    };

    processKakaoLogin();
  }, [login, navigate]);

  return (
    <div className="callback-page">
      {error ? (
        <div className="error-container">
          <h2>오류 발생</h2>
          <p>{error}</p>
          <button onClick={() => navigate("/login")}>
            로그인 페이지로 돌아가기
          </button>
        </div>
      ) : (
        <div className="loading-container">
          <div className="spinner"></div>
          <p>로그인 처리 중입니다...</p>
        </div>
      )}
    </div>
  );
};

export default KakaoCallbackPage;

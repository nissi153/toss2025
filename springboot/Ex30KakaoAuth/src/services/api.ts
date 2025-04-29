import { AuthResponse, User } from "../types";

const API_BASE_URL =
  import.meta.env.VITE_BACKEND_URL || "http://localhost:8080/api";

class ApiService {
  private kakaoLoginPromise: Promise<AuthResponse> | null = null;

  // 카카오 로그인 인가 코드로 JWT 토큰 요청
  async kakaoLogin(code: string): Promise<AuthResponse> {
    // 이미 진행 중인 요청이 있다면 해당 Promise를 반환
    if (this.kakaoLoginPromise) {
      return this.kakaoLoginPromise;
    }

    // 새로운 요청 생성
    this.kakaoLoginPromise = (async () => {
      try {
        const response = await fetch(`${API_BASE_URL}/auth/kakao/callback`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ code }),
        });

        if (!response.ok) {
          throw new Error("카카오 로그인 처리 중 오류가 발생했습니다.");
        }

        return response.json();
      } finally {
        // 요청이 완료되면 Promise 초기화
        this.kakaoLoginPromise = null;
      }
    })();

    return this.kakaoLoginPromise;
  }

  // JWT 토큰으로 현재 사용자 정보 요청
  async getCurrentUser(): Promise<User> {
    const token = localStorage.getItem("token");

    if (!token) {
      throw new Error("로그인이 필요합니다.");
    }

    const response = await fetch(`${API_BASE_URL}/auth/me`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    if (!response.ok) {
      throw new Error("사용자 정보를 불러오는 중 오류가 발생했습니다.");
    }

    return response.json();
  }

  // 토큰 갱신
  async refreshToken(refreshToken: string): Promise<AuthResponse> {
    const response = await fetch(`${API_BASE_URL}/auth/refresh`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ refreshToken }),
    });

    if (!response.ok) {
      throw new Error("토큰 갱신 중 오류가 발생했습니다.");
    }

    return response.json();
  }

  // 토큰 유효성 검증
  async validateToken(token: string): Promise<boolean> {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/validate`, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      if (!response.ok) {
        return false;
      }

      const data = await response.json();
      return data.valid;
    } catch (error) {
      return false;
    }
  }
}

export const apiService = new ApiService();

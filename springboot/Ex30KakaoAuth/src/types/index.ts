export interface User {
  id: number;
  name: string;
  email: string;
  profileImage: string;
}

export interface AuthResponse {
  token: string;
  refreshToken: string;
  user: User;
}

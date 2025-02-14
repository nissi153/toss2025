import { createContext, useContext, useState } from "react";

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const preset = [{ email: "hong@mail.com", password: "1234" }];
  const [users, setUsers] = useState(preset); //사용자 목록
  const [currentUser, setCurrentUser] = useState(null); //현재 로그인된 사용자

  const signup = (email, password) => {
    if (users.find((user) => user.email === email)) {
      return { error: "이미 가입된 이메일입니다." };
    }
    const newUser = { email, password };
    setUsers([...users, newUser]);
    return { success: true };
  };
  const login = (email, password) => {
    const user = users.find(
      (user) => user.email === email && user.password === password
    );
    if (!user) {
      return { error: "이메일 또는 비밀번호가 올바르지 않습니다." };
    }
    setCurrentUser(user);
    return { success: true };
  };
  const logout = () => {
    setCurrentUser(null);
  };

  return (
    <AuthContext.Provider value={{ users, currentUser, signup, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

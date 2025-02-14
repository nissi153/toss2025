import { useState, useEffect } from "react";
import { useAuth } from "../components/AuthProvider";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const { signup, login } = useAuth();
  const navigate = useNavigate();

  //회원가입 액션
  const handleSignup = () => {
    const result = signup(email, password);
    if (result.error) {
      //회원가입 실패
      setError(result.error); //에러 출력
    } else {
      //회원가입 성공
      navigate("/login"); //로그인 화면으로 이동

      //자동 로그인
      // login(email, password);
      // navigate("/");
    }
  };

  return (
    <div>
      <h2>회원가입</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <input
        type="email"
        placeholder="이메일"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br />
      <input
        type="password"
        placeholder="비밀번호"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />
      <button onClick={handleSignup}>가입하기</button>
    </div>
  );
};

export default Signup;

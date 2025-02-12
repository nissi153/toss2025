import { useContext } from "react";
import ThemeContext from "./ThemeContext";

function ThemeContextUseContext(props) {
  //전역상태관리에 저장된 theme(테마)값을 가져온다.
  const { theme, toggleTheme } = useContext(ThemeContext);

  const styles = {
    width: "100vw",
    height: "100vh",
    padding: "1.5rem",
    backgroundColor: theme == "light" ? "white" : "black",
    color: theme == "light" ? "black" : "white",
  };
  return (
    <div style={styles}>
      <p>안녕하세요. 테마 변경이 가능한 웹사이트입니다.</p>
      <button onClick={toggleTheme}>테마 변경</button>
    </div>
  );
}

export default ThemeContextUseContext;

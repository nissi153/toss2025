import ThemeContext from "./ThemeContext";

function ThemeContextConsumer(props) {
  return (
    <ThemeContext.Consumer>
      {({ theme, toggleTheme }) => {
        const styles = {
          width: "100vw",
          height: "100vh",
          padding: "1.5rem",
          backgroundColor: theme === "light" ? "white" : "black",
          color: theme === "light" ? "black" : "white",
        };

        return (
          <div style={styles}>
            <p>안녕하세요. 테마 변경이 가능한 웹사이트입니다.</p>
            <button onClick={toggleTheme}>테마 변경</button>
          </div>
        );
      }}
    </ThemeContext.Consumer>
  );
}

export default ThemeContextConsumer;

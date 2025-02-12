import { useState, useCallback } from "react";
import ThemeContext from "./ThemeContext";
import ThemeContextUseContext from "./ThemeContextUseContext";

function ThemeContextProvider({ initTheme }) {
  const [theme, setTheme] = useState(initTheme);

  //useMemo : 값이 저장해 놓음.
  //useCallback : 함수을 저장해 놓음.
  const toggleTheme = useCallback(() => {
    if (theme == "light") {
      setTheme("dark");
    } else {
      setTheme("light");
    }
  }, [theme]);

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      <ThemeContextUseContext />
    </ThemeContext.Provider>
  );
}

export default ThemeContextProvider;

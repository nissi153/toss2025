import React from "react";

// Props Drilling(프롭스 드릴링)은 React와 같은 컴포넌트 기반 라이브러리에서
// 상위 컴포넌트의 데이터를 여러 중간 컴포넌트를 거쳐
// 최종적으로 필요한 하위 컴포넌트에 전달하는 과정을 말합니다.
// 예를 들어, 최상위 컴포넌트에서 데이터를 가지고 있다가,
// 그 데이터를 바로 사용하지 않는 중간 컴포넌트들을 통해
// 아주 깊은 곳에 있는 컴포넌트로 전달해야 할 때 프롭스 드릴링이 발생합니다.

// 이 방식은 컴포넌트 구조가 단순할 때는 큰 문제가 없지만,
// 컴포넌트 계층이 복잡해지면 다음과 같은 문제점이 있습니다:
// 1.불필요한 props 전달:
// 2.유지보수 어려움:
// 3.재사용성 저하:

// 이러한 문제를 해결하기 위해 React에서는 Context API를 사용하거나,
// Redux, Zustand와 같은 전역 상태 관리 도구를 도입하여
// 컴포넌트 계층 구조의 복잡도를 줄이는 방법을 활용할 수 있습니다.

// 전역 상태 변수 예) 테마, 로그인 여부, 사용자프로필

function GrandComponent({ theme, toggleTheme }) {
  const styles = {
    width: "100vw",
    height: "100vh",
    padding: "1.5rem",
    backgroundColor: theme === "light" ? "white" : "black",
    color: theme === "light" ? "black" : "white",
  };

  return (
    <div style={styles}>
      <p>안녕하세요 {user.name}님, 테마 변경이 가능한 웹사이트입니다.</p>
      <button onClick={toggleTheme}>테마 변경</button>
    </div>
  );
}

function ChildComponent({ theme, toggleTheme }) {
  return <GrandComponent theme={theme} toggleTheme={toggleTheme} />;
}

function MainComponent({ theme, toggleTheme, user, logout }) {
  return <ChildComponent theme={theme} toggleTheme={toggleTheme} />;
}

function PropsDrilling() {
  const themeState = {
    theme: "light",
    toggleTheme: () => console.log("테마 변경 호출됨"),
  };

  return (
    <MainComponent
      theme={themeState.theme}
      toggleTheme={themeState.toggleTheme}
    />
  );
}

export default PropsDrilling;

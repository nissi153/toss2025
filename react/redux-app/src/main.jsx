// main.jsx: 애플리케이션의 진입점입니다.
import React from "react";
import ReactDOM from "react-dom/client";
import { Provider } from "react-redux"; // Redux의 Provider로 앱 전체를 감싸 Redux Store를 제공합니다.
import store from "./store"; // Redux Store를 가져옵니다.
import App from "./App";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  // Provider로 감싸야 useSelector와 useDispatch가 정상적으로 작동합니다.
  <Provider store={store}>
    <App />
  </Provider>
);

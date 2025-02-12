// store.js: Redux Store와 Reducer 설정
import { createStore } from "redux";

// 초기 상태 정의
const initialState = {
  count: 0, // 카운터의 초기값은 0입니다.
};

// Reducer 함수: 상태를 업데이트하는 로직을 정의합니다.
const counterReducer = (state = initialState, action) => {
  switch (action.type) {
    case "INCREMENT": // INCREMENT 액션일 때
      return { ...state, count: state.count + 1 }; // count를 1 증가시킵니다.
    case "DECREMENT": // DECREMENT 액션일 때
      return { ...state, count: state.count - 1 }; // count를 1 감소시킵니다.
    default: // 다른 액션일 경우 현재 상태를 그대로 반환합니다.
      return state;
  }
};

// Store 생성: Redux의 createStore 함수로 Store를 생성합니다.
const store = createStore(counterReducer);

export default store;

//자바스크립트에서 비동기 처리를 하는 3가지 방법

//비동기 처리 : 코드 선언 시점과 코드 실행 시점이 다른 것
//  UI(사용자의 액션-버튼,스크롤)처리, HTTP통신 - 요청과 응답은 비동기이다.
//동기 처리 : 실행시 응답을 기다리면서 Blocking현상이 발생한다.

//1. 콜백함수 - 함수안에서 다른 함수를 매개변수로 넘기고 실행순서를 제어한다.
//             복잡하고 가독성 저하.
//2. 프라미스(Promise) - ES6(2015) - 프라미스 객체과 콜백함수를 사용한다.
//3. async/await - ES 2017 - async와 await 예약어를 통해서 구현한다.

//HTTP통신를 하는 JS의 3가지 방법
//1. jquery.js의 ajax()함수
//2. JS에서 지원하는 fetch()함수 - ES2015(ES6)부터 지원
//3. axios 모듈의 axios()함수

//콜백함수란? 다른 함수의 매개변수로 사용되는 함수를 말한다.

//커피주문을 할때 주문접수 3초 후에 완료 메시지 표시하기
const order = (coffee, callback) => {
  console.log(`${coffee} 주문 접수`)
  setTimeout(() => {
    callback(coffee)
  }, 3000)
}
const display = (result) => {
  console.log(`${result} 완료`)
}
order('아메리카노', display)

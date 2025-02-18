//npm : node package manager
//  자바스크립트 라이브러리를 비롯해 프레임워크, 플러그인 등
//  다양한 패키지를 내려받아 사용할 수 있도록 해주는 관리 프로그램이다.
//www.npmjs.com

//1.npm 초기화
// npm init
//package.json 파일 생김 - 사용하는 모듈이나 패키지 및 버전 등의 정보가 담겨있다.

//2.ansi-colors 모듈 설치
// npm i ansi-colors

//모듈 : node.js에서 '필요한 함수들의 집합'을 의미함.

//3. 설치한 모듈 사용하기

// * 문장 끝에 세미콜론 생략 가능(줄바꿈을 잘해야 된다.)
// * 단따옴표를 기본으로 설정
const c = require('ansi-colors')

function hello(name) {
  console.log(c.green(name) + '님 환영합니다.')
}

hello('강감찬')

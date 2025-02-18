//ex08-globalmodule.js

//글로벌 모듈
//require 함수 없이 그대로 사용할 수 있는 모듈

//console모듈
global.console.log('콘솔입니다.')
console.log('콘솔입니다.2')

//글로벌 모듈에 있는 여러 변수 중에서 자주 사용하는
//__dirname와 __filename 변수

console.log(`현재 모듈이 있는 폴더:${__dirname}`)
console.log(`현재 모듈의 파일명:${__filename}`)

//ex06.ts

//unknown 타입 : 모든 타입의 수퍼셋(모집합)

let unknownVar: unknown

//모든 타입의 값이 들어갈 수 있다.
unknownVar = 123
unknownVar = 'hong'
unknownVar = () => {}

unknownVar = 123
let num: number
// 타입좁히기
if (typeof unknownVar == 'number') {
  num = unknownVar
}

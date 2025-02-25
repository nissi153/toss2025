//ex08.ts
//타입 단언(Assertion) : 형변환과 유사

type Person = {
  name: string
  age: number
}

// 값 as 타입
let person = {} as Person //형 단언(확정) or 변환
person.name
person.age

type Dog = {
  name: string
  color: string
}
let dog = {
  name: '멍멍이',
  color: '흰색',
  town: '서울',
} as Dog

// const 선언 (읽기전용)
let cat = {
  name: '야옹이',
  color: 'brown',
} as const
cat.name = '길야옹이'

type Post = {
  title: string
  content?: string //없을수도 있다.
}
let post: Post = {
  title: '글내용',
}
//Cannot read properties of undefined (reading 'length')
//? : 옵셔널(null일수도) undefined
//! : Not Null 단언 - 개발자가 null이 아님을 확신하고 쓰는 것.
const len: number = post.content!.length
console.log(len)

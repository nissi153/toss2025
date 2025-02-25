//ex07.ts

//합집합 타입 - Union
let a: string | number | boolean
a = 123
a = 'hong'
a = true

let arr: (string | number | boolean)[] = [123, 'hong', true]

//객체 타입
type Dog = {
  name: string
  color: string
}
type Person = {
  name: string
  lang: string
}
type Union1 = Dog | Person
let union1: Union1 = {
  name: '',
  color: '',
}
let union2: Union1 = {
  name: '',
  lang: '',
}
let union3: Union1 = {
  name: '',
  color: '',
  lang: '',
}
let union4: Union1 = {
  name: '',
}

//교집합 타입 - Intersection

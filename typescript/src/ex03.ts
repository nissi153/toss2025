//ex03.ts

//객체 타입
let user1: object = { 
  id: 1,
  name: '홍길동'
}
//'object' 형식에 'id' 속성이 없습니다.
user1.id

//객체 리터럴 타입
let user2: {
  id: number,
  name: string
} = { 
  id: 1,
  name: '홍길동'
}
//(property) id: number
user2.id

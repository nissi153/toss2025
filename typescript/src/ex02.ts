//ex02.ts

//배열 타입
let numArr: number[] = [1, 2, 3]
let strArr: string[] = ['hello', 'typescript']
let boolArr: Array<boolean> = [true, false]

// 배열에 들어가는 요소들의 타입이 다른 경우
// 유니언(|) : 타입의 합집합
let multiArr: ( number | string )[] = [1, 'hello']

let doubleArr: number[][] = [[1,2,3],[4,5]]

//튜플 : 타입스크립트에만 존재
// 길이와 타입이 고정된 배열
let tup1: [number, number] = [1, 2]
let tup2: [number, string, boolean] = [1, 'string', true]

//사용예
//길이와 타입을 고정시킬때
const users: [string, number][] = [
  ['홍길동', 20],
  ['사임당', 30]
]
users.push(['변사또', 40])
users.push([50, '이순신']) //타입이 다름
users.push(['강감찬', 60, true]) //길이가 다름

const [count, setCount] = useState(0)
function useState(init: number) {
  return [0, ()=>{}]
}
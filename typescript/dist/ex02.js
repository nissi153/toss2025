//ex02.ts
//배열 타입
let numArr = [1, 2, 3];
let strArr = ['hello', 'typescript'];
let boolArr = [true, false];
// 배열에 들어가는 요소들의 타입이 다른 경우
// 유니언(|) : 타입의 합집합
let multiArr = [1, 'hello'];
let doubleArr = [
    [1, 2, 3],
    [4, 5],
];
//튜플 : 타입스크립트에만 존재
// 길이와 타입이 고정된 배열
let tup1 = [1, 2];
let tup2 = [1, 'string', true];
//사용예
//길이와 타입을 고정시킬때
const users = [
    ['홍길동', 20],
    ['사임당', 30],
];
users.push(['변사또', 40]);
users.push([50, '이순신']); //타입이 다름
users.push(['강감찬', 60, true]); //길이가 다름
//함수는 하나의 값만 반환하는데
//두개이상의 값을 반환할때 튜플이나 배열을 사용.
const [count, setCount] = useState(0);
function useState(init) {
    return [0, () => { }];
}
export {};

//ex03.ts
//객체 타입
let user1 = {
    id: 1,
    name: '홍길동',
};
//'object' 형식에 'id' 속성이 없습니다.
user1.id;
//객체 리터럴 타입
let user2 = {
    id: 1,
    name: '홍길동',
};
//(property) id: number
user2.id;
let user3 = {
    name: '홍길동',
};
let config = {
    apiKey: 'MY API KEY',
};
config.apiKey = '1223234';
export {};

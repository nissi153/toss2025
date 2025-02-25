//ex05.ts

//열거형 타입
// 여러가지 값들에 각각 이름을 부여해 열거해두고 사용하는 타입

// 자동차 게임
let myCarType = 0 //0 세단, 1 스포츠카, 2 SUV, 3 지프카

enum CarType {
  Sedan = 10, //기본값 0
  Sport, //1
  Suv, //2
  Jeep, //3
}
myCarType = CarType.Sedan
myCarType = CarType.Sport

enum Lang {
  korean = 'ko',
  english = 'en',
}

let user = {
  name: '홍길동',
  lang: Lang.korean,
  car: CarType.Sedan,
}

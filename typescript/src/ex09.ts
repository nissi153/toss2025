//ex09.ts
//타입좁히기

function func1(value: number | string) {
  //value.toFixed() //실수형으로 바꾸기
  //value.toUpperCase() //대문자로 바꾸기
  if (typeof value === 'number') {
    value.toFixed()
  } else if (typeof value === 'string') {
    value.toUpperCase()
  }
}

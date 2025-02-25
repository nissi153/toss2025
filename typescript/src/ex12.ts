//ex12.ts
//제네릭 : 타입을 동적으로 결정해주는 기능

import { log } from 'node:console'

//어떤 타입의 데이터가 들어올지 모르는 상황
function func1(value: number | string | null) {}

function func2(value: any) {}

function func3<T>(value: T) {
  console.log(typeof value)
}
func3<number>(10)
func3<string>('hong')
func3<number[]>([1, 2, 3])
func3<Function>(() => {})
func3<{ name: string }>({ name: 'hong' })

function func4<T, U>(a: T, b: U) {
  console.log(typeof a)
  console.log(typeof b)
}
func4<number, string>(10, 'hong') //타입 명시적 선언
func4(10, 'hong') //타입 추정

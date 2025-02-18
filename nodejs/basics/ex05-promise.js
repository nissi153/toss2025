//프라미스 promise : 비동기처리에 성공했을 때와 실패했을 때의
//  반환 결과를 미리 약속해 둔 것.
//프라미스 객체는 처리에 성공했는지 실패했는지 판단만하고,
// 실행할 명령어는 개발자가 직접 코딩한다.

//프라미스 객체를 이용하여 피자 주문하기
let likePizza = true
const pizza = new Promise((resolve, reject) => {
  if (likePizza) {
    resolve('피자를 주문합니다.')
  } else {
    reject('피자를 주문하지 않습니다.')
  }
})
// prettier-ignore
pizza
  .then((result) => console.log(result))
  .catch((err) => console.log(err))

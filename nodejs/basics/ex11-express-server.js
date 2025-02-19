//ex11-express-server.js
const express = require('express')
const app = express()
const port = 3000

//get메소드를 지원하는 서버를 생성
app.get('/', (req, res) => {
  res.status(200) //상태코드를 200(OK)으로 설정
  // res.send('Hello Express~')
  // res.send("{ 'email': 'abc@mail.com'  }")
  res.send('<!Doctype html><html></html>')
})

app.listen(port, () => {
  console.log(`${port}번 포트에서 서버 실행 중...`)
})

//상태코드
//200 : 성공적으로 요청되었고, 정상 종료됨.
//201(작성됨) : 성공적으로 요청되었고, 서버가 새 리소스를 작성했다는 의미
//400(잘못된 요청) : 클라의 요청이 잘못되었거나 유효하지 않음.
//401(권한 없음, unauthorized) : 클라의 권한이 없음. 인증을 통해 요청을 다시 할수 있음.
//403(권한 없음. Forbidden) : 권한이 없어 거절됨. 계속 거절할 것이다.
//404(리소스 못찾음. Not Found) : 해당 데이터를 찾을 수 없음.
//500(서버 내부 오류) : 서버가 요청을 처리하는 중 에러 발생!
//503(서비스 이용 불가) : 비활성화된 서비스임.

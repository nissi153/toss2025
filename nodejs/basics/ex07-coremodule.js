//ex07-coremodule.js
//node.js 코어(Core) 모듈
//https://nodejs.org/dist/v20.12.2/docs/api/

//통신 프로토콜
//1.HTTP/HTTPS => WB,Node.js,React.js,APP(iOS,aOS)
//2.TCP/IP - Socket통신 - 메신저, 게임
//3.UDP/IP - Broadcast통신
//4.이메일(POP,SMTP)
//5.원격접속(Telnet)
//6.파일전송(FTP)

//1. http(https)
// HTTP 서버 및 클라이언트 구축을 위한 기본적인 기능을 제공.
//2. fs
// 파일(폴더) 읽기 및 쓰기 같은 파일 I/O 작업을 제공
//3. path
// os마다 다른 파일 및 디렉토리 경로 작업을 위한 유틸리티 기능을 제공
//4. os
// 시스템 정보, 메모리 사용량 및 CPU 사용률과 같은 기본 운영체제 정보를 제공
//5. util
// 다양한 작업을 위한 유틸리티(편의) 기능을 제공
//6. crypto
// 안전한 통신을 위한 해싱, 암호화 등의 암호화 기능을 제공
//7. querystring
// URL 쿼리 문자열 분석 작업을 위한 기능을 제공
//  http://www.server.com:3000?id=hong
//8. events
// 이벤트 기반 프로그래밍을 지원하는 기능을 제공

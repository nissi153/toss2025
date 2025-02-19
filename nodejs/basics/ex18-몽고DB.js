//ex18-몽고DB.js

//몽고DB 데이터베이스

//몽고DB 데이터베이스는 JSON을 기본으로 하고 있어서
//데이터베이스 언어(SQL)을 사용하지 않고도 DB를 구축할 수 있다.

//데이터베이스의 종류
//관계형 데이터베이스
//1. MySQL : 무료 DBMS이었다 오라클로 인수합병되면서 일부 무료 => MariaDB 무료 DBMS
//2. Oracle : 최초의 기업 DBMS이고 점유율이 가장 높음.
//3. PostgreSQL : 무료 DBMS이며, 일본에서 사용율이 높음.
//4. SQLite : 파일기반의 모바일DB.

//NoSQL 데이터베이스
//1. 몽고DB - JSON형식으로 문서에 자료를 저장하는 DB
//2. 레디스 - 키-값 형식으로 자료를 저장하는 DB, Memory-DB기반 속도가 빨라 캐시용 DB로 사용
//3. Neo4j - 자료를 노드와 관계 형식으로 저장하는 DB

//몽고DB 클라우드 서비스 - 아틀라스
//클라우드 서비스란? SW를 설치하는 것이 아니라, 사이트에 접속하여 서비스를 이용하는 것.
//www.mongodb.com

//콜렉션과 도큐먼트
//RDBMS의 테이블 - 콜렉션과 유사
//        레코드(행데이터) - 도큐먼트와 유사함
//콜렉션 : 여러 개의 도큐먼트로 구성됨.
//도큐먼트 : 키-값으로 구성된 데이터 쌍의 모임.

//Database 이름 : posts(기본: test)
//Collection 이름 : posts

//1.아틀라스 클라우드 무료 회원가입
//2.데이터베이스 사용자 추가하기
//3.Database Access -> Create a Database User
//4.Password : admin/1234
//5.Add Built in Role : Atlas admin을 선택

//DB접속 툴 : VSCode 확장팩(플러그인) MongoDB(공식)

//몽구스 모듈 설치 - 몽고DB 접속을 처리하는 모듈
//npm i mongoose

//몽고DB 접속 URL 문구
//mongodb+srv://admin:1234@cluster0.xlezk.mongodb.net/

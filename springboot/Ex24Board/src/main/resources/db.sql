-- 게시판(블로그,인스타그램)  db 만들기
USE mydb;

DROP TABLE IF EXISTS board;

 --기본키, 작성자, 글제목, 글내용, 작성일, 조회수
CREATE TABLE `board`(
    board_idx       BIGINT PRIMARY KEY AUTO_INCREMENT,
    board_name      VARCHAR(255),
    board_title     VARCHAR(255),
    board_content   TEXT,
    board_date      DATETIME DEFAULT NOW(),
    board_hit       INT DEFAULT 0
);

INSERT INTO board VALUES (0, '홍길동', '글 제목1', '글 내용1', DEFAULT, DEFAULT);
INSERT INTO board VALUES (0, '변사또', '글 제목2', '글 내용2', DEFAULT, DEFAULT);
INSERT INTO board VALUES (0, '사임당', '글 제목3', '글 내용3', DEFAULT, DEFAULT);

SELECT * FROM board;

DROP TABLE IF EXISTS reply;

-- reply_board_idx : 외래키 - 다른 테이블의 인덱스키를 가지고 있음.
CREATE TABLE reply(
    reply_idx       BIGINT PRIMARY KEY AUTO_INCREMENT,
    reply_name      VARCHAR(255),
    reply_content   VARCHAR(255),
    reply_date      DATETIME DEFAULT NOW(),
    reply_board_idx BIGINT NOT NULL
);

INSERT INTO reply VALUES (0, '홍두깨', '댓글 제목1', DEFAULT, 1);
INSERT INTO reply VALUES (0, '심청', '댓글 제목2', DEFAULT, 2);
INSERT INTO reply VALUES (0, '심봉사', '댓글 제목3', DEFAULT, 3);

SELECT * FROM reply;

-- 오토커밋되므로 MySQL에서는 commit명령을 쓰지 않아도 된다.
-- commit;
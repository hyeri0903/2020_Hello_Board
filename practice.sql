CREATE TABLE BOARD 
(	
SEQ NUMBER(5), 
TITLE VARCHAR2(200), 
WRITER VARCHAR2(20), 
CONTENT VARCHAR2(2000), 
REGDATE DATE DEFAULT SYSDATE, 
CNT NUMBER(5) DEFAULT 0, 
PRIMARY KEY (SEQ)
) ;
---------------------------------------------
INSERT INTO BOARD VALUES (1, '가입인사', '관리자', '잘부탁드림', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES (2, 'TEST2', 'HYERI', 'LOLOL', DEFAULT, DEFAULT);

---------------------------------------------
SELECT	*
FROM	BOARD;

---------------------------------------------
DROP TABLE BOARD;


------------------------------0516---------------------------
bno : 각 게시물을 구분할 고유 번호
title : 게시물의 제목
content : 게시물 내용
writer : 작성자
regDate : 작성일
viewCnt : 조회수


create table tbl_board(
	bno			int				not null primary key,
	title		varchar(20)		not null,
	content	varchar(100)	not null,
	writer		varchar(30)		not null,
	regDate		date			default sysdate not null,
	viewCnt		int				default 0
);

--drop table tbl_board

select * from tbl_board;

--- 게시판 번호를 위한 시퀀스 생성
create sequence seq_board start with 1 increment by 1;

--- 게시판에 데이터 입력 (코드 실행 후 반드시 커밋!)
insert into tbl_board values (seq_board.nextval, '안녕하세요', 'content', 'hyeri', sysdate, 0);
insert into tbl_board values (seq_board.nextval, 'Hello~', 'content2', 'Jung', sysdate, 0);
insert into tbl_board values (seq_board.nextval, '제목3', '내용3', '글쓴이2', sysdate, 0);
insert into tbl_board values (seq_board.nextval, '제목4', '내용4', '글쓴이3', sysdate, 0);

insert into tbl_board (bno, title, content, writer) values (seq_board.nextval, 'title1', 'content1', 'writer1');

update tbl_board
	set
		title = '수정된  제목1',
		content = '수정된 테스트 내용',
		writer = ' 수정된 작성자'
	where bno = 1;

delete 
from tbl_board
where bno = 23;	

-- 10개만 출력, num 열 생성
select *
from (
	select ROW_NUMBER() over (order by bno desc) num, a.*
	from tbl_board a
	order by bno desc
	)
where num between 0 and 10

-- 10개만 출력
select *
from (
	select *
	from tbl_board 
	order by bno desc
	)
where rownum >=0 and rownum <= 10


INSERT INTO tbl_board(title, content, writer)
SELECT title,content, writer from tbl_board;

select count(bno)
from tbl_board;


select	bno, title, writer, regDate, viewCnt
from	tbl_board
order by bno desc 


SELECT	A.*
FROM (
	select  	bno, title, writer, regDate, viewCnt
	from 		tbl_board 
	order by	bno desc
	)A
where ROWNUM <= 10


SELECT * 
FROM (
    SELECT a.*, ROWNUM as rnum 
    FROM (
           SELECT * 
           FROM tbl_student_info 
           ORDER BY height DESC,name ASC
          )
a)    
WHERE rnum >= 1 and rnum <=3  

----- 0713 oracle paging -----
select *
from
(
	select  	a.*, ROWNUM as RNUM
	from 		
	(
		select *
		from		tbl_board 
		order by	bno desc
	) a
)
where		RNUM >= 1 and RNUM <=10

-- 가장 많이 글쓴 사람 추출
select writer
from (
	select writer, count(*) as cnt
	from tbl_board
	group by writer
	order by cnt desc
)
where rownum <= 1;

-- 가장 많이 글쓴 사람의 가장 많이 쓴 제목 추출
select writer, title, count(*) as cnt
from tbl_board 
where writer = (
	select writer
	from (
		select writer, count(*) as cnt
		from tbl_board
		group by writer
		order by cnt desc
	)
	where rownum <= 1
)
group by writer, title
order by cnt desc
;





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
INSERT INTO BOARD VALUES (1, '�����λ�', '������', '�ߺ�Ź�帲', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES (2, 'TEST2', 'HYERI', 'LOLOL', DEFAULT, DEFAULT);

---------------------------------------------
SELECT	*
FROM	BOARD;

---------------------------------------------
DROP TABLE BOARD;


------------------------------0516---------------------------
bno : �� �Խù��� ������ ���� ��ȣ
title : �Խù��� ����
content : �Խù� ����
writer : �ۼ���
regDate : �ۼ���
viewCnt : ��ȸ��


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

--- �Խ��� ��ȣ�� ���� ������ ����
create sequence seq_board start with 1 increment by 1;

--- �Խ��ǿ� ������ �Է� (�ڵ� ���� �� �ݵ�� Ŀ��!)
insert into tbl_board values (seq_board.nextval, '�ȳ��ϼ���', 'content', 'hyeri', sysdate, 0);
insert into tbl_board values (seq_board.nextval, 'Hello~', 'content2', 'Jung', sysdate, 0);
insert into tbl_board values (seq_board.nextval, '����3', '����3', '�۾���2', sysdate, 0);
insert into tbl_board values (seq_board.nextval, '����4', '����4', '�۾���3', sysdate, 0);

insert into tbl_board (bno, title, content, writer) values (seq_board.nextval, 'title1', 'content1', 'writer1');

update tbl_board
	set
		title = '������  ����1',
		content = '������ �׽�Ʈ ����',
		writer = ' ������ �ۼ���'
	where bno = 1;

delete 
from tbl_board
where bno = 23;	

-- 10���� ���, num �� ����
select *
from (
	select ROW_NUMBER() over (order by bno desc) num, a.*
	from tbl_board a
	order by bno desc
	)
where num between 0 and 10

-- 10���� ���
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

-- ���� ���� �۾� ��� ����
select writer
from (
	select writer, count(*) as cnt
	from tbl_board
	group by writer
	order by cnt desc
)
where rownum <= 1;

-- ���� ���� �۾� ����� ���� ���� �� ���� ����
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





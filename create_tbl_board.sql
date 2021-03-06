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
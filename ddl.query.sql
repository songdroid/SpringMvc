CREATE TABLE tblSpringBoard(
	b_seq				number				primary key,
	b_title			varchar2(50),
	b_content		varchar2(4000),
	b_writer			varchar2(50),
	b_regdate		varchar2(50),
	b_hitcount		number,
	b_password	varchar2(10)
);

CREATE SEQUENCE seq_board;

insert into TBLSPRINGBOARD values(seq_board.nextVal, '첫번째 글', 'aaaaa',
	,'홍길동', sysdate, 0, '1111')
	
-- mysql
CREATE TABLE tblSpringBoard(
	b_seq				int		not null primary key auto_increment,
	b_title			varchar(50),
	b_content		varchar(4000),
	b_writer			varchar(50),
	b_regdate		varchar(50),
	b_hitcount		int,
	b_password	varchar(10)
);

insert into TBLSPRINGBOARD(b_title, b_content, b_writer, b_regdate,
	b_hitcount, b_password) values('첫번째 글', 'aaaaa', '홍길동', now(), 
	0, '1111');
	
	
	
	
SELECT T.*
FROM (SELECT ROWNUM RNUM, m.*
      FROM member m
      ORDER BY RNUM DESC) T
WHERE T.RNUM BETWEEN 1 AND 5;
select * from member;
UPDATE member SET password = '1' WHERE USERID LIKE 'aaa'; 

CREATE SEQUENCE IMG_SEQ
START with 1000
INCREMENT BY 1;

CREATE TABLE IMAGE(
	IMGSEQ DECIMAL PRIMARY KEY,
	IMGNAME VARCHAR2(20),
	EXTENSION VARCHAR2(10),
	USERID VARCHAR2(20),
	CONSTRAINT FK_IMAGE_MEMBER
	FOREIGN KEY (USERID) REFERENCES MEMBER(USERID)
);
SELECT * FROM IMAGE;
ALTER TABLE IMAGE RENAME COLUMN IMGSEQ TO IMG_SEQ;
ALTER TABLE IMAGE RENAME COLUMN IMGNAME TO IMG_NAME;

INSERT INTO IMAGE(IMG_SEQ, IMG_NAME, EXTENSION, USERID)
VALUES (IMG_SEQ.NEXTVAL, '', '', '');

alter table IMAGE modify (IMG_NAME default 'default');
alter table IMAGE modify (EXTENSION default 'jpg');


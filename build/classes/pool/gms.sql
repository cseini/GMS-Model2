SELECT T.*
FROM (SELECT ROWNUM RNUM, m.*
      FROM member m
      ORDER BY RNUM DESC) T
WHERE T.RNUM BETWEEN 1 AND 5;

select * from member;
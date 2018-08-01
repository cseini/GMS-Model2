select * from member;
update member 
set team_id='none'
where team_id is null;
select * from project_team;
update member set roll='minfe' where roll is null;
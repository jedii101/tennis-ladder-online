select
t.id,t.ladder_id,t.status,lp.pos,p.FIRST_NAME,p.LAST_NAME,l.level
from team t,player p ,level l,
level_position lp where t.id=lp.team_id and p.id=t.player1_id and l.id=lp.level_id and ladder_id=2

select * from team where ladder_id=2

select * from level where ladder_id=2

select * from LEVEL_POSITION where ladder_id=2


            update team set status='CHALLENGER' 
where id in(27,29,32,33)

select * from LEVEL_POSITION

--single ladder list
select
t.id,lp.level_id,lp.pos,t.status,upper(p.first_name) as fist,upper(p.last_name) as last,p.phone,p.email
from team t,player p,LEVEL_POSITION lp
where t.ladder_id=1 and t.id=lp.team_id 
and t.player1_id=p.id
order by t.id

select * from team where id in (1,2)

select * from level_position

delete from match_Schedule

select * from LEVEL_POSITION

--mix double ladder list
select
t.status,upper(p.first_name) as p1_fist,upper(p.last_name) as p1_last,p.phone as p1_phone,p.email as p1_email,upper(p2.first_name) as p2_fist,upper(p2.last_name) as p2_last,p2.phone as p2_phone,p2.email as p2_email
from team t,player p,player p2
where t.ladder_id=2
and t.player1_id=p.id and t.player2_id=p2.id
order by t.id

select distinct(email) from player 

select FIRST_name,last_name,email,phone from player where id not in (select player1_id from team) and id not in(select player2_id from team)

select * from level_position

select email from player

delete from player where id =39

select * from player where first_name like 'JEREMY%'

UPDATE player set LAST_NAME='DU' where id=24

select * from player where last_name='DU'

select * from match_Schedule

select * from LEVEL_POSITION

select * from player where id =17

select * from player where email like '%99%'

delete from player where id=27

alter table team drop column LAST_MATCH_SCHEDULE_ID

alter table team drop CONSTRAINT  FK36425D10A7AA3C

select * from  MATCH_SCHEDULE

select * from team

select * from LEVEL_POSITION



select * from player WHERE first_name like 'SNOW'

--team not in any ladder
SELECT p.FIRST_NAME,t.* FROM TEAM t,player p WHERE t.id not in(select team_id from level_position) and t.player1_id=p.id

--team in single queue
SELECT p.FIRST_NAME,t.id as tid,lp.* FROM TEAM t,player p,LEVEL_POSITION lp WHERE lp.team_id=t.id and t.player1_id=p.id and ladder_id=1 and level_id in(select id from level where level=1000)

--team in double queue
SELECT p.FIRST_NAME,t.id as tid,lp.* FROM TEAM t,player p,LEVEL_POSITION lp WHERE lp.team_id=t.id and t.player1_id=p.id and ladder_id=2 and level_id in(select id from level where level=1000)

--list challengers who have last match longer than 2 weeks

-- select most recent match of teams.
(
select max(latest_match_date), team_id from
(
select max(MATCH_DATE) as latest_match_date,challenger_id as team_id from MATCH_SCHEDULE group by team_id
union
select max(MATCH_DATE)  as latest_match_date,defender_id as team_id from MATCH_SCHEDULE group by team_id
)x group by team_id
) as ts

--double LADDER
select P1.FIRST_NAME,p2.first_name,t.id,T.STATUS,ts.last_match,t.ladder_id from team T,PLAYER P1,player p2
,(
select max(latest_match_date) as last_match, team_id from
(
select max(MATCH_DATE) as latest_match_date,challenger_id as team_id from MATCH_SCHEDULE group by team_id
union
select max(MATCH_DATE)  as latest_match_date,defender_id as team_id from MATCH_SCHEDULE group by team_id
)x group by team_id
) as ts
 where ts.team_id=t.id and P1.ID=T.PLAYER1_ID and (p2.id=t.player2_id ) and datediff('dd',ts.last_match, curdate())>14
order by status

--single both
select P1.FIRST_NAME,t.id,T.STATUS,ts.last_match,t.ladder_id from team T,PLAYER P1
,(
select max(latest_match_date) as last_match, team_id from
(
select max(MATCH_DATE) as latest_match_date,challenger_id as team_id from MATCH_SCHEDULE group by team_id
union
select max(MATCH_DATE)  as latest_match_date,defender_id as team_id from MATCH_SCHEDULE group by team_id
)x group by team_id
) as ts
 where ts.team_id=t.id and ladder_id=1 and P1.ID=T.PLAYER1_ID  and datediff('dd',ts.last_match, curdate())>14
order by status


update team set status='BOTH' where id in(23,8,5,4,28,13)

update team set status='CHALLENGER' where id in(21)

--set bottom level players to BOTH
update team set status='BOTH' 
select p.*,t.status from team t join player p on t.player1_id=p.id 
where t.id in(select team_id from LEVEL_POSITION where LEVEL_ID in(select id from level where level=1000))

select * from level

desc level

select 


AND LADDER_ID=1 AND status='DEFENDER'

select * from team where status='CHALLENGER'
--list defenders who have last match longer than 2 weeks.

select * from team

select email from player
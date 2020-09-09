select * from admin
select * from d_category d left join d_category dd on dd.parent_id=d.id
select * from d_category d
select d.id ,d.cate_name,d.count,d.parent_id,d.levels,
 		f.id,f.cate_name,f.count,f.parent_id,f.levels from d_category d left join d_category f on f.parent_id=d.id where d.parent_id='0'
 		select d.id,d.cate_name,d.count,d.parent_id,d.levels,
 		f.id f_id,f.cate_name,f.count,f.parent_id,f.levels from d_category d join d_category f on f.parent_id=d.id where d.parent_id='0'
 		
 		
 		
select d.id d_id,d.cate_name d_cate_name,d.count d_count,d.parent_id d_parent_id,d.levels d_levels,
 		f.id f_id,f.cate_name f_cate_name,f.count f_count,f.parent_id f_parent_id,f.levels f_levels from d_category d join d_category f on f.parent_id=d.id where d.parent_id='0' 		
 		
 		
insert into d_book values('00001','xx','xx',
77.7,77.5,'xx',sysdate,'xx','xx',sysdate,'xx',
111,'xx','xx','xx','xx','xx','xx','xx',10000,'xx',
'xx','xx','xx','xx');

select * from(select d.* ,rownum r from (select *from d_book d order by e_recommend) d )where r between 1 and 2
select *from d_book d order by e_recommend

select * from(select d.* ,rownum r from (select *from d_book d order by sale_count desc) d)where r between 1 and 8
select * from(select d.* ,rownum r from (select *from d_book d order by sale_count and publish_time desc) d)where r between 1 and 8
select * from d_book group by sale_count desc having avg(publish_time) between 1 and 8







select * from(select h.* ,rownum r from(select * from (select * from d_book   order by publish_time desc) order by sale_count desc)h) where r between 1 and 8


select d.* from d_book d left join d_category dd on dd.id=d.cate_id
--查询二级类别的所有书
select d.* from d_book d left join d_category dd on dd.id=d.cate_id where dd.id='2'
--查询一级类别的所有书
select d.* from d_book d left join d_category dd on dd.id=d.cate_id 
 left join d_category ddd on ddd.id=dd.parent_id where ddd.id='1'

select * from d_category d left join d_category dd on dd.parent_id=d.id

		select * from(select d.* ,rownum r from (select * from (select * from d_book where publish_time between add_months(sysdate,-18) and sysdate)
		 d order by sale_count desc) d)where r between 1 and 8

		 
		 select d.* from d_book d left join d_category dd on dd.id=d.cate_id 
			 left join d_category ddd on ddd.id=dd.parent_id where ddd.id='1'
			 
			 
		select count(*) from (select d.* from d_book d left join d_category dd on dd.id=d.cate_id 
 left join d_category ddd on ddd.id=dd.parent_id where ddd.id='1' and dd.id='2')
		 
select s.* from (select d.*,rownum r from d_book d left join d_category dd on dd.id=d.cate_id 
			 left join d_category ddd on ddd.id=dd.parent_id where ddd.id=${id} ) s where r between #{start} and #{end}
select s.* from (select d.*,rownum r from d_book d left join d_category dd on dd.id=d.cate_id 
			 left join d_category ddd on ddd.id=dd.parent_id where ddd.id='1' and dd.id='2' ) s where r between 1 and 8
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
select s.* from (select d.*,rownum r from d_book d left join d_category dd on dd.id=d.cate_id 
			 left join d_category ddd on ddd.id=dd.parent_id where ddd.id='1') s where r between 1 and 2		 
			 
			 
			 
			 
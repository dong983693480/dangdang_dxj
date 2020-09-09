package com.baizhi.dxj.service;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dxj.dao.categoryDAO;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.util.SqlUtil;

public class categoryServiceImpl implements categoryService{
	
	@Override
	public List<d_category> all() {
		List<d_category> all=null;
		try{
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			all = d.all();
			return all;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return all;
	}

	@Override
	public void delect(String id) {
		try{
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
		d.delete(id);
		SqlUtil.commit();
		System.out.println("成功");
		}catch(Exception e){
			try {
				SqlUtil.rollback();
				System.out.println("失败");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void selectOne(d_category dd) {
		try{
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			d.selectOne(dd);
			System.out.println(dd+"/////");
			SqlUtil.commit();
			System.out.println("添加成功");
			}catch(Exception e){
				try {
					SqlUtil.rollback();
					System.out.println("添加失败");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}

	@Override
	public void insertej(d_category dd) {
		try{
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			d.selectOne(dd);
			SqlUtil.commit();
			System.out.println("添加成功");
			}catch(Exception e){
				try {
					SqlUtil.rollback();
					System.out.println("添加失败");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}

	@Override
	public List<d_category> cx() {
		try {
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			return d.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询所有类别Service异常");
		}finally{
			try {
				 SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public d_category zxx(String cate_name) {
		try {
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			return d.select1(cate_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询所有类别Service异常");
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

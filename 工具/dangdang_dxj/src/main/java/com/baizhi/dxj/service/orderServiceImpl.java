package com.baizhi.dxj.service;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.baizhi.dxj.dao.orderDAO;
import com.baizhi.dxj.entity.d_item;
import com.baizhi.dxj.entity.d_order;
import com.baizhi.dxj.entity.d_user;
import com.baizhi.dxj.entity.other;
import com.baizhi.dxj.entity.other1;
import com.baizhi.dxj.util.SqlUtil;


public class orderServiceImpl implements orderService{

	@Override
	public void insertOrder(d_order d) {
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			b.insertOrder(d);
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void insertItem(d_item d) {
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			b.insertItem(d);
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public List<other> allorder() {
		List<other> allorder=null;
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			allorder = b.allorder();
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return allorder;
	}

	@Override
	public List<other1> allorder1(String id) {
		List<other1> allorder=null;
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			allorder = b.allorder1(id);
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return allorder;
	}

	@Override
	public void updateuser(d_user u) {
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			b.updateuser(u);
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public List<d_user> allUser() {
		List<d_user> allorder=null;
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			allorder = b.allUser();
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return allorder;
	}

	@Override
	public d_user selectone(String id) {
		d_user user=null;
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			user = b.selectone(id);
			SqlUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}

	
}

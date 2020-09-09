package com.baizhi.dxj.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baizhi.dxj.dao.userDAO;
import com.baizhi.dxj.entity.d_address;
import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.entity.d_user;
import com.baizhi.dxj.util.Md5Util;
import com.baizhi.dxj.util.SqlUtil;

public class userServiceImpl implements userService{

	@Override
	public String login(String email, String password,HttpSession session) {
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			d_user user1 = u.loginuser(email);
			String salt = user1.getSalt();
			String tt = Md5Util.jiami(password+salt);
			if(user1!=null){
				if (user1.getPassword().equals(tt)) {
					session.setAttribute("user",user1);
					return "cg";
				}else if(user1.getEmail().equals(email)){
					return "账号错误";
				}else if(user1.getStatus()==1){
					return "未激活账号";
				}
				else{
					return "密码错误";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {SqlUtil.close();} catch (Exception e) {e.printStackTrace();
			}
		}
		return "账号错误";
	}
	//添加
	@Override
	public void addUser(d_user user) {
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			u.adduser(user);
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
	//修改
	@Override
	public void update111(d_user user) {
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			user.setStatus(1);
			u.update11(user);
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
	public List<d_book> tuijian() {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.tuijian();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<d_book> shijian() {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.shijian();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<d_book> xiaoliang() {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.xiaoliang();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<d_book> xiaoliang1() {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.xiaoliang1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<d_book> selectoneBook(String id) {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.selectoneBook(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<d_book> selecttwoBook(String pid,String id) {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.selecttwoBook(pid,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public d_category selectCategory(String id) {
		d_category list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			// list = u.selectCategory(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}


	@Override
	public List<d_book> book1(String id, Integer start, Integer end) {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.book1(id, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<d_book> book2(String pid, String id, Integer start, Integer end) {
		List<d_book> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.book2(pid, id, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Integer count1(String id) {
		Integer list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.count1(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Integer count2(String pid, String id) {
		Integer list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.count2(pid, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public d_user ddd1(String email) {
		d_user list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.loginuser(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//地址
	@Override
	public List<d_address> selectaddress(String user_id) {
		List<d_address> list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.selectaddress(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public void insertAddress(d_address d) {
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			u.insertAddress(d);
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
	public d_address queryAddressId(String id) {
		d_address list=null;
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			 list = u.queryAddressId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	

}

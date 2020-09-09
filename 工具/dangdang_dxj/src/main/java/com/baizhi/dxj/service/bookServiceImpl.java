package com.baizhi.dxj.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dxj.dao.bookDAO;
import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.util.SqlUtil;

public class bookServiceImpl implements bookService{

	@Override
	public List<d_book> selectbookAll() {
		List<d_book> selectAll=null;
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			selectAll = b.selectbookAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			try {
				SqlUtil.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return selectAll;
	}

	@Override
	public List<d_book> mh(String xx,String name) {
		List<d_book> list=null;
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			list = b.mh(xx, name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void addBook(d_book d, File upload, String address) {
		try {
			String path = ServletActionContext.getRequest().getRealPath("/back/img");
			System.out.println(path);
			String newName = new Date().getTime()+"_"+address;
			FileUtils.copyFile(upload, new File(path+"\\"+newName));
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			String id = UUID.randomUUID().toString();
			d.setId(id);
			d.setSrc(newName);
			b.addbook(d);
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
	public void deleteBook(String id) {
		try {
			
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			b.deleteBook(id);
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
	public List<d_category> selectej() {
		List<d_category> dd=null;
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			dd = b.selectej();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dd;
	}

	@Override
	public d_book selectById(String id) {
		d_book dd=null;
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			dd = b.selectById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				SqlUtil.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dd;
	}

	@Override
	public void updateBook(d_book d, File upload, String address) {
		
		if (upload != null) {
			String realPath = ServletActionContext.getRequest().getRealPath("/back/img");
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			String newName = new Date().getTime() + "_" + address;
		

			try {
				FileUtils.copyFile(upload, new File(realPath, newName));
				System.out.println(newName+"service newName");
				d.setSrc(newName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(d+"----------");
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			if (upload == null) {
			d_book ss = b.selectById(d.getId());
			System.out.println(ss);
			d.setSrc(ss.getSrc());
			}
			b.updateBook(d);
			SqlUtil.commit();
		} catch (Exception e) {
			try {
				SqlUtil.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}


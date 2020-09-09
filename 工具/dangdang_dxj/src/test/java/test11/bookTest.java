package test11;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dxj.dao.bookDAO;
import com.baizhi.dxj.dao.userDAO;
import com.baizhi.dxj.entity.d_address;
import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.service.bookService;
import com.baizhi.dxj.service.bookServiceImpl;
import com.baizhi.dxj.util.SqlUtil;

public class bookTest {
	@Test
	public void aabaaa(){
		try {
			userDAO b = (userDAO) SqlUtil.getMapper(userDAO.class);
			List<d_address> selectaddress = b.selectaddress("1");
			for (d_address d_address : selectaddress) {
				System.out.println(d_address);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void a(){
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			List<d_book> selectAll = b.selectbookAll();
			for (d_book d_book : selectAll) {
				System.out.println(d_book);
			}
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
		
	}
	@Test
	public void aa(){
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			d_category look = b.look1("28");
			System.out.println(look);
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
		
	}
	@Test
	public void aaaaa(){
		try {
			userDAO b = (userDAO) SqlUtil.getMapper(userDAO.class);
			List<d_book> list = b.book1("1", 1, 2);
			for (d_book d_book : list) {
				System.out.println(d_book);
			}
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
		
	}
	@Test
	public void b(){
		bookService s = new bookServiceImpl();
		List<d_book> selectbookAll = s.selectbookAll();
		for (d_book d_book : selectbookAll) {
			System.out.println(d_book);
		}
		
	}
	@Test
	public void c(){
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			List<d_book> mh = b.mh("company","青春");
			for (d_book d_book : mh) {
				System.out.println(d_book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void f(){
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			b.deleteBook("0001");
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
	@Test
	public void d(){
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			String id = UUID.randomUUID().toString();
			
			d_book d = new d_book(id,"gg","仙侠",
			88.0,66.0,"999","张某人","xx出版社",new Date(),"第五版",new Date(),"100万次","ISBN","4k","5A","精美",1000000,"500页","/back/img/08.jpg","a","xx","xx","xx","xx");
			System.out.println(d);
			
			b.addbook(d);
			SqlUtil.commit();
			System.out.println("成功");
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
	@Test
	public void e(){
		
			bookService s = new bookServiceImpl();
			String id = UUID.randomUUID().toString();
			
			d_book d = new d_book(id,"gg","仙侠",
			88.0,66.0,"999","张某人","xx出版社",new Date(),"第五版",new Date(),"100万次","ISBN","4k","5A","精美",1000000,"500页","/back/img/08.jpg","a","xx","xx","xx","xx");
			
			s.addBook(d, new File("C:/Users/asus/Desktop/jquery/类别/强制登录.png"), "xx.png");
			
		
	}
	@Test
	public void ss(){
		
		try {
			userDAO u = (userDAO) SqlUtil.getMapper(userDAO.class);
			List<d_book> list = u.xiaoliang();
			for (d_book d_book : list) {
				System.out.println(d_book);
			}
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
	}
	@Test
	public void ee(){
		try {
			bookDAO b = (bookDAO) SqlUtil.getMapper(bookDAO.class);
			d_book d = new d_book("d7819df2-f074-440d-9019-708f7e0854bb","gg","仙侠",
			88.0,66.0,"999","张某人","xx出版社",new Date(),"第五版",new Date(),"100万次","ISBN","4k","5A","精美",1000000,"500页","/back/img/08.jpg","a","xx","xx","xx","xx",0);
			System.out.println(d);
			
			b.updateBook(d);
			SqlUtil.commit();
			System.out.println("成功");
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
	
}

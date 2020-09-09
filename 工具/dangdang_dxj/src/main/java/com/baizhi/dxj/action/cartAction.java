package com.baizhi.dxj.action;

import com.baizhi.dxj.entity.cart;
import com.baizhi.dxj.entity.cartItem;
import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.service.bookService;
import com.baizhi.dxj.service.bookServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;


public class cartAction {
	private String id;
	
	bookService b=new bookServiceImpl();
	public String addcart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		cart c = (cart) session.getAttribute("cart");
		if(c==null){
			c = new cart();
			Map<String, cartItem> map = c.getMap();
			d_book book = b.selectById(id);
			String uuid = UUID.randomUUID().toString();
			
			cartItem item = new cartItem(uuid,id,book.getBook_name(),1,book.getPrice(),book.getDd_price(),book.getPrice(),book.getDd_price());
			map.put(book.getId(),item);
			c.getAll();
			
		}else{
			Map<String, cartItem> map = c.getMap();
			cartItem item = map.get(id);
			if(item==null){
				d_book book = b.selectById(id);
				String uuid = UUID.randomUUID().toString();
				item = new cartItem(uuid,id,book.getBook_name(),1,book.getPrice(),book.getDd_price(),book.getPrice(),book.getDd_price());
				map.put(book.getId(),item);
				c.getAll();
			}else{
				item.setCount(item.getCount()+1);
				item.setAllprice(item.getAllprice()+item.getPrice());
				item.setDdallprice(item.getDdallprice());
				System.out.println(item.getDdallprice());
				c.getAll();
			}
		}
		session.setAttribute("cart", c);
		return "cart";
		}
	
	
	
	
	//变更数量
	private Integer count;
	public String updateCount(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		cart c = (cart) session.getAttribute("cart");
		Map<String, cartItem> map = c.getMap();
		cartItem item = map.get(id);
		item.setCount(count);
		item.setAllprice(item.getPrice());
		item.setDdallprice(item.getDd_price());
		c.getAll();
		session.setAttribute("cart",c);
		return "updateCount";
		
	}
	
	public String deleteCart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		cart c = (cart) session.getAttribute("cart");
		Map<String, cartItem> map = c.getMap();
		cartItem item = map.get(id);
		map.remove(id);
		c.getAll();
		session.setAttribute("cart", c);
		return "deletecart";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

package com.baizhi.dxj.action;

import com.baizhi.dxj.entity.*;
import com.baizhi.dxj.service.*;
import com.baizhi.dxj.util.Md5Util;
import com.baizhi.dxj.util.fenpage;
import com.baizhi.dxj.util.xuhao;
import org.apache.struts2.ServletActionContext;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class userAction {
	userService u=new userServiceImpl();
	private String email;
	private String password;
	private String xx;
	private List<d_category> all;
	private List<d_book> list;
	private List<d_book> list1;
	private String oneid;
	private String tid;
	private String id;
	private d_book dd;
	private d_user user;
	private String yzm;
	//页数
	private Integer page;
	private d_address add;
	//查询所有的地址
	HttpSession session = ServletActionContext.getRequest().getSession();
		public String address(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			d_user d = (d_user) session.getAttribute("user");
			if(d==null){
				return "no";
			}else{
				
				List<d_address> selectaddress = u.selectaddress(d.getId());
				session.setAttribute("address", selectaddress);
				return "address";
			}	
		}
		public String addressById(){
			
			add = u.queryAddressId(id);
			return "addressById";
		}
		public String insertAddress(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			d_user d = (d_user) session.getAttribute("user");
			 d_address d1 = u.queryAddressId(add.getId());
			 if(add==null){
				 HttpServletRequest request = ServletActionContext.getRequest();
				 request.setAttribute("dizhi", "请输入地址信息");
					return "no";
				}else{
			if(d1==null){
				String string = UUID.randomUUID().toString();
				session.setAttribute("adress_id", string);
				add.setId(string);
				add.setUser_id(d.getId());
				u.insertAddress(add);
				return "insert";
			}else{
				session.setAttribute("adress_id", d1.getId());
				return "nn";
			}
				}
		}
		private String orderNumber;
		private Double zongddjia;
		public Double getZongddjia() {
			return zongddjia;
		}
		public void setZongddjia(Double zongddjia) {
			this.zongddjia = zongddjia;
		}
		public String getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}
		orderService o=new orderServiceImpl();
		//销毁购物车
		public String xh(){
			orderNumber = xuhao.genImageName();
			cart xx = (cart) session.getAttribute("cart");
			d_user uu = (d_user) session.getAttribute("user");
			zongddjia = xx.getZongddjia();
			String address_id = (String) session.getAttribute("adress_id");
			String string = UUID.randomUUID().toString();
			d_order order = new d_order(string,orderNumber,new Date(),zongddjia,address_id,uu.getId());
			o.insertOrder(order);
			Map<String, cartItem> map = xx.getMap();
			for (String key : map.keySet()) { 
				cartItem item = map.get(key);
				
				d_item d2 = new d_item(UUID.randomUUID().toString(),item.getDd_price(),item.getCount(),item.getDd_price()*item.getCount(),key,order.getId());
				o.insertItem(d2);
			}

			session.removeAttribute("cart");
			return "xh";
		}
	//登陆
	public String userlogin(){
		xx = u.login(email, password ,session);
		cart cc = (cart) session.getAttribute("cart");
		if(xx.equals("cg")){
			 
			if(cc!=null){
				return "xxx";
			}
			return "login";
		}else{
			return "no";
		}
	}
	
	//注册
	private String password1;
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String adduser(){
        HttpSession session = ServletActionContext.getRequest().getSession();
		Object y1 = session.getAttribute("yzm");
		d_user dd = u.ddd1(user.getEmail());
		if(dd!=null){
			session.setAttribute("zc1", "账号已存在");
			return "no";
		}else{
			if(y1.equals(yzm)){
				if(!password1.equals(user.getPassword())){
					session.setAttribute("zc1", "两次密码不同");
					return "no";
				} 
				else{
					String salt = Md5Util.getSalt();
					user.setSalt(salt);
					String pwd = Md5Util.jiami(user.getPassword()+user.getSalt());
					user.setPassword(pwd);
					d_user uu2 = new d_user(UUID.randomUUID().toString(),user.getNick_name(),user.getEmail(),pwd,2,new Date(),salt);
					session.setAttribute("user", uu2);
					u.addUser(uu2);
					String ss = UUID.randomUUID().toString();
					session.setAttribute("suiji", ss);
					return "ok";
				}
			}else{
				session.setAttribute("zc1", "验证码错误");
				return "no";
			}	
		}
	}
	private String xxd;
	public String updateuser(){

		Object ss = session.getAttribute("suiji");
		if(xxd.equals(ss)){
			d_user uu = (d_user) session.getAttribute("uu");
			u.update111(uu);
			return "ok";
		}else{
			return "no";
		}
		
	}
	
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public String usercategory(){
		categoryService c = new categoryServiceImpl();
		all = c.all();
		return "usercategory";
	}
	
	
	public String quanbu(){
		categoryService c = new categoryServiceImpl();
		 List<d_category> all = c.all();
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 session.setAttribute("fenlei", all);
		 List<d_book> list1 = u.tuijian();
		 session.setAttribute("list1", list1);
		 List<d_book> list2 = u.shijian();
		 session.setAttribute("list2", list2);
		 List<d_book> list3 = u.xiaoliang();
		 session.setAttribute("list3", list3);
		 List<d_book> list4 = u.xiaoliang1();
		 session.setAttribute("list4", list4);
		 return "quanbu";
	}
	
	
	public String selectBy(){
		if(page==null){page=1;}
		Integer cc=null;
		Integer xx=null;
		
		if(tid==null){
			cc = u.count1(oneid);
			if(cc%2==0){
				xx=cc/2;
			}else{
				xx=cc/2+1;
			}
            HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("xx",xx);
			fenpage ff = new fenpage(page,cc,2);
			System.out.println(ff.getFirstCount()+"一级类别的+++++");
			System.out.println(ff.getEnd()+"一级类别的+++++");
			list1=u.book1(oneid, ff.getFirstCount(), ff.getEnd());

			 return "selectOne";
			 
		}else{
			cc = u.count2(tid,oneid);
			if(cc%2==0){
				xx=cc/2;
			}else{
				xx=cc/2+1;
			}
			ServletActionContext.getRequest().getSession().setAttribute("xx",xx);
			fenpage ff = new fenpage(page,cc,2);
			System.out.println(ff+"二级类别的+++++");
			list1=u.book2(tid,oneid, ff.getFirstCount(), ff.getEnd());
			//list1 = u.selecttwoBook(tid,oneid);
			return "selecttwo";
		 
		}
	}
	public String selecttwo(){
		
		
		return "selecttwo";
	}
	//注销
	public String exit1(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		session.removeAttribute("uu");
		session.removeAttribute("cart");
		return "exit";
	}
	//根据书籍id查询
	bookService s = new bookServiceImpl();
	public String selectBookId1(){
		 dd = s.selectById(id);
		return "selectOne";
	}
	
	
	
	
	
	
	
	
	


	
	public d_address getAdd() {
		return add;
	}
	public void setAdd(d_address add) {
		this.add = add;
	}
	public String getXxd() {
		return xxd;
	}
	public void setXxd(String xxd) {
		this.xxd = xxd;
	}
	public d_user getUser() {
		return user;
	}
	public void setUser(d_user user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public d_book getDd() {
		return dd;
	}
	public void setDd(d_book dd) {
		this.dd = dd;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public List<d_book> getList1() {
		return list1;
	}
	public void setList1(List<d_book> list1) {
		this.list1 = list1;
	}
	public String getOneid() {
		return oneid;
	}
	public void setOneid(String oneid) {
		this.oneid = oneid;
	}
	public List<d_book> getList() {
		return list;
	}
	public void setList(List<d_book> list) {
		this.list = list;
	}
	public List<d_category> getAll() {
		return all;
	}
	public void setAll(List<d_category> all) {
		this.all = all;
	}
	public String getXx() {
		return xx;
	}
	public void setXx(String xx) {
		this.xx = xx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

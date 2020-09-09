package com.baizhi.dxj.action;

import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.service.bookService;
import com.baizhi.dxj.service.bookServiceImpl;

import java.io.File;
import java.util.List;


public class bookAction {
	private bookService s = new bookServiceImpl();
	private List<d_book> book;
	private String xx;
	private String name;
	private List<d_book> list;
	private List<d_category> selectej;
	private String id;
	private File upload;
	private String uploadFileName;
	private d_book dd;
	private d_book y;
	//查所有
	public String bookall(){
		book = s.selectbookAll();
		return "bookall";
	}
	//模糊查询
	public String mhselect(){
		list = s.mh(xx, name);
		return "mhselect";
		
	}
	//删除
	public String deleteBook(){
		s.deleteBook(id);
		return "delete";
	}
	//添加
	public String addBook(){
		System.out.println(upload+"-------------------");
		System.out.println(uploadFileName+"    uploadName");
		
		s.addBook(dd, upload, uploadFileName);
		return "add";
		
	}
	//查询所有二级菜单
	public String selectej(){
		selectej = s.selectej();
		
		return "tow";
	}
	//查询所有二级菜单
	public String selectej1(){
		selectej = s.selectej();
		
		return "tow";
	}
	//回显
	
	public String selectBookId(){
		y = s.selectById(id);
		return "selectOne";
	}
	//修改
	public String updateBook(){
		dd.setSale_count(0);
		System.out.println(dd+"-------------");
		System.out.println(upload+"  ---file");
		s.updateBook(dd, upload, uploadFileName);
		return "update";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public d_book getY() {
		return y;
	}
	public void setY(d_book y) {
		this.y = y;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public d_book getDd() {
		return dd;
	}
	public void setDd(d_book dd) {
		this.dd = dd;
	}
	public List<d_category> getSelectej() {
		return selectej;
	}
	public void setSelectej(List<d_category> selectej) {
		this.selectej = selectej;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<d_book> getList() {
		return list;
	}
	public void setList(List<d_book> list) {
		this.list = list;
	}
	public String getXx() {
		return xx;
	}
	public void setXx(String xx) {
		this.xx = xx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<d_book> getBook() {
		return book;
	}
	public void setBook(List<d_book> book) {
		this.book = book;
	}
}

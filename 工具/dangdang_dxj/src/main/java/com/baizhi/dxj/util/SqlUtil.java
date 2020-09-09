package com.baizhi.dxj.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlUtil {
	private static SqlSessionFactory bb =null;
	static{
		 try {
				InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
				//创建SqlSssion工厂
				bb = new SqlSessionFactoryBuilder().build(is);
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	public static final ThreadLocal<SqlSession> t=new ThreadLocal<SqlSession>();
	public static SqlSession getsession(){
		SqlSession ss=t.get();
		if(ss==null){
			ss=bb.openSession();
			t.set(ss);
		}
		
		return ss;
	}
	public static Object getMapper(Class clazz) throws Exception{
		return getsession().getMapper(clazz);
	
	}
	public static void close()throws Exception{
		getsession().close();
		t.remove();
	}
	public static void commit()throws Exception{
		getsession().commit();
		close();
	}
	public static void rollback()throws Exception{
		getsession().rollback();
		close();
	}
	
}

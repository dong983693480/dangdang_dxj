package com.baizhi.dxj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class xuhao {
	//随机编号
	public static String genImageName() {  
		        //取当前时间的长整形值包含毫秒  
		        long millis = System.currentTimeMillis();  
		        //加上三位随机数  
		         Random random = new Random();  
		       int end3 = random.nextInt(999);//该方法的作用是生成一个随机的int值，该值介于[0,n]的区间，也就是0到n之间的随机int值，包含0而不包含n。  
		        //如果不足三位前面补0  String.format("%03d", end3); 3代表要获得的总长度，0代表传入的参数不够的时候会用0作为填充，d会被传入的参数替代
		        String str = millis + String.format("%03d", end3);   
		        return str;  
		     } 
	//流水编号
	  public static String getstr(){
		           String Orderno = null;
		        String maxOrderno = "NO201601270001"; // 从数据库查询出的最大编号
		         SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 时间字符串产生方式
		           String uid_pfix = "NO" + format.format(new Date()); // 组合流水号前一部分，NO+时间字符串，如：NO20160126
		          if (maxOrderno != null && maxOrderno.contains(uid_pfix)) {
		               String uid_end = maxOrderno.substring(10, 14); // 截取字符串最后四位，结果:0001
		               System.out.println("uid_end=" + uid_end);
		               int endNum = Integer.parseInt(uid_end); // 把String类型的0001转化为int类型的1
		              System.out.println("endNum=" + endNum);
		              int tmpNum = 10000 + endNum + 1; // 结果10002
		              System.out.println("tmpNum=" + tmpNum);
		              Orderno = uid_pfix +subStr("" + tmpNum, 1);// 把10002首位的1去掉，再拼成NO201601260002字符串
		          } else {
		              Orderno = uid_pfix + "0001";
		          }
		         return Orderno;
		     }
		     
	     public static String subStr(String str, int start) {
		         if (str == null || str.equals("") || str.length() == 0)
		             return "";
		         if (start < str.length()) {
		             return str.substring(start);
		         } else {
		             return "";
		         }
		     }
}

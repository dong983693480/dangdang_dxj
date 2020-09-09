package com.baizhi.dxj.util;

	import java.util.Random;

	import org.apache.commons.codec.digest.DigestUtils;

	public class Md5Util {
		public static String jiami(String str){
			return DigestUtils.md5Hex(str);
		}
		
		public static boolean validate(String src,String dest){
			if(src == null) throw new RuntimeException();
			if(dest == null) throw new RuntimeException();
			
			String enc = jiami(src);
			return enc.equals(dest);
		}
		
		public static String getSalt(){
			char[] array = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnpqrstuvwxyz123456789".toCharArray();
			Random random = new Random();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				sb.append(array[random.nextInt(array.length)]);
			}
			return sb.toString();
			
		}
	
}

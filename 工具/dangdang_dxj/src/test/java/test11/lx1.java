package test11;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dxj.dao.categoryDAO;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.service.categoryService;
import com.baizhi.dxj.service.categoryServiceImpl;
import com.baizhi.dxj.util.SqlUtil;

public class lx1 {
	@Test
	public void aa(){
		String xx=UUID.randomUUID().toString();
		System.out.println(xx);
		d_category d_category = new d_category();
		System.out.println(d_category);
	}
	@Test
	public void xx(){
		try {
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			
			List<d_category> all = d.all();
			for (d_category dd : all) {
				System.out.println(dd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	categoryService ss = new categoryServiceImpl();
	@Test 
	public void as(){
		List<d_category> list = ss.all();
		for (d_category ddd : list) {
			System.out.println(ddd);
		}
	}
	@Test
	public void de1(){
		try {
			categoryDAO d = (categoryDAO) SqlUtil.getMapper(categoryDAO.class);
			
			d.delete("23454b06-b7a5-4cf1-a4bc-46d935c01596");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void de(){
		ss.delect("f26301a4-71b7-4524-83f2-dedef1e1df76");
		
	}
}

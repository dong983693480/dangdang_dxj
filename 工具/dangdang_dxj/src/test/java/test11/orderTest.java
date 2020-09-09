package test11;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dxj.dao.orderDAO;
import com.baizhi.dxj.entity.d_item;
import com.baizhi.dxj.entity.d_order;
import com.baizhi.dxj.entity.other;
import com.baizhi.dxj.entity.other1;
import com.baizhi.dxj.util.SqlUtil;

public class orderTest {
	@Test
	public void a(){
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			d_order d = new d_order(UUID.randomUUID().toString(),"1571139447971823",new Date(),999.0,"ff6dc53d-9874-4e5b-9edd-9813c0301c2a","bbb694b0-411d-42af-b0fc-0a2c4d516a54");
			b.insertOrder(d);
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
	public void b(){
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			d_item d = new d_item(UUID.randomUUID().toString(),999.0,1,999.0,"92f5fbf7-91fa-48c8-8b5f-d229444a6ddc","1571139447971823");
			b.insertItem(d);
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
	public void cc(){
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			List<other> list = b.allorder();
			for (other d_order : list) {
				System.out.println(d_order);
			}
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
	public void ccc(){
		try {
			orderDAO b = (orderDAO) SqlUtil.getMapper(orderDAO.class);
			List<other1> list = b.allorder1("a3d55f3d-2e9c-4012-8e5f-f37972737de2");
			for (other1 d_order : list) {
				System.out.println(d_order);
			}
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
}

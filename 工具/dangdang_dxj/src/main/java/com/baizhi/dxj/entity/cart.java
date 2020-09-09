package com.baizhi.dxj.entity;

import java.util.HashMap;
import java.util.Map;

public class cart {
	private	Map<String,cartItem> map=new HashMap<String,cartItem>();
	private Double zongjia;
	private Double zongddjia;
	public Map<String, cartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, cartItem> map) {
		this.map = map;
	}
	public Double getZongjia() {
		return zongjia;
	}
	public void setZongjia(Double zongjia) {
		this.zongjia = zongjia;
	}
	public Double getZongddjia() {
		return zongddjia;
	}
	public void setZongddjia(Double zongddjia) {
		this.zongddjia = zongddjia;
	}
	public void getAll(){
		Double a=0.0;
		Double b=0.0;
		for (cartItem c : map.values()) {
			a+=c.getDdallprice()*c.getCount();
			b+=c.getAllprice()*c.getCount();
		}
		this.zongjia=b;
		this.zongddjia=a;
	}
}

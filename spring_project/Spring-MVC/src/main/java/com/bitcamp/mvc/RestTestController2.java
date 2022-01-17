package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.OrderItem;

@RestController
public class RestTestController2 {

	// 단순문자열
	@RequestMapping("/simple")
	public String getString() {
		return "return String";
	}
	
	// 객체를 JSON으로 반환
	@RequestMapping("/orderitem")
	public OrderItem getOrderItem() {
		
		return new OrderItem("product-10", 10000, "파손주의");
	}
	
	// 컬렉션 타입의 객체 반환 : List
	@RequestMapping("/orderitems")
	public List<OrderItem> getOrderItems() {
		
		List<OrderItem> list = new ArrayList<OrderItem>();
		list.add(new OrderItem("product-10", 10000, "파손주의"));
		list.add(new OrderItem("product-11", 100, "파손주의"));
		
		return list;
	}
	
	// 컬렉션 타입의 객체 반환 : Map
	@RequestMapping("/orderitems2")
	public Map<String, OrderItem> getOrderItems2(){
		
		// key값 : 속성의 이름으로 표현됨 (property로)
		Map<String, OrderItem> map = new HashMap<String, OrderItem>();
		map.put("product-10", new OrderItem("product-10", 10000, "파손주의"));
		map.put("product-20", new OrderItem("product-20", 10, "파손주의"));
		
		return map;
		
	}
	
}

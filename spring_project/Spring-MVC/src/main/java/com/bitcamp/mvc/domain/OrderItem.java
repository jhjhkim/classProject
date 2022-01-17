package com.bitcamp.mvc.domain;

public class OrderItem {
	
	private String itemId;
	private int number;
	private String remark;
	
	public OrderItem() {}

	public OrderItem(String itemId, int number, String remark) {
		this.itemId = itemId;
		this.number = number;
		this.remark = remark;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", number=" + number + ", remark=" + remark + "]";
	}

}

package com.example.demo.member.domain;

import java.util.List;

public class ListPageView {
	
	private int totalCount;
	private int currentPage;
	private int countPerPage;
	private List<Member> list;
	private int pageTotalCount;
	
	public ListPageView(int totalCount, int currentPage, int countPerPage, List<Member> list) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.countPerPage = countPerPage;
		this.list = list;
		calPageTotalCount();
	}

	private void calPageTotalCount() {
		
		pageTotalCount = totalCount / countPerPage;
		pageTotalCount = totalCount%countPerPage>0 ? ++pageTotalCount : pageTotalCount;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	
}

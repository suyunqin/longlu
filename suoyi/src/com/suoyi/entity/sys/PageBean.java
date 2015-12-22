package com.suoyi.entity.sys;

public class PageBean {
	private int curPage = 1;
	private int pageSize = 15;
	private int count;

	public int getMaxPageNo() {
		int pageno =this.getCount() % this.getPageSize() == 0 ? this.getCount() / this.getPageSize() : (this.getCount() / this.getPageSize()) + 1; 
		return pageno;
	}
	
	public int getNextPage(){
		int pageno = (this.getCurPage()+1)>this.getMaxPageNo()?this.getMaxPageNo():this.getCurPage()+1;
		return pageno;
	}
	
	public int getPrePage(){
		int pageno = (this.getCurPage()-1)<=0?1:this.getCurPage()-1;
		return pageno;
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

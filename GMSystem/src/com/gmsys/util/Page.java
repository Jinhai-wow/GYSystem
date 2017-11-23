package com.gmsys.util;

import java.util.List;

/**
 * 分页数据管理
 * @author
 *
 */
public class Page<E> {
	private int currPage;//当前页数
	private int pageSize;//每页显示记录数
	private int totalSize;//总记录数
	private int pageCount;//总页数
	private List<E> list;//每页显示的数据
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
}

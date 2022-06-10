package com.gym.GYM.company.dto;


import org.apache.ibatis.type.Alias;


@Alias("page")
public class PageDTO {
    private int page;
    private int maxPage;
    private int StartPage;
    private int EndPage;
    private int startRow;
    private int endRow;
    private int limit;

    public PageDTO(int startRow, int endRow) {
        this.startRow = startRow;
        this.endRow = endRow;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return StartPage;
	}

	public void setStartPage(int startPage) {
		StartPage = startPage;
	}

	public int getEndPage() {
		return EndPage;
	}

	public void setEndPage(int endPage) {
		EndPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "PageDTO [page=" + page + ", maxPage=" + maxPage + ", StartPage=" + StartPage + ", EndPage=" + EndPage
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", limit=" + limit + "]";
	}
    
}

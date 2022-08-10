package com.mome.myapp.vo;

public class PagingVO {
	//페이징
	private int nowPage = 1; //현재페이지
	private int onePageRecord = 10;// 한페이지에 출력할 레코드수
	private int totalRecord; //총레코드 수
	private int totalPage; //총페이지 수
	private int offsetPoint; // 페이지레코드 선택할 위치
	
	//페이지번호
	private int onePageCount = 5;//한번에 표시할 페이지 수
	private int startPage = 1;//표시할 페이지의 시작번호
	
	//검색
	private String searchKey;
	private String searchWord;
	
	
	@Override
	public String toString() {
		return "PagingVO [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", offsetPoint=" + offsetPoint + ", onePageCount=" + onePageCount
				+ ", startPage=" + startPage + ", searchKey=" + searchKey + ", searchWord=" + searchWord + "]";
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		//선택레코드 시작위치
		offsetPoint = (nowPage-1)*onePageRecord;
		//표시할 페이지의 시작번호
		startPage = (nowPage-1)/onePageCount*onePageCount+1;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총페이지수 구하기
		totalPage = totalRecord/onePageRecord;
		if(totalRecord%onePageRecord!=0) {
			totalPage++;
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffsetPoint() {
		return offsetPoint;
	}
	public void setOffsetPoint(int offsetPoint) {
		this.offsetPoint = offsetPoint;
	}
	
	public int getOnePageCount() {
		return onePageCount;
	}
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	//검색
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
	
}

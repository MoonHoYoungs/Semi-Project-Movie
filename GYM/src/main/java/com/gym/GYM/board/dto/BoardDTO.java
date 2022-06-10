package com.gym.GYM.board.dto;


import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;


@Alias("board")
public class BoardDTO {
	
	private int boardNo; 		//게시글 번호(pk)
	private String boardType; 	//글머리 : QNA, 정보공유, 잡담등
	private String boardNotice; //공지사항 여부
	private Date boardDate;		//작성날자
	private String boardTitle;  //글제목
	private String boardWriter; //작성자(FK - MEMBERID)
	private String boardContent; //글 내용
	private String boardUploadFileName; //업로드 파일이름
	private MultipartFile boardFile; // 업로드 파일
	private int boardHits; 			//조회수
	
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getBoardNotice() {
		return boardNotice;
	}
	public void setBoardNotice(String boardNotice) {
		this.boardNotice = boardNotice;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardUploadFileName() {
		return boardUploadFileName;
	}
	public void setBoardUploadFileName(String boardUploadFileName) {
		this.boardUploadFileName = boardUploadFileName;
	}
	public MultipartFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile boardFile) {
		this.boardFile = boardFile;
	}
	public int getBoardHits() {
		return boardHits;
	}
	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}
	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardType=" + boardType + ", boardNotice=" + boardNotice
				+ ", boardDate=" + boardDate + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardContent=" + boardContent + ", boardUploadFileName=" + boardUploadFileName + ", boardFile="
				+ boardFile + ", boardHits=" + boardHits + "]";
	}
	
	
	
	
	
}

package com.gym.GYM.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.gym.GYM.board.dto.BoardDTO;



@Mapper
public interface BoardDAO {

	

	List<BoardDTO> boardList();

	int boardRegist(BoardDTO board);

	BoardDTO boardView(int boardNo);

	int boardModify(BoardDTO board);

	void count(int boardNo);

	





	

}

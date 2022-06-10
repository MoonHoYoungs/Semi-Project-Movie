package com.gym.GYM.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gym.GYM.member.dto.MemberDTO;
import com.gym.GYM.member.dto.MemberPagingDTO;


@Mapper
public interface MemberDAO {

	int memberRegist(MemberDTO member);

	int memberCount();

	List<MemberDTO> memberList(MemberPagingDTO paging);

	MemberDTO memberView(String memberId);

	int memberModify(MemberDTO member);

	int memberDelete(String memberId);

	MemberDTO memberSignIn(MemberDTO member);

	String mEpw(String memberId);


}

package com.gym.GYM.member.service;

import java.io.IOException;

import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.member.dto.MemberDTO;

public interface MemberService {

	ModelAndView memberRegist(MemberDTO member) throws IllegalStateException, IOException;

	ModelAndView memberList(int limit, int page);

	ModelAndView memberView(String memberId);

	ModelAndView memberModifyForm(String memberId);

	ModelAndView memberModify(MemberDTO member);

	ModelAndView memberDelete(String memberId);

	ModelAndView memberSignIn(MemberDTO member);


}

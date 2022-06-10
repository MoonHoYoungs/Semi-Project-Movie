package com.gym.GYM.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.member.dto.MemberDTO;
import com.gym.GYM.member.service.MemberService;



@Controller
public class MemberController {
	
	//ModelAndView 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	//@Autowired MemberService
	@Autowired
	private MemberService membersvc; 
	
	//@Autowired HttpSession (회원 로그인/로그아웃)
	@Autowired
	private HttpSession session;
	
	
	//기업회원 가입페이지 이동 : enterpriseMemberRegistForm
	@GetMapping("/enterpriseMemberRegistForm")
	public String enterpriseMemberRegistForm() {
		return "SignUp/EnterpriseMemberRegistForm";
	}
	
	//일반회원 가입페이지 이동 : normalMemberRegistForm
	@GetMapping("/normalMemberRegistForm")
	public String normalMemberRegistForm() {
		return "SignUp/NormalMemberRegistForm";
	}
	
	//로그인페이지 이동 : memberSignIn
	@GetMapping("/memberSignIn")
	public String memberSignIn() {
		return "SignIn/MemberSignInForm";
	}
	
	//회원가입(기업/일반) 메소드 : memberRegist
	@PostMapping("/memberRegist")
	public ModelAndView memberRegist(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = membersvc.memberRegist(member);
		
		return mav;
	}
	
	//회원 목록 조회 메소드 : memberList
	@GetMapping("/memberList")
	public ModelAndView memberList(@RequestParam int limit, @RequestParam int page) {
		mav = membersvc.memberList(limit,page);
		
		return mav;
	}
	
	//회원 상세 조회 메소드 : memberView
	@GetMapping("/memberView")
	public ModelAndView memberView(@RequestParam String memberId) {
		mav = membersvc.memberView(memberId);
		
		return mav;
	}
	
	//회원 정보 수정페이지 이동 : memberModifyForm
	@GetMapping("/memberModifyForm")
	public ModelAndView memberModifyForm(@RequestParam String memberId) {
		mav = membersvc.memberModifyForm(memberId);
		
		return mav;
	}
	
	//회원 정보 수정 메소드 : memberModify
	@PostMapping("/memberModify")
	public ModelAndView memberModify(@ModelAttribute MemberDTO member) {
		mav = membersvc.memberModify(member);
		
		return mav;
	}
	
	//회원 정보 삭제 메소드 : memberDelete
	@PostMapping("/memberDelete")
	public ModelAndView memberDelete(@RequestParam String memberId) {
		mav = membersvc.memberDelete(memberId);
		
		return mav;
	}
	
	//회원 로그인 메소드 : memberSignIn
	@PostMapping("/memberSignIn")
	public ModelAndView memberSignIn (@ModelAttribute MemberDTO member) {
		
		mav = membersvc.memberSignIn(member);
		
		return mav;
	}
	
	//회원 로그아웃 메소드 : memberSignOut
	@GetMapping("/memberSignOut")
	public String memberSignOut() {
		session.invalidate();
		return "index";
	}
}

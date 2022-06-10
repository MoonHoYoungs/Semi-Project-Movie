package com.gym.GYM.member.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.member.dao.MemberDAO;
import com.gym.GYM.member.dto.MemberDTO;
import com.gym.GYM.member.dto.MemberPagingDTO;


@Service
public class MemberServiceImpl implements MemberService{

	//ModelAndView 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	//@Autowired MemberDAO
	@Autowired
	private MemberDAO memberdao;
	
	//@Autowired HttpSession (로그인)
	@Autowired
	private HttpSession session;
	
	//@Autowired PasswordEncoder
	@Autowired
	private PasswordEncoder pwEnc;

	//회원가입 메소드 : memberRegist
	@Override
	public ModelAndView memberRegist(MemberDTO member) throws IllegalStateException, IOException {
		
		//파일 불러오기
		MultipartFile profile = member.getMemberProfile();
		
		//파일이름 불러오기
		String fileName = profile.getOriginalFilename();
		
		//UUID 생성 (중복파일 오류방지)
		String uuid = UUID.randomUUID().toString().substring(0,8);
		
		//중복파일 오류방지를 위한 파일명 재설정
		String profileName = uuid + "_" + fileName;
		
		//파일 저장 위치 설정
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/profile");
		String savePath = path + "/" + profileName;
		
		//파일 선택 여부
		if(!profile.isEmpty()) {
			member.setMemberProfileName(profileName);
			profile.transferTo(new File(savePath));
		}else {
			member.setMemberProfileName("default.png");
		}
		
		//비밀번호 암호화
		member.setMemberPw(pwEnc.encode(member.getMemberPw()));
		
		//API사용으로 나누어진 주소정보
		String addr1 = member.getAddr1();
		String addr2 = member.getAddr2();
		String addr3 = member.getAddr3();
		
		String memberAddress = "("+addr1+") "+addr2+" "+addr3;
		
		if(!addr1.equals(""))
		{
			member.setMemberAddress(memberAddress);
		}
		int result = memberdao.memberRegist(member);
		
		if(result >0) {
			mav.setViewName("index"); //회원가입 성공시 이동할 페이지
		}else {
			mav.setViewName("index"); //회원가입 실패시 이동할 페이지
		}
		return mav;
	}

	
	//회원 목록 조회 서비스 (페이징) : memberList
	@Override
	public ModelAndView memberList(int limit, int page) {
	      int block = 5;

	        // 전체 회원수
	        int memberCount = memberdao.memberCount();

	        int startRow = (page - 1) * limit + 1;
	        int endRow = page * limit;

	        int maxPage = (int) (Math.ceil((double) memberCount / limit));
	        int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
	        int endPage = startPage + block - 1;

	        // 오류 방지
	        if (endPage > maxPage) {
	            endPage = maxPage;
	        }

	        // 페이지 객체 생성
	        MemberPagingDTO paging = new MemberPagingDTO();

	        paging.setPage(page);

	        paging.setStartRow(startRow);
	        paging.setEndRow(endRow);

	        paging.setMaxPage(maxPage);
	        paging.setStartPage(startPage);
	        paging.setEndPage(endPage);

	        paging.setLimit(limit);

	        List<MemberDTO> memberList = memberdao.memberList(paging);

	        mav.addObject("memberList", memberList);
	        mav.addObject("paging", paging);
	        mav.setViewName("MemberList");

	        return mav;
	}

	
	//회원 상세 조회 서비스 : memberView
	@Override
	public ModelAndView memberView(String memberId) {
		MemberDTO member = memberdao.memberView(memberId);
		
		mav.setViewName("Member/MemberView");
		mav.addObject("memberView",member);
		return mav;
	}

	//회원 수정페이지 이동 서비스 : memberModifyForm
	@Override
	public ModelAndView memberModifyForm(String memberId) {
		MemberDTO member = memberdao.memberView(memberId);
		
		mav.setViewName("SignUp/MemberModifyForm");
		mav.addObject("memberModify",member);
		return mav;
	}

	
	//회원 수정 서비스 : memberModify
	@Override
	public ModelAndView memberModify(MemberDTO member) {
		int result = memberdao.memberModify(member);
	
		if(result>0) {
			mav.setViewName("index");
		}else {
			mav.setViewName("index");
		}
		return mav;
	}

	//회원 정보 삭제 서비스 : memberDelete
	@Override
	public ModelAndView memberDelete(String memberId) {
		int result = memberdao.memberDelete(memberId);
		
		if(result>0) {
			mav.setViewName("index");
		}else {
			mav.setViewName("index");
		}
		return mav;
	}

	//회원 로그인 서비스 : memberSignIn
	@Override
	public ModelAndView memberSignIn(MemberDTO member) {
		
		
		
		String ePw = memberdao.mEpw(member.getMemberId());
		
		if(pwEnc.matches(member.getMemberPw(), ePw)) {
			MemberDTO loginMember = memberdao.memberView(member.getMemberId());
			session.setAttribute("login", loginMember);
			mav.setViewName("index");
		} else {
			mav.setViewName("SignIn/MemberSignInForm");
		}
		
		
		
		return mav;
	}
	
	
	
}

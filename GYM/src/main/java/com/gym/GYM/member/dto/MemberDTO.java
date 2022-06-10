package com.gym.GYM.member.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;


@Alias("member")
public class MemberDTO {
	private String memberName;
	private String memberId;
	private String memberPw;
	private String memberAddress;
	private String memberPhone;
	private String memberGender;
	private Date memberBirth;
	private int memberHeight;
	private int memberWeight;
	private String memberCompanyName;
	private String memberRole;
	
	private MultipartFile memberProfile;
	private String memberProfileName;
	
	private String addr1;
	private String addr2;
	private String addr3;
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public int getMemberHeight() {
		return memberHeight;
	}
	public void setMemberHeight(int memberHeight) {
		this.memberHeight = memberHeight;
	}
	public int getMemberWeight() {
		return memberWeight;
	}
	public void setMemberWeight(int memberWeight) {
		this.memberWeight = memberWeight;
	}
	public String getMemberCompanyName() {
		return memberCompanyName;
	}
	public void setMemberCompanyName(String memberCompanyName) {
		this.memberCompanyName = memberCompanyName;
	}
	public String getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}
	public MultipartFile getMemberProfile() {
		return memberProfile;
	}
	public void setMemberProfile(MultipartFile memberProfile) {
		this.memberProfile = memberProfile;
	}
	public String getMemberProfileName() {
		return memberProfileName;
	}
	public void setMemberProfileName(String memberProfileName) {
		this.memberProfileName = memberProfileName;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberName=" + memberName + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberAddress=" + memberAddress + ", memberPhone=" + memberPhone + ", memberGender=" + memberGender
				+ ", memberBirth=" + memberBirth + ", memberHeight=" + memberHeight + ", memberWeight=" + memberWeight
				+ ", memberCompanyName=" + memberCompanyName + ", memberRole=" + memberRole + ", memberProfile="
				+ memberProfile + ", memberProfileName=" + memberProfileName + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", addr3=" + addr3 + "]";
	}
	
	
	
}

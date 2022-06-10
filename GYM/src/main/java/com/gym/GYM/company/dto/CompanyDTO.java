package com.gym.GYM.company.dto;


import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;


@Alias("company")
public class CompanyDTO {

    private String companyCode;
    private String companyId;
    private String companyComment;
    private String companyPhotoName;
    private int companyRate;
    private String companyEquipment;
    private MultipartFile companyPhoto;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyComment() {
		return companyComment;
	}
	public void setCompanyComment(String companyComment) {
		this.companyComment = companyComment;
	}
	public String getCompanyPhotoName() {
		return companyPhotoName;
	}
	public void setCompanyPhotoName(String companyPhotoName) {
		this.companyPhotoName = companyPhotoName;
	}
	public int getCompanyRate() {
		return companyRate;
	}
	public void setCompanyRate(int companyRate) {
		this.companyRate = companyRate;
	}
	public String getCompanyEquipment() {
		return companyEquipment;
	}
	public void setCompanyEquipment(String companyEquipment) {
		this.companyEquipment = companyEquipment;
	}
	public MultipartFile getCompanyPhoto() {
		return companyPhoto;
	}
	public void setCompanyPhoto(MultipartFile companyPhoto) {
		this.companyPhoto = companyPhoto;
	}
	@Override
	public String toString() {
		return "CompanyDTO [companyCode=" + companyCode + ", companyId=" + companyId + ", companyComment="
				+ companyComment + ", companyPhotoName=" + companyPhotoName + ", companyRate=" + companyRate
				+ ", companyEquipment=" + companyEquipment + ", companyPhoto=" + companyPhoto + "]";
	}
    
}

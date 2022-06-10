package com.gym.GYM.company.contoller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.company.dto.CompanyDTO;
import com.gym.GYM.company.service.CompanyService;

@Controller
public class CompanyController {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private CompanyService companysvc;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 기업 등록 페이지로 이동
    @GetMapping("/companyRegistForm")
    public String companyRegistForm() {
        return "CompanyRegistForm";
    }

    // 기업 등록 메소드
    @PostMapping("/companyRegist")
    public ModelAndView companyRegist(@ModelAttribute CompanyDTO company) throws Exception {
    	 mav = companysvc.companyRegist(company);
        return mav;
    }

    // 기업 리스트 메소드
    @GetMapping("/companyList")
    public ModelAndView companyList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, @RequestParam(value = "limit", required = false, defaultValue = "5") int limit){
        mav = companysvc.companyList(page, limit);
        return mav;
    }

    // 기업 상세보기 메소드
    @GetMapping("/companyView")
    public ModelAndView companyView(@RequestParam(value = "companyCode") String companyCode) {
        mav = companysvc.companyView(companyCode);
        return mav;
    }

    // 기업 수정 페이지 이동
    @GetMapping("/companyModifyForm")
    public ModelAndView companyModifyForm(@RequestParam(value = "companyCode") String companyCode) {
        mav = companysvc.companyModifyForm(companyCode);
        return mav;
    }

    // 기업 수정 메소드
    @PostMapping("/companyModify")
    public ModelAndView companyModify(@ModelAttribute CompanyDTO company) throws IOException {
        mav = companysvc.companyModify(company);
        return mav;
    }

    // 기업 삭제 메소드
    @GetMapping("/companyDelete")
    public ModelAndView companyDelete(@RequestParam(value = "companyCode") String companyCode) {
        mav = companysvc.companyDelete(companyCode);
        return mav;
    }
}

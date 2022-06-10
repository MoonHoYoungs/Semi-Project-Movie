package com.gym.GYM.company.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.company.dao.CompanyDAO;
import com.gym.GYM.company.dto.CompanyDTO;
import com.gym.GYM.company.dto.PageDTO;

@Service
public class CompanyServiceImpl implements CompanyService{

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private CompanyDAO companydao;

    @Override
    public ModelAndView companyRegist(CompanyDTO company) throws IOException {
        MultipartFile companyPhoto = company.getCompanyPhoto();

        String originalFileName = companyPhoto.getOriginalFilename();

        // 0번째 부터 8번째 자리의 문자까지만 랜덤으로 붙이겠다.
        String uuid = UUID.randomUUID().toString().substring(0, 8);

        String companyPhotoName = uuid + "_" + originalFileName;

        // 파일 저장 위치 설정
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/CompanyPhoto");
        String savePath = path + "/" + companyPhotoName;

        // 파일 선택 여부
        if(!companyPhoto.isEmpty()) {
            company.setCompanyPhotoName(companyPhotoName);
            companyPhoto.transferTo(new File(savePath));
        } else {
            company.setCompanyPhotoName("default.png");
        }

        int result = companydao.companyRegist(company);

        if(result>0){
            mav.setViewName("index");
        } else {
            mav.setViewName("index");
        }
        return mav;
    }

    @Override
    public ModelAndView companyList(int page, int limit) {
        int block = 5;
        int cCount = companydao.companyCount();
        int startRow = (page - 1) * limit + 1;
        int endRow = page * limit;
        int maxPage = (int) (Math.ceil((double) cCount / limit));
        int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
        int endPage = startPage + block - 1;

        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO paging = new PageDTO(0, 1000);

        paging.setPage(page);
        paging.setStartRow(startRow);
        paging.setEndRow(endRow);
        paging.setMaxPage(maxPage);
        paging.setStartPage(startPage);
        paging.setEndPage(endPage);
        paging.setLimit(limit);

        List<CompanyDTO> companyList = companydao.companyList(paging);

        mav.setViewName("Company/CompanyList");
        mav.addObject("company", companyList);
        mav.addObject("paging", paging);
        return mav;
    }

    @Override
    public ModelAndView companyView(String companyCode) {
        CompanyDTO company = companydao.companyView(companyCode);
        mav.setViewName("Company/CompanyView");
        mav.addObject("view", company);
        return mav;
    }

    @Override
    public ModelAndView companyModifyForm(String companyCode) {
        CompanyDTO company = companydao.companyView(companyCode);
        mav.setViewName("Company/CompanyModifyForm");
        mav.addObject("modi", company);
        return mav;
    }

    @Override
    public ModelAndView companyModify(CompanyDTO company) throws IllegalStateException, IOException {
        MultipartFile companyPhoto = company.getCompanyPhoto();

        String originalFileName = companyPhoto.getOriginalFilename();

        // 0번째 부터 8번째 자리의 문자까지만 랜덤으로 붙이겠다.
        String uuid = UUID.randomUUID().toString().substring(0, 8);

        String companyPhotoName = uuid + "_" + originalFileName;

        // 파일 저장 위치 설정
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/CompanyPhoto");
        String savePath = path + "/" + companyPhotoName;

        // 파일 선택 여부
        if(!companyPhoto.isEmpty()) {
            company.setCompanyPhotoName(companyPhotoName);
            companyPhoto.transferTo(new File(savePath));
        } else {
            company.setCompanyPhotoName("default.png");
        }

        int result = companydao.companyModify(company);

        if (result > 0) {
            mav.setViewName("redirect:/Company/CompanyView?companyCode=" + company.getCompanyCode());
        } else {
            mav.setViewName("index");
        }
        return mav;
    }

    @Override
    public ModelAndView companyDelete(String companyCode) {
        int result = companydao.companyDelete(companyCode);

        if(result>0){
            mav.setViewName("index");
        } else {
            mav.setViewName("index");
        }
        return mav;
    }
}

package com.gym.GYM.trainingplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.trainingplan.dto.TrainingPlanDTO;
import com.gym.GYM.trainingplan.service.TrainingPlanService;

@Controller
public class TrainingPlanController {

    @Autowired
    private TrainingPlanService trainingsvc;

    private ModelAndView mav = new ModelAndView();


    // 운동견적 작성 페이지 : trainingPlanForm
    @GetMapping("/trainingPlanForm")
    public String trainingPlanForm(){

        return "index";

        //TODO  페이지 지정하기
    }

    @GetMapping("/trainingPlanRegistForm")
    public String trainingPlanRegistForm(){

        return "TrainingPlan/TrainingPlanRegistForm";

        //TODO  페이지 지정하기
    }
    // 운동견적 작성 메소드 : trainingPlanRegist
    @PostMapping("/trainingPlanRegist")
    public ModelAndView trainingPlanRegist(@ModelAttribute TrainingPlanDTO trainingplan){

    	 mav = trainingsvc.trainingPlanRegist(trainingplan);

        return mav;
    }

    // 운동견적 상세보기 메소드 : trainingPlanView
    @GetMapping("/trainingPlanView")
    public ModelAndView trainingPlanView(@RequestParam("trainingPlanCode") String trainingPlanCode){

        mav = trainingsvc.trainingPlanView(trainingPlanCode);

        return mav;

        //TODO 코드로 받아오기
    }

    // 개인 운동견적 리스트 메소드 : trainingPlanList
    @GetMapping("/trainingPlanList")
    public ModelAndView trainingPlanList(){

        mav = trainingsvc.trainingPlanList();

        return mav;
    }
    // 운동견적 수정페이지 메소드 : trainingPlanModifyForm
    @GetMapping("/trainingPlanModifyForm")
    public ModelAndView trainingPlanModifyForm(@RequestParam("trainingPlanCode")String trainingPlanCode){

        mav = trainingsvc.trainingPlanModifyForm(trainingPlanCode);

        return mav;

    }

    // 운동견적 수정 메소드 : trainingPlanModify
    @PostMapping("/trainingPlanModify")
    public ModelAndView trainingPlanModify(@ModelAttribute TrainingPlanDTO trainingplandto){

        mav = trainingsvc.trainingPlanModify(trainingplandto);

        return mav;

    }

    // 운동견적 삭제 메소드 : trainingPlanDelete
    @GetMapping("/trainingPlanDelete")
    public ModelAndView trainingPlanDelete(@RequestParam("trainingPlanCode")String trainingPlanCode){

        mav = trainingsvc.trainingPlanDelete(trainingPlanCode);

        return mav;
    }

}

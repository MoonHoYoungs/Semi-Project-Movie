package com.gym.GYM.trainingplan.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.trainingplan.dao.TrainingPlanDAO;
import com.gym.GYM.trainingplan.dto.TrainingPlanDTO;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService{

    @Autowired
    private TrainingPlanDAO trainingplandao;

    private ModelAndView mav = new ModelAndView();
    @Override
    public ModelAndView trainingPlanRegist(TrainingPlanDTO trainingplan) {

        int result = trainingplandao.trainingPlanRegist(trainingplan);

        if(result>0){
            mav.setViewName("index");
        } else {
            mav.setViewName("index");
        }

        return mav;
    }

    @Override
    public ModelAndView trainingPlanView(String trainingPlanCode) {

        TrainingPlanDTO trainingplan = trainingplandao.trainingPlanView(trainingPlanCode);

        mav.addObject("trainingPlanView", trainingplan);
        mav.setViewName("TrainingPlan/TrainingPlanView");
        return mav;
    }

    @Override
    public ModelAndView trainingPlanList() {

        List<TrainingPlanDTO> trainingPlanList = trainingplandao.trainingPlanList();

        mav.setViewName("TrainingPlan/TrainingPlanList");
        mav.addObject("trainingPlanList", trainingPlanList);

        return mav;
    }

    @Override
    public ModelAndView trainingPlanModifyForm(String trainingPlanCode) {

        TrainingPlanDTO traininplan = trainingplandao.trainingPlanView(trainingPlanCode);

        mav.setViewName("TrainingPlan/TrainingPlanModifyForm");
        mav.addObject("trainingPlanModifyForm", traininplan);

        return mav;
    }

    @Override
    public ModelAndView trainingPlanModify(TrainingPlanDTO trainingplan) {

        int result = trainingplandao.trainingPlanModify(trainingplan);

        if(result>0){
            mav.setViewName("redirect:/trainingPlanView?trainingPlanCode=" + trainingplan.getTrainingPlanCode());
        } else {
            mav.setViewName("redirect:/trainingPlanList");
        }

        return mav;
    }

    @Override
    public ModelAndView trainingPlanDelete(String trainingPlanCode) {

        int result = trainingplandao.trainingPlanDelete(trainingPlanCode);

        if(result>0){
            mav.setViewName("redirect:/trainingPlanList");
        } else {
            mav.setViewName("index");

            //TODO 삭제실패시 화면 어떻게할지..
        }
        return mav;
    }
}

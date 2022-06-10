package com.gym.GYM.trainingplan.service;



import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.trainingplan.dto.TrainingPlanDTO;

public interface TrainingPlanService {
    ModelAndView trainingPlanRegist(TrainingPlanDTO trainingplan);

    ModelAndView trainingPlanView(String trainingPlanCode);

    ModelAndView trainingPlanList();

    ModelAndView trainingPlanModifyForm(String trainingPlanCode);

    ModelAndView trainingPlanModify(TrainingPlanDTO trainingplan);

    ModelAndView trainingPlanDelete(String trainingPlanCode);
}

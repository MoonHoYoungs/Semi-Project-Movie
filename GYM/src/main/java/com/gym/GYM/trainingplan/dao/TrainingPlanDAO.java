package com.gym.GYM.trainingplan.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gym.GYM.trainingplan.dto.TrainingPlanDTO;

@Mapper
public interface TrainingPlanDAO {
    int trainingPlanRegist(TrainingPlanDTO trainingplan);

    TrainingPlanDTO trainingPlanView(String trainingPlanCode);

    List<TrainingPlanDTO> trainingPlanList();

    int trainingPlanModify(TrainingPlanDTO trainingplan);

    int trainingPlanDelete(String trainingPlanCode);
}

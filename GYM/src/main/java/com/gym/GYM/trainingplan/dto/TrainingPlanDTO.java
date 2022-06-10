package com.gym.GYM.trainingplan.dto;


import org.apache.ibatis.type.Alias;

@Alias("TrainingPlan")
public class TrainingPlanDTO {

    private String trainingPlanCode;
    private String trainingPlanId;
    private String trainingPlanPurpose;
    private String trainingPlanGrade;
    private String trainingPlanMyRoutineCode;
    private String trainingPlanMyMealCode;
	public String getTrainingPlanCode() {
		return trainingPlanCode;
	}
	public void setTrainingPlanCode(String trainingPlanCode) {
		this.trainingPlanCode = trainingPlanCode;
	}
	public String getTrainingPlanId() {
		return trainingPlanId;
	}
	public void setTrainingPlanId(String trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}
	public String getTrainingPlanPurpose() {
		return trainingPlanPurpose;
	}
	public void setTrainingPlanPurpose(String trainingPlanPurpose) {
		this.trainingPlanPurpose = trainingPlanPurpose;
	}
	public String getTrainingPlanGrade() {
		return trainingPlanGrade;
	}
	public void setTrainingPlanGrade(String trainingPlanGrade) {
		this.trainingPlanGrade = trainingPlanGrade;
	}
	public String getTrainingPlanMyRoutineCode() {
		return trainingPlanMyRoutineCode;
	}
	public void setTrainingPlanMyRoutineCode(String trainingPlanMyRoutineCode) {
		this.trainingPlanMyRoutineCode = trainingPlanMyRoutineCode;
	}
	public String getTrainingPlanMyMealCode() {
		return trainingPlanMyMealCode;
	}
	public void setTrainingPlanMyMealCode(String trainingPlanMyMealCode) {
		this.trainingPlanMyMealCode = trainingPlanMyMealCode;
	}
	@Override
	public String toString() {
		return "TrainingPlanDTO [trainingPlanCode=" + trainingPlanCode + ", trainingPlanId=" + trainingPlanId
				+ ", trainingPlanPurpose=" + trainingPlanPurpose + ", trainingPlanGrade=" + trainingPlanGrade
				+ ", trainingPlanMyRoutineCode=" + trainingPlanMyRoutineCode + ", trainingPlanMyMealCode="
				+ trainingPlanMyMealCode + "]";
	}
    
    




}

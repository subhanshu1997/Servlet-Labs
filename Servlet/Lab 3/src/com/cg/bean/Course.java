package com.cg.bean;

public class Course {
	long trainingId;
	String trainingName;
	int availableSeats;
	public Course(long trainingId,String trainingName,int availableSeats) {
		this.availableSeats=availableSeats;
		this.trainingId=trainingId;
		this.trainingName=trainingName;
	}
	public long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "Course [trainingId=" + trainingId + ", trainngName="
				+ trainingName + ", availableSeats=" + availableSeats + "]";
	}
}

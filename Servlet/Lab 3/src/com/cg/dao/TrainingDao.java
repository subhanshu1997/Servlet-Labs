package com.cg.dao;

import java.util.HashMap;

import com.cg.bean.Course;

public interface TrainingDao {
	public HashMap<Integer,Course> showTraining();
	public void bookSeat(String name);
}

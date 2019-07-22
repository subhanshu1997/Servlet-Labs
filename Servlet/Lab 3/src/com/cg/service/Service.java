package com.cg.service;

import java.util.HashMap;

import com.cg.bean.Course;

public interface Service {
	public HashMap<Integer,Course> showTraining();
	public void bookSeat(String name);
}

package com.cg.service;

import java.util.HashMap;

import com.cg.bean.Course;
import com.cg.dao.TrainingDao;
import com.cg.dao.TrainingDaoImpl;

public class ServiceImpl implements Service{
	public HashMap<Integer,Course> showTraining(){
		TrainingDao td=new TrainingDaoImpl();
		HashMap<Integer,Course> hm=td.showTraining();
		return hm;
	}

	@Override
	public void bookSeat(String name) {
		TrainingDao td=new TrainingDaoImpl();
		td.bookSeat(name);
		
	}
}

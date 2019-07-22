package com.cg.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.cg.Util.DBUtil;
import com.cg.bean.Course;

public class TrainingDaoImpl implements TrainingDao{
	public static HashMap<Integer,Course> hm=new HashMap<Integer,Course>();
	Connection con=null;
	@Override
	public HashMap<Integer, Course> showTraining() {
		con=DBUtil.getConnect();
		Statement stmt;
		try {stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from training");
			while(rs.next()){
				int trainingId=rs.getInt("trainingid");
				String trainingName=rs.getString("trainingname");
				int availableSeats=rs.getInt("availableseats");
				Course c=new Course(trainingId, trainingName, availableSeats);
				hm.put(trainingId,c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return hm;		
	}
	@Override
	public void bookSeat(String name) {
		PreparedStatement stmt;
		con=DBUtil.getConnect();
		try{
			stmt=con.prepareStatement("update training set availableseats=availableseats-1 where trainingname=?");
			stmt.setString(1,name);
			int a=stmt.executeUpdate();
			System.out.println("Hi you have successfully enrolled for "+name +" Training.");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}

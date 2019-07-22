package com.cg.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.cg.bean.Course;
import com.cg.dao.TrainingDao;
import com.cg.dao.TrainingDaoImpl;
import com.cg.service.Service;
import com.cg.service.ServiceImpl;

/**
 * Servlet implementation class ShowTraining
 */
@WebServlet("/ShowTraining")
public class ShowTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTraining() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HttpServletResponse response;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("Show.jsp");
			Service service=new ServiceImpl();
			HashMap<Integer,Course> hm=service.showTraining();
			PrintWriter out = response.getWriter();
			out.println("<form action=\"ShowTraining?action=index\" method=\"post\">");
			ArrayList<Course> al=new ArrayList<Course>(hm.values());
			out.println("<table border=\"1\">");
			out.println("<tr><td><b>TrainingId</b></td>");
			out.println("<td><b>TrainingName</b></td>");
			out.println("<td><b>AvailableSeats</b></td>");
			out.println("<td><b>Enroll</b></td></tr>");
			out.println("<tr><td>"+al.get(0).getTrainingId()+"</td>"+"<td>"+al.get(0).getTrainingName()+"</td>"+"<td>"+al.get(0).getAvailableSeats()+"</td>");
			out.print("<td><button type=\"submit\" name=\"button\" value=\"Spring\">Spring</button>"+"</td></tr></br>");
			out.println("<tr><td>"+al.get(1).getTrainingId()+"</td>"+"<td>"+al.get(1).getTrainingName()+"</td>"+"<td>"+al.get(1).getAvailableSeats()+"</td>");
			out.print("<td><button type=\"submit\" name=\"button\" value=\"Hibernate\">Hibernate</button>"+"</td></tr><br>");
			out.println("<tr><td>"+al.get(2).getTrainingId()+"</td>"+"<td>"+al.get(2).getTrainingName()+"</td>"+"<td>"+al.get(2).getAvailableSeats()+"</td>");
			out.println("<td><button type=\"submit\" name=\"button\" value=\"EJB\">EJB</button></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.flush();
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service=new ServiceImpl();
		HashMap<Integer,Course> hm=service.showTraining();
		ArrayList<Course> al=new ArrayList<Course>(hm.values());
		if(request.getParameter("action").equals("index")){
			if(request.getParameter("button").equals("Spring") && al.get(0).getAvailableSeats()>0){
				service.bookSeat(request.getParameter("button"));
			}
			else if(request.getParameter("button").equals("Hibernate") && al.get(1).getAvailableSeats()>0){
				service.bookSeat(request.getParameter("button"));
			}
			else if(request.getParameter("button").equals("EJB") && al.get(2).getAvailableSeats()>0){
				service.bookSeat(request.getParameter("button"));
			}
			else{
				System.out.println("NO SEATS AVAILABLE");
			}
		}
		this.doGet(request, response);
	}

}

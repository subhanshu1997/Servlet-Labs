package com.cg.controller;

import java.io.Console;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Problem
 */
@WebServlet("/Problem")
public class Problem extends HttpServlet {
	static String username="Subhanshu";
	static String password="hello123";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Problem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		RequestDispatcher rdSuccess=request.getRequestDispatcher("Success.html");
		RequestDispatcher rdFail=request.getRequestDispatcher("Fail.html");
		if(user.equals(username) && pass.equals(password)){
			rdSuccess.forward(request,response);
		}
		else{
			rdFail.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		RequestDispatcher rdSuccess=request.getRequestDispatcher("Success.html");
		RequestDispatcher rdFail=request.getRequestDispatcher("Fail.html");
		if(user.equals(username) && pass.equals(password)){
			rdSuccess.forward(request,response);
		}
		else{
			rdFail.forward(request,response);
		}
	}

}

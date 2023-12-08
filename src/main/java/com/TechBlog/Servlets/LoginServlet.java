package com.TechBlog.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TechBlog.dao.UserDao;
import com.TechBlog.entity.Message;
import com.TechBlog.entity.User;
import com.TechBlog.helper.ConnectionProvider;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				response.setContentType("text/html;charset=UTF-8");
				try(PrintWriter out = response.getWriter()){
					
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Servlet LoginServlet</title>");
					out.println("</head>");
					out.println("<body>");
					
					//login
					//fetch username amd password from request
					String userEmail = request.getParameter("email");
					String userPassword = request.getParameter("password");
					
					UserDao dao = new UserDao(ConnectionProvider.getConnection());
					
					User u = dao.getUserByEmailAndPassword(userEmail, userPassword);
					
					if(u == null) {
						//login...
						//error
//						out.println("Invalid Details..try again");
						Message msg = new Message("Invalid Details ! try with another","error","alert-danger");
						HttpSession s =  request.getSession();
						s.setAttribute("msg",msg);
						
						response.sendRedirect("login.jsp");
					}else {
						//login success
						HttpSession s = request.getSession();
						s.setAttribute("currentUser", u);
						response.sendRedirect("profile.jsp");
					}
					
					out.println("</body>");
					out.println("</html>");
				}
			}

}

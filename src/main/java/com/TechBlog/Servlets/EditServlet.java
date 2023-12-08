package com.TechBlog.Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.TechBlog.dao.UserDao;
import com.TechBlog.entity.Message;
import com.TechBlog.entity.User;
import com.TechBlog.helper.ConnectionProvider;
import com.TechBlog.helper.Helper;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet EditServlet</title>");
			out.println("</head>");
			out.println("<body>");
			
			//fetch all data
			String userEmail = request.getParameter("user-email");
			String userName = request.getParameter("user-name");
			String userPassword = request.getParameter("user-password");
			String userAbout = request.getParameter("user-about");
			Part part = request.getPart("image");
			String imageName = part.getSubmittedFileName();
			
			//get the user from the session..
			HttpSession s = request.getSession();
			User user = (User) s.getAttribute("currentUser");
			user.setEmail(userEmail);
			user.setName(userName);
			user.setPassword(userPassword);
			user.setAbout(userAbout);
			String oldFile = user.getProfile();
			user.setProfile(imageName);
			
			//update database...
			UserDao userDao = new UserDao(ConnectionProvider.getConnection());
			
			boolean ans = userDao.updateUser(user);
			if(ans) {
				
				String path = request.getRealPath("/")+"pics"+File.separator + user.getProfile();
				
				
				//delete code
				String pathOldFile = request.getRealPath("/")+"pics"+File.separator + oldFile;
				
				if(!oldFile.equals("default.png")) {
					Helper.deleteFile(pathOldFile);
					
				}
				
				if(Helper.saveFile(part.getInputStream(), path)) {
						out.println("profile updated...");	
						Message msg = new Message("profile details updated...","success","alert-success");
						s.setAttribute("msg",msg);
						
				}else {
					Message msg = new Message("Something went wrong...","error","alert-error");
					s.setAttribute("msg",msg);
					}
				
			}else {
				Message msg = new Message("Something went wrong...","error","alert-error");
				s.setAttribute("msg",msg);
			}
			
			response.sendRedirect("profile.jsp");
			
			
			
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}

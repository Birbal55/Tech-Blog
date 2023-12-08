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

import com.TechBlog.dao.PostDao;
import com.TechBlog.dao.UserDao;
import com.TechBlog.entity.Message;
import com.TechBlog.entity.Post;
import com.TechBlog.entity.User;
import com.TechBlog.helper.ConnectionProvider;
import com.TechBlog.helper.Helper;

/**
 * Servlet implementation class AddPostServlet
 */
@MultipartConfig
@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			int cid = Integer.parseInt(request.getParameter("cid"));
			String pTitle = request.getParameter("pTitle");
			String pContent = request.getParameter("pContent");
			String pCode = request.getParameter("pCode");
			Part part = request.getPart("pic");
			
			//getting currentUser id
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currentUser");
			
			//out.println("your post title is " + pTitle);
			//out.println(part.getSubmittedFileName());
			
			Post p = new Post(pTitle,pContent,pCode,part.getSubmittedFileName(),null,cid,user.getId());
			PostDao dao = new PostDao(ConnectionProvider.getConnection());
			if(dao.savePost(p)) {
				String path = request.getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
				Helper.saveFile(part.getInputStream(), path);
				out.println("done");
			}else {
				out.println("error");
			}
		}
	}

}

package me.qinyang.drp.sysmgr.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.qinyang.drp.sysmgr.domain.User;
import me.qinyang.drp.sysmgr.manager.UserManager;

public  class UserAddServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(password);
		user.setContactTel(phone);
		user.setEmail(email);
		UserManager.getInstance().addUser(user);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("添加成功");
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}

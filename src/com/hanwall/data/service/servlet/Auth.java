package com.hanwall.data.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanwall.data.source.bean.Account;
import com.hanwall.data.source.jdbc.QueryData;
import com.hanwall.data.utils.Config;
import com.hanwall.data.utils.MD5_Test;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter  wirte = response.getWriter();
	String passwd = request.getParameter("passwd");
	String value = Config.authtoken;
	if(value.equals(MD5_Test.MD5(passwd))) {
		List<Account> list = QueryData.query();
		
		request.setAttribute("account", list);
		request.setAttribute("haha", "do value success");
		request.getRequestDispatcher("./list.jsp").forward(request,response); 
	}else {
		wirte.println("login failed");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

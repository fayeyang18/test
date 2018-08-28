package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SqlUtil;
import com.google.gson.Gson;

/**
 * Servlet implementation class login
 */
@WebServlet("/Servlet/login")
public class login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String utel=req.getParameter("utel");
		String pword=req.getParameter("pword");
		String sql="select * from userlogin where usertel=? and userpsw =?";
		ArrayList list =SqlUtil.select(sql,utel,pword);
		SqlUtil.close();
		HashMap<String,String> result =new HashMap<String,String>();
		if(list.size()>0) {
			result.put("status","success");
			result.put("message","查询正确");
		}
		else {
			result.put("status","failure");
			result.put("message","手机号或者密码输入不正确");
		}
		Gson gson=new Gson();
		String json=gson.toJson(result);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		resp.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		resp.getWriter().write(json);
		resp.getWriter().close();
	}

}

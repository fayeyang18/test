package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import utils.SqlUtil;

@WebServlet("/web/del")
public class UserdelServlet extends HttpServlet{
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		System.out.println(id);
		String sql = "delete from my_user where id=?";
		SqlUtil.update(sql,id);
		
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		resp.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
	}
}

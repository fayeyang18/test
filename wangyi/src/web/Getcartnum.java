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
@WebServlet("/Servlet/getcartnum")
public class Getcartnum extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String utel = req.getParameter("utel");
		String sql="select * from my_cart where usertel=?";
		ArrayList<HashMap<String, Object>> list =SqlUtil.select(sql,utel);
		SqlUtil.close();
		int a = list.size();
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		result.put("num",a);
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

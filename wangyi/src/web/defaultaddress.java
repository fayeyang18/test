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

/**
 * Servlet implementation class defaultaddress
 */
@WebServlet("/defaultaddress")
public class defaultaddress extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("utel");
		String sql = "select * from address where utel=?";
		ArrayList<HashMap<String,Object>> list =SqlUtil.select(sql,id);
		Gson gson  = new Gson();
		String jsoin = gson.toJson(list);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		resp.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		resp.getWriter().write(jsoin);
		resp.getWriter().close();

}
}

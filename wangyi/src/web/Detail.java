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
@WebServlet("/user/detail")
public class Detail extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pro_id=req.getParameter("pro_id");
		String sql="select * from detail where pro_id=?";
		ArrayList list =SqlUtil.select(sql,pro_id);
		System.out.println(list);
		SqlUtil.close();
		Gson gson=new Gson();
		String json=gson.toJson(list);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		resp.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		resp.getWriter().write(json);
		resp.getWriter().close();
	}

}

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
import com.google.gson.JsonElement;

/**
 * Servlet implementation class login
 */
@WebServlet("/dingdan")
public class Dingdan extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String utel=req.getParameter("utel");
		String id = req.getParameter("p_id");
		System.out.println(id);
		ArrayList list=null;
		String sql="SELECT * from my_order left OUTER  JOIN detail on my_order.goods_id=detail.pro_id WHERE my_order.utel=? and my_order.goods_id=?";
		list =SqlUtil.select(sql,utel,id);
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

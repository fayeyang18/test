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
@WebServlet("/dingdan2")
public class Dingdan2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String utel=req.getParameter("utel");
		
		ArrayList list=null;
		String sql="SELECT * from my_order left OUTER  JOIN my_cart on my_order.utel=my_cart.usertel WHERE my_order.utel=?";
		list =SqlUtil.select(sql,utel);
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

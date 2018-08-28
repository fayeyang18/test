package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
@WebServlet("/submit")
public class Submitdata extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String utel = req.getParameter("utel");
		String id=req.getParameter("id");
		System.out.println(id);
		String num=req.getParameter("num");
		HashMap map =new HashMap();
		try{
			String sql="INSERT INTO my_order (order_id, utel, order_date, goods_id, num) VALUES (null, ?, now(), ?, ?)";
			SqlUtil.update(sql,utel,id,num);
			SqlUtil.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		String sql="select * from address where utel=?";
		ArrayList list =SqlUtil.select(sql,utel);
		SqlUtil.close();
		if(list.size()>0)
		{
			map.put("status", "success");
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		Gson gson =new Gson();
		String json=gson.toJson(map);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		resp.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
		PrintWriter  writer  =resp.getWriter();
		writer.print(json);
		writer.close();
		
		
	}

}

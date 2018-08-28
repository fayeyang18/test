package web;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/address")
public class address extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pro=req.getParameter("province");
		String city=req.getParameter("citys");
		String dis=req.getParameter("area");
		String uname=req.getParameter("uname");
		String utel=req.getParameter("utel");
		String udetail=req.getParameter("udetail");
		String utelphone=req.getParameter("utelphone");
		String sql="insert into address(addr_id,user_name,user_tel,user_pro,user_city,user_area,detail_addr,utel) values (null,?,?,?,?,?,?,?)";

		System.out.println(sql);
		HashMap<String,String> result =new HashMap<String,String>();
		try{
			SqlUtil.update(sql,uname,utel,pro,city,dis,udetail,utelphone);
			result.put("status","success");
			result.put("message","查询正确");
			
		}catch(Exception ex){
			result.put("status","failure");
			result.put("message","输入不正确");
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

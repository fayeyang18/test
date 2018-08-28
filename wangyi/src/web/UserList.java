//package org.lanqiao.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import utils.SqlUtil;
//
//import com.google.gson.Gson;
//
//
//@WebServlet("/user/valid")
//public class UserList  extends HttpServlet{
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String username =request.getParameter("username");
//		//根据用户名统计数量
//		String sql ="select count(*) as  sl from user where username=?";
//		HashMap map =new HashMap();
//		
//		try{
//			List<HashMap<String,Object>> list =SqlUtil.executeQuery(sql, username);
//			if(list.size()>0){
//				HashMap m  =list.get(0);
//				Integer i  =Integer.valueOf(m.get("sl").toString());
//				if(i.intValue()>0){
//					map.put("info", "已经存在");
//				}else{
//					map.put("info", "该用户可以注册");
//				}
//			}
//			
//			
//		}catch(Exception ex){
//			map.put("info", "查询异常 ");
//			ex.printStackTrace();
//		}
//		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json");
//		Gson gson =new Gson();
//		String json=gson.toJson(map);
//		PrintWriter  writer  =response.getWriter();
//		writer.print(json);
//		writer.close();
//		
//	}
//}

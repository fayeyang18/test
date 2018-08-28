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

import com.google.gson.Gson;

import utils.SqlUtil;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/user/register")
public class registerServlet extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		String utel=req.getParameter("utel");
//		String pword=req.getParameter("pword");
//		String sql="select * from userlogin where usertel=? and userpsw=?";
//		ArrayList list =SqlUtil.(sql,utel,pword);
//		SqlUtil.close();
//		HashMap<String,String> result =new HashMap<String,String>();
//		if(list.size()>0) {
//			result.put("status","success");
//			result.put("message","��ѯ��ȷ");
//		}
//		else {
//			result.put("status","failure");
//			result.put("message","���벻��ȷ");
//		}
//		Gson gson=new Gson();
//		String json=gson.toJson(result);
//		resp.setHeader("Access-Control-Allow-Origin", "*");
//		resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
//		resp.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
//		
//		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("application/json");
//		resp.getWriter().write(json);
//		resp.getWriter().close();
//	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String usertel =request.getParameter("usertel");
		String userpsw =request.getParameter("userpsw");
		//�����û���ͳ������
		String sql ="select count(*) as  sl from userlogin where usertel=?";
		String sql1 ="insert into userlogin(usertel,userpsw) values (?,?)";
		HashMap map =new HashMap();
		try{
			List<HashMap<String,Object>> list =SqlUtil.select(sql, usertel);
			if(list.size()>0){
				HashMap m  =list.get(0);
				Integer i  =Integer.valueOf(m.get("sl").toString());
				if(i.intValue()>0){
					map.put("status","failure");
					map.put("info", "*���ֻ����ѱ�ע��");
				}else{
					SqlUtil.update(sql1,usertel,userpsw);
					map.put("status","success");
					map.put("info", "ע��ɹ�");
				}
			}
			
			
		}catch(Exception ex){
			map.put("info", "��ѯ�쳣 ");
			ex.printStackTrace();
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		Gson gson =new Gson();
		String json=gson.toJson(map);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		response.setHeader("Access-Control-Max-Age", "POST,GET,DELETE,PUT");
		PrintWriter  writer  =response.getWriter();
		writer.print(json);
		writer.close();
		
	}

}

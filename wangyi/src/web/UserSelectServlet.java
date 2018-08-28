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
 * Servlet implementation class UserSelectServlet
 */
@WebServlet("/user/select")
public class UserSelectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//…Ë÷√±‡¬Î
				req.setCharacterEncoding("utf-8");
				String id=req.getParameter("id");
				
				String sql="select * from my_user";
				ArrayList<HashMap<String, Object>> list = SqlUtil.select(sql);
				//SqlUtil.close();
				Gson gson=new Gson();
				String json =gson.toJson(list);
				resp.setHeader("Access-Control-Allow-Origin", "*");
				resp.setHeader("Access-Control-Allow-Methods","POST,GET,DELETE,PUT");
				resp.setHeader("Access-Control-Max-Age","POST,GET,DELETE,PUT");
				
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("application/json");
				//System.out.println(json);
				resp.getWriter().write(json);
				resp.getWriter().close();
	}
}

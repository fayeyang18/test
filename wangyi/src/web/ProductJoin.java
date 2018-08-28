package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import utils.SqlUtil;

/**
 * Servlet implementation class ProductJoin
 */
@WebServlet("/product/join")
public class ProductJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取加入购物车的商品的ID和数量
		String id =request.getParameter("id");
		String img =request.getParameter("colorimg");
		String name =request.getParameter("name");
		String num =request.getParameter("num");
		String price =request.getParameter("price");
		String utel=request.getParameter("utel");
		String size =request.getParameter("size");
		
		//像购物车表插入记录,默认购买一件，暂时不考虑重复性，状态是0表示没有支付
		String sql ="insert into my_cart(id,img,name,num,price,usertel,size) values (null,?,?,?,?,?,?)";
		HashMap map =new HashMap();
		try{
			SqlUtil.update(sql,img,name,num,price,utel,size);
			map.put("status", "success");
			map.put("info", "已经加入购物车");
		}catch(Exception ex){
//			map.put("status", "failure");
//			map.put("info", "加入购物车异常 ");
//			ex.printStackTrace();
		}
		System.out.println(map);
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

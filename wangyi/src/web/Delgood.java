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
@WebServlet("/delgood")
public class Delgood extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String utel=req.getParameter("utel");
		String id=req.getParameter("id");
		String sql="delete from my_cart where usertel=? and id=?";
		SqlUtil.update(sql,utel,id);
		SqlUtil.close();
	}

}

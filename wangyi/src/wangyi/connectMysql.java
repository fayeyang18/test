package wangyi;

import java.util.ArrayList;

import com.google.gson.Gson;

import utils.SqlUtil;

public class connectMysql {
	public static void main(String[] args) {
		String sql="select * from product";
		ArrayList list = SqlUtil.select(sql);
		SqlUtil.close();
		Gson gson=new Gson();
		String json =gson.toJson(list);
		System.out.println(json);
		
		String sql2="select * from product";
	}
}

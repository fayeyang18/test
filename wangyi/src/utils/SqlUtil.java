package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;

/**
 * 
 * 
 * @author songzt@lanqiao.org
 *
 */
public class SqlUtil {
	
	private  static  final  String  DRIVER="driver";
	private  static  final  String  URL ="url";
	private  static  final  String  USERNAME="username";
	private  static  final  String  PASSWORD="password";
	static  Properties proper =new Properties();
	//���ر���  �����̱߳���
	static  ThreadLocal<Connection>   container=new  ThreadLocal<Connection>();
	//����
	static{
		
		try {
			//ͨ��������� ���������·���µ����������ļ�
			proper.load(SqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//1����������
	static {
		try {
			Class.forName(proper.getProperty(DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2����ȡ����
	public static Connection   getConnection(){
		Connection  conn =container.get();
		try {
			if(conn==null  || conn.isClosed()){
				conn =	DriverManager.getConnection(proper.getProperty(URL),
						proper.getProperty(USERNAME),proper.getProperty(PASSWORD));
				container.set(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  conn;
	}
	//ִ��DQL��� ResultSet �ر�֮�� �����޷�ȡ������
	public  static ArrayList<HashMap<String,Object>>    select2(String sql,Object [] params){
		ArrayList<HashMap<String,Object>>  list=new  ArrayList<HashMap<String,Object>>();
		Connection conn =	getConnection();
		PreparedStatement pst=null;
		ResultSet  rs=null;
		try {
			pst  =	conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			rs =  pst.executeQuery();
			//����ResultSet ������HashMap ��ArrayList�����  һ������HashMap ����������ArrayList
			int count = rs.getMetaData().getColumnCount(); //��ȡ�е�����
			while(rs.next()){
				HashMap<String ,Object>  row =new  HashMap<String ,Object> ();
				for(int i=0;i<count;i++){
					String key =rs.getMetaData().getColumnLabel(i+1);
					Object  value =rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new  RuntimeException(e);
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  list;
		
		
	}
	
	//ִ��DQL��� ResultSet �ر�֮�� �����޷�ȡ������
	public  static ArrayList<HashMap<String,Object>>    select(String sql,Object ... params){
		ArrayList<HashMap<String,Object>>  list=new  ArrayList<HashMap<String,Object>>();
		Connection conn =	getConnection();
		PreparedStatement pst=null;
		ResultSet  rs=null;
		try {
			pst  =	conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			rs =  pst.executeQuery();
			//����ResultSet ������HashMap ��ArrayList�����  һ������HashMap ����������ArrayList
			int count = rs.getMetaData().getColumnCount(); //��ȡ�е�����
			while(rs.next()){
				HashMap<String ,Object>  row =new  HashMap<String ,Object> ();
				for(int i=0;i<count;i++){
					String key =rs.getMetaData().getColumnLabel(i+1);
					Object  value =rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new  RuntimeException(e);
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  list;
		
		
	}
	
	
	//ִ��DML���
	public  static int    update(String sql,Object ... params){
		Connection conn =	getConnection();
		int row=0;
		PreparedStatement pst=null;
		
		try {
			pst  =	conn.prepareStatement(sql);
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			row =  pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new  RuntimeException(e);
		}finally {
			if(pst!=null){
				try {
					pst.close();
					pst=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  row;
		
		
	}
	//ִ��DML���
	public  static int    update2(String sql,Object [] params){
			Connection conn =	getConnection();
			int row=0;
			PreparedStatement pst=null;
			
			try {
				pst  =	conn.prepareStatement(sql);
				if(params!=null){
					for(int i =0;i<params.length;i++){
						pst.setObject(i+1, params[i]);
					}
				}
				row =  pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw  new  RuntimeException(e);
			}finally {
				if(pst!=null){
					try {
						pst.close();
						pst=null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return  row;
			
			
		}
		
	//�ر���Դ
	public  static void   close(){
		if(container.get()!=null){
			try {
				container.get().close();
				container.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}

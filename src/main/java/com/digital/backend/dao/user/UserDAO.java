package com.digital.backend.dao.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.digital.backend.bean.user.BackendUserBean;

public class UserDAO {
	private UserDAO userDAO = null;
	
	public UserDAO(){
		
	}
	
	public UserDAO getInstance(){
		return (userDAO == null) ? new UserDAO() : userDAO;
	}
	
	private BackendUserBean getBackUser(String user_email){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		BackendUserBean backUserBean = null;
		
		try{			
			conn = DriverManager.getConnection("proxool.digital"); 
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
			String sql="select * from digital_users where user_email = " + user_email;
			rs=stmt.executeQuery(sql);   
			
			if(rs.next()){
				backUserBean = new BackendUserBean();
				backUserBean.setUser_id(rs.getInt("user_id"));
				backUserBean.setUser_email(rs.getString("user_email"));
				backUserBean.setUser_name(rs.getString("user_name"));
				backUserBean.setUser_create_date(rs.getString("user_create_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{				
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){}
		}
		
		return backUserBean;
	}
}

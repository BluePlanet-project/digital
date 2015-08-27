package com.digital.backend.dao.backmenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.digital.backend.bean.backmenu.BackMenuBean;

public class BackMenuDAO {
	private static BackMenuDAO backMenuDAO;
	private BackMenuDAO(){}
	
	public synchronized static BackMenuDAO getInstance(){
		return backMenuDAO == null ? new BackMenuDAO() : backMenuDAO;
	}
	
	public ArrayList<BackMenuBean> getMenu() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BackMenuBean> list = new ArrayList<BackMenuBean>();
		
		try{
			StringBuffer sql = new StringBuffer();
			sql.append("select digital_back_menu.menu_id,digital_back_menu.authority_id,digital_back_menu.enabled, digital_authority.authority_name, digital_authority.authority_name_cht, digital_authority.authority_target ")
				.append(" from digital_back_menu, digital_authority")
				.append(" where digital_back_menu.authority_id = digital_authority.authority_id order by digital_back_menu.menu_id ");
			
			conn = DriverManager.getConnection("proxool.digital"); 
			pstmt= conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BackMenuBean bean = new BackMenuBean();
				bean.setMenu_id(rs.getInt("menu_id"));
				bean.setAuthority_id(rs.getInt("authority_id"));
				bean.setMenu_name(rs.getString("authority_name_cht"));
				bean.setMenu_name_enu(rs.getString("authority_name"));
				bean.setEnabled(rs.getInt("enabled"));
				bean.setTarget(rs.getString("authority_target"));
				list.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		return list;
	}
}

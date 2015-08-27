package com.digital.common.dao.breadcrumb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.digital.common.bean.breadcrumb.BreadCrumbBean;

public class BreadCrumbDAO {
	private static BreadCrumbDAO breadCrumbDAO = null;
	private BreadCrumbDAO(){}
	
	public static synchronized BreadCrumbDAO getInstance(){
		return (breadCrumbDAO == null) ? new BreadCrumbDAO() : breadCrumbDAO;
	}
	
	public ArrayList<BreadCrumbBean> getAllBreadByLevel(int level) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BreadCrumbBean> list = new ArrayList<BreadCrumbBean>();
		
		try{
			String sql = "select * from digital_breadcrumb where breadcrumb_level = ? ";
			conn = DriverManager.getConnection("proxool.digital"); 
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, level);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BreadCrumbBean bean = new BreadCrumbBean();
				bean.setId(rs.getInt("id"));
				bean.setBreadcrumb_id(rs.getInt("breadcrumb_id"));
				bean.setBreadcrumb_lang_id(rs.getInt("breadcrumb_lang_id"));
				bean.setBreadcrumb_name(rs.getString("breadcrumb_name"));
				bean.setBreadcrumb_url(rs.getString("breadcrumb_url"));
				bean.setBreadcrumb_enabled(rs.getBoolean("breadcrumb_enabled"));
				bean.setBreadcrumb_level(rs.getInt("breadcrumb_level"));
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

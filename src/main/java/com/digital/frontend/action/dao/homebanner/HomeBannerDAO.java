package com.digital.frontend.action.dao.homebanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.digital.frontend.common.bean.CommonDataBean;
import com.digital.frontend.action.dao.homebanner.HomeBannerDAO;

public class HomeBannerDAO {
	private static HomeBannerDAO homebannerDAO;
	
	private HomeBannerDAO(){}
	
	public synchronized static HomeBannerDAO getInstance(){
		return homebannerDAO == null ? new HomeBannerDAO() : homebannerDAO;
	}
	
	public ArrayList<CommonDataBean> getAllData(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_homebanner where lang_id = ? and isDelete <> 1 and enabled = 1 order by displayOrder asc ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CommonDataBean bean = new CommonDataBean();
				bean.setId(rs.getInt("id"));
				bean.setLang_id(rs.getInt("lang_id"));
				bean.setTitle(rs.getString("title"));
				bean.setSubtitle(rs.getString("subtitle"));
				bean.setAuthor(rs.getString("author"));
				bean.setDescription(rs.getString("description"));
				bean.setLinkA(rs.getString("linkA"));
				bean.setLinkB(rs.getString("linkB"));
				bean.setLinkC(rs.getString("linkC"));
				bean.setImageApath(rs.getString("imgPathA"));
				bean.setImageBpath(rs.getString("imgPathB"));
				bean.setImageCpath(rs.getString("imgPathC"));
				bean.setBreadcrumbA(rs.getInt("breadcrumbA"));
				bean.setBreadcrumbB(rs.getInt("breadcrumbB"));
				bean.setBreadcrumbC(rs.getInt("breadcrumbC"));
				bean.setFileApath(rs.getString("filePathA"));
				bean.setFileBpath(rs.getString("filePathB"));
				bean.setFileCpath(rs.getString("filePathC"));
				bean.setTop(rs.getInt("top"));
				bean.setEnabled(rs.getInt("enabled"));
				bean.setCreateDate(rs.getString("createDate"));
				bean.setPageviews(rs.getInt("pageViews"));
				bean.setDisplayOrder(rs.getInt("displayOrder"));
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

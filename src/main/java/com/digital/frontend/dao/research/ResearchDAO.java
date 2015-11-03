package com.digital.frontend.dao.research;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.digital.frontend.common.bean.CommonDataBean;
import com.digital.frontend.dao.research.ResearchDAO;

public class ResearchDAO {
	private static ResearchDAO researchDAO;
	
	private ResearchDAO(){}
	
	public synchronized static ResearchDAO getInstance(){
		return researchDAO == null ? new ResearchDAO() : researchDAO;
	}
	
	public ArrayList<CommonDataBean> getAllData(int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_research where lang_id = ? and enabled = 1 and isDelete <> 1 and displayOrder <> 0 order by displayOrder,id limit 4 ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, langId);
			
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
				bean.setContent_short(rs.getString("content_short"));
				bean.setContent_long(rs.getString("content_long"));
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
	
	public int getGalleryDataCount(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try{
			String sql = "select * from digital_research where lang_id = ? and enabled = 1 and top <> 1 and isDelete <> 1 order by displayOrder,id ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getInt("count");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return result;
	}
	
	public ArrayList<CommonDataBean> getGalleryData(int langId, int page, int page_size) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_research where lang_id = ? and enabled = 1 and top <> 1 and isDelete <> 1 order by displayOrder,id limit ?,? ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, langId);
			pstmt.setInt(2, (page - 1) * page_size);
			pstmt.setInt(3, page_size);
			
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
				bean.setContent_short(rs.getString("content_short"));
				bean.setContent_long(rs.getString("content_long"));
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
	
	public CommonDataBean getTopGalleryData(int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommonDataBean bean = new CommonDataBean();		
		
		try{
			String sql = "select * from digital_research where lang_id = ? and enabled = 1 and top = 1 and isDelete <> 1 order by displayOrder,id limit 1 ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, langId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
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
				bean.setContent_short(rs.getString("content_short"));
				bean.setContent_long(rs.getString("content_long"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return bean;
	}
	
	public CommonDataBean getDetailData(int id, int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommonDataBean bean = new CommonDataBean();		
		
		try{
			String sql = "select * from digital_research where lang_id = ? and id = ? ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, langId);
			pstmt.setInt(2, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
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
				bean.setContent_short(rs.getString("content_short"));
				bean.setContent_long(rs.getString("content_long"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return bean;
	}

	public ArrayList<CommonDataBean> getRestData(int id, int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_research where lang_id = ? and id <> ? and enabled = 1 and isDelete <> 1 and displayOrder <> 0 order by displayOrder,id limit 4 ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			pstmt.setInt(2, id);
			
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
				bean.setContent_short(rs.getString("content_short"));
				bean.setContent_long(rs.getString("content_long"));
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

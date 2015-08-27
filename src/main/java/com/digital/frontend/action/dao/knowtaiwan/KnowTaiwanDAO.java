package com.digital.frontend.action.dao.knowtaiwan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.digital.frontend.action.dao.knowtaiwan.KnowTaiwanDAO;
import com.digital.frontend.common.bean.CommonDataBean;

public class KnowTaiwanDAO {
	private static KnowTaiwanDAO knowTaiwanDAO;
	
	private KnowTaiwanDAO(){}
	
	public synchronized static KnowTaiwanDAO getInstance(){
		return knowTaiwanDAO == null ? new KnowTaiwanDAO() : knowTaiwanDAO;
	}
	
	public ArrayList<CommonDataBean> getAllData(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_knowtaiwan where lang_id = ? and enabled = 1 and displayOrder <> 0 order by displayOrder,id ";
			
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
	
	@SuppressWarnings("unchecked")
	public JSONArray getAJAXData(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray jsonArray = new JSONArray();
		
		try{
			String sql = "select * from digital_knowtaiwan where lang_id = ? and enabled = 1 and displayOrder <> 0 order by displayOrder,id limit 3";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", String.valueOf(rs.getInt("id")));
				jsonObject.put("lang_id", String.valueOf(rs.getInt("lang_id")));
				jsonObject.put("title", rs.getString("title"));
				jsonObject.put("subtitle", rs.getString("subtitle"));
				jsonObject.put("author", rs.getString("author"));
				jsonObject.put("description", rs.getString("description"));
				jsonObject.put("linkA", rs.getString("linkA"));
				jsonObject.put("linkB", rs.getString("linkB"));
				jsonObject.put("linkC", rs.getString("linkC"));
				jsonObject.put("imgPathA", rs.getString("imgPathA"));
				jsonObject.put("imgPathB", rs.getString("imgPathB"));
				jsonObject.put("imgPathB", rs.getString("imgPathB"));
				jsonObject.put("breadcrumbA", String.valueOf(rs.getInt("breadcrumbA")));
				jsonObject.put("breadcrumbB", String.valueOf(rs.getInt("breadcrumbB")));
				jsonObject.put("breadcrumbC", String.valueOf(rs.getInt("breadcrumbC")));
				jsonObject.put("filePathA", rs.getString("filePathA"));
				jsonObject.put("filePathB", rs.getString("filePathB"));
				jsonObject.put("filePathC", rs.getString("filePathC"));
				jsonObject.put("top", String.valueOf(rs.getInt("top")));
				jsonObject.put("enabled", String.valueOf(rs.getInt("enabled")));
				jsonObject.put("createDate", rs.getString("createDate"));
				jsonObject.put("pageViews", String.valueOf(rs.getInt("pageViews")));
				jsonObject.put("displayOrder", String.valueOf(rs.getInt("displayOrder")));
				jsonArray.add(jsonObject);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return jsonArray;
	}
	
	public ArrayList<CommonDataBean> getGalleryData(int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_knowtaiwan where lang_id = ? and enabled = 1 and top <> 1 and isDelete <> 1 order by displayOrder,id ";
			
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
	
	public CommonDataBean getTopGalleryData(int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommonDataBean bean = new CommonDataBean();		
		
		try{
			String sql = "select * from digital_knowtaiwan where lang_id = ? and enabled = 1 and top = 1 and isDelete <> 1 order by displayOrder,id limit 1 ";
			
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
			String sql = "select * from digital_knowtaiwan where lang_id = ? and id = ? ";
			
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
			String sql = "select * from digital_knowtaiwan where lang_id = ? and id <> ? and enabled = 1 and displayOrder <> 0 order by displayOrder,id ";
			
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

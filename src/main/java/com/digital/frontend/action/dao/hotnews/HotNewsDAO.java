package com.digital.frontend.action.dao.hotnews;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.digital.frontend.common.bean.CommonDataBean;

public class HotNewsDAO {
	private static HotNewsDAO hotNewsDAO;
	
	private HotNewsDAO(){}
	
	public synchronized static HotNewsDAO getInstance(){
		return hotNewsDAO == null ? new HotNewsDAO() : hotNewsDAO;
	}
	
	public ArrayList<CommonDataBean> getAllData(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_lang_id = ? and hotnews_enabled = 1 and hotnews_delete <> 1 and displayOrder <> 0 order by displayOrder,id limit 3";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CommonDataBean bean = new CommonDataBean();
				bean.setId(rs.getInt("hotnews_id"));
				bean.setLang_id(rs.getInt("hotnews_lang_id"));
				bean.setTitle(rs.getString("hotnews_title"));
				bean.setSubtitle(rs.getString("hotnews_subtitle"));
				bean.setAuthor(rs.getString("hotnews_author"));
				bean.setDescription(rs.getString("hotnews_description"));
				bean.setLinkA(rs.getString("hotnews_linkA"));
				bean.setLinkB(rs.getString("hotnews_linkB"));
				bean.setLinkC(rs.getString("hotnews_linkC"));
				bean.setImageApath(rs.getString("hotnews_imgPathA"));
				bean.setImageBpath(rs.getString("hotnews_imgPathB"));
				bean.setImageCpath(rs.getString("hotnews_imgPathC"));
				bean.setBreadcrumbA(rs.getInt("hotnews_breadcrumbA"));
				bean.setBreadcrumbB(rs.getInt("hotnews_breadcrumbB"));
				bean.setBreadcrumbC(rs.getInt("hotnews_breadcrumbC"));
				bean.setFileApath(rs.getString("hotnews_filePathA"));
				bean.setFileBpath(rs.getString("hotnews_filePathB"));
				bean.setFileCpath(rs.getString("hotnews_filePathC"));
				bean.setTop(rs.getInt("hotnews_top"));
				bean.setEnabled(rs.getInt("hotnews_enabled"));
				bean.setCreateDate(rs.getString("hotnews_createDate"));
				bean.setPageviews(rs.getInt("hotnews_pageViews"));
				bean.setDisplayOrder(rs.getInt("displayOrder"));
				bean.setPublishTime(rs.getString("publish_time"));
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
			String sql = "select * from digital_hotnews where hotnews_lang_id = ? and hotnews_enabled = 1 and displayOrder <> 0 order by displayOrder,hotnews_id limit 3";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", String.valueOf(rs.getInt("hotnews_id")));
				jsonObject.put("lang_id", String.valueOf(rs.getInt("hotnews_lang_id")));
				jsonObject.put("title", rs.getString("hotnews_title"));
				jsonObject.put("subtitle", rs.getString("hotnews_subtitle"));
				jsonObject.put("author", rs.getString("hotnews_author"));
				jsonObject.put("description", rs.getString("hotnews_description"));
				jsonObject.put("linkA", rs.getString("hotnews_linkA"));
				jsonObject.put("linkB", rs.getString("hotnews_linkB"));
				jsonObject.put("linkC", rs.getString("hotnews_linkC"));
				jsonObject.put("imgPathA", rs.getString("hotnews_imgPathA"));
				jsonObject.put("imgPathB", rs.getString("hotnews_imgPathB"));
				jsonObject.put("imgPathB", rs.getString("hotnews_imgPathB"));
				jsonObject.put("breadcrumbA", String.valueOf(rs.getInt("hotnews_breadcrumbA")));
				jsonObject.put("breadcrumbB", String.valueOf(rs.getInt("hotnews_breadcrumbB")));
				jsonObject.put("breadcrumbC", String.valueOf(rs.getInt("hotnews_breadcrumbC")));
				jsonObject.put("filePathA", rs.getString("hotnews_filePathA"));
				jsonObject.put("filePathB", rs.getString("hotnews_filePathB"));
				jsonObject.put("filePathC", rs.getString("hotnews_filePathC"));
				jsonObject.put("top", String.valueOf(rs.getInt("hotnews_top")));
				jsonObject.put("enabled", String.valueOf(rs.getInt("hotnews_enabled")));
				jsonObject.put("createDate", rs.getString("hotnews_createDate"));
				jsonObject.put("pageViews", String.valueOf(rs.getInt("hotnews_pageViews")));
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
	
	public int getGalleryDataCount(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try{
			String sql = "select count(*) as count from digital_hotnews where hotnews_lang_id = ? and hotnews_enabled = 1 and hotnews_top <> 1 and hotnews_delete <> 1  order by displayOrder,id ";
			
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
	
	public ArrayList<CommonDataBean> getGalleryData(int lang_id, int page, int page_size) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_lang_id = ? and hotnews_enabled = 1 and hotnews_top <> 1 and hotnews_delete <> 1  order by publish_time desc limit ?, ? ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			pstmt.setInt(2, (page - 1) * page_size);
			pstmt.setInt(3, page_size);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CommonDataBean bean = new CommonDataBean();
				bean.setId(rs.getInt("hotnews_id"));
				bean.setLang_id(rs.getInt("hotnews_lang_id"));
				bean.setTitle(rs.getString("hotnews_title"));
				bean.setSubtitle(rs.getString("hotnews_subtitle"));
				bean.setAuthor(rs.getString("hotnews_author"));
				bean.setDescription(rs.getString("hotnews_description"));
				bean.setLinkA(rs.getString("hotnews_linkA"));
				bean.setLinkB(rs.getString("hotnews_linkB"));
				bean.setLinkC(rs.getString("hotnews_linkC"));
				bean.setImageApath(rs.getString("hotnews_imgPathA"));
				bean.setImageBpath(rs.getString("hotnews_imgPathB"));
				bean.setImageCpath(rs.getString("hotnews_imgPathC"));
				bean.setBreadcrumbA(rs.getInt("hotnews_breadcrumbA"));
				bean.setBreadcrumbB(rs.getInt("hotnews_breadcrumbB"));
				bean.setBreadcrumbC(rs.getInt("hotnews_breadcrumbC"));
				bean.setFileApath(rs.getString("hotnews_filePathA"));
				bean.setFileBpath(rs.getString("hotnews_filePathB"));
				bean.setFileCpath(rs.getString("hotnews_filePathC"));
				bean.setTop(rs.getInt("hotnews_top"));
				bean.setEnabled(rs.getInt("hotnews_enabled"));
				bean.setCreateDate(rs.getString("hotnews_createDate"));
				bean.setPageviews(rs.getInt("hotnews_pageViews"));
				bean.setDisplayOrder(rs.getInt("displayOrder"));
				bean.setContent_short(rs.getString("hotnews_content_short"));
				bean.setContent_long(rs.getString("hotnews_content_long"));
				bean.setPublishTime(rs.getString("publish_time"));
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
	
	public CommonDataBean getTopGalleryData(int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommonDataBean bean = new CommonDataBean();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_lang_id = ? and hotnews_enabled = 1 and hotnews_top = 1 and hotnews_delete <> 1 order by displayOrder,id limit 1";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean.setId(rs.getInt("hotnews_id"));
				bean.setLang_id(rs.getInt("hotnews_lang_id"));
				bean.setTitle(rs.getString("hotnews_title"));
				bean.setSubtitle(rs.getString("hotnews_subtitle"));
				bean.setAuthor(rs.getString("hotnews_author"));
				bean.setDescription(rs.getString("hotnews_description"));
				bean.setLinkA(rs.getString("hotnews_linkA"));
				bean.setLinkB(rs.getString("hotnews_linkB"));
				bean.setLinkC(rs.getString("hotnews_linkC"));
				bean.setImageApath(rs.getString("hotnews_imgPathA"));
				bean.setImageBpath(rs.getString("hotnews_imgPathB"));
				bean.setImageCpath(rs.getString("hotnews_imgPathC"));
				bean.setBreadcrumbA(rs.getInt("hotnews_breadcrumbA"));
				bean.setBreadcrumbB(rs.getInt("hotnews_breadcrumbB"));
				bean.setBreadcrumbC(rs.getInt("hotnews_breadcrumbC"));
				bean.setFileApath(rs.getString("hotnews_filePathA"));
				bean.setFileBpath(rs.getString("hotnews_filePathB"));
				bean.setFileCpath(rs.getString("hotnews_filePathC"));
				bean.setTop(rs.getInt("hotnews_top"));
				bean.setEnabled(rs.getInt("hotnews_enabled"));
				bean.setCreateDate(rs.getString("hotnews_createDate"));
				bean.setPageviews(rs.getInt("hotnews_pageViews"));
				bean.setDisplayOrder(rs.getInt("displayOrder"));
				bean.setContent_short(rs.getString("hotnews_content_short"));
				bean.setContent_long(rs.getString("hotnews_content_long"));
				bean.setPublishTime(rs.getString("publish_time"));
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
	
	public CommonDataBean getDetailData(int id, int lang_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommonDataBean bean = new CommonDataBean();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_lang_id = ? and hotnews_id = ? ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lang_id);
			pstmt.setInt(2, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean.setId(rs.getInt("hotnews_id"));
				bean.setLang_id(rs.getInt("hotnews_lang_id"));
				bean.setTitle(rs.getString("hotnews_title"));
				bean.setSubtitle(rs.getString("hotnews_subtitle"));
				bean.setAuthor(rs.getString("hotnews_author"));
				bean.setDescription(rs.getString("hotnews_description"));
				bean.setLinkA(rs.getString("hotnews_linkA"));
				bean.setLinkB(rs.getString("hotnews_linkB"));
				bean.setLinkC(rs.getString("hotnews_linkC"));
				bean.setImageApath(rs.getString("hotnews_imgPathA"));
				bean.setImageBpath(rs.getString("hotnews_imgPathB"));
				bean.setImageCpath(rs.getString("hotnews_imgPathC"));
				bean.setBreadcrumbA(rs.getInt("hotnews_breadcrumbA"));
				bean.setBreadcrumbB(rs.getInt("hotnews_breadcrumbB"));
				bean.setBreadcrumbC(rs.getInt("hotnews_breadcrumbC"));
				bean.setFileApath(rs.getString("hotnews_filePathA"));
				bean.setFileBpath(rs.getString("hotnews_filePathB"));
				bean.setFileCpath(rs.getString("hotnews_filePathC"));
				bean.setTop(rs.getInt("hotnews_top"));
				bean.setEnabled(rs.getInt("hotnews_enabled"));
				bean.setCreateDate(rs.getString("hotnews_createDate"));
				bean.setPageviews(rs.getInt("hotnews_pageViews"));
				bean.setDisplayOrder(rs.getInt("displayOrder"));
				bean.setContent_short(rs.getString("hotnews_content_short"));
				bean.setContent_long(rs.getString("hotnews_content_long"));
				bean.setPublishTime(rs.getString("publish_time"));
				bean.setPlainText(rs.getString("plain_text"));
				bean.setFileTitle1(rs.getString("file_title_1"));
				bean.setFileTitle2(rs.getString("file_title_2"));
				bean.setFileTitle3(rs.getString("file_title_3"));
				bean.setFileDesc1(rs.getString("file_desc_1"));
				bean.setFileDesc2(rs.getString("file_desc_2"));
				bean.setFileDesc3(rs.getString("file_desc_3"));
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

	public ArrayList<CommonDataBean> getRestData(int id, int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_lang_id = ? and hotnews_id <> ? and hotnews_enabled = 1 and hotnews_top <> 1 and hotnews_delete <> 1  order by displayOrder,id limit 4 ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, langId);
			pstmt.setInt(2, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CommonDataBean bean = new CommonDataBean();
				bean.setId(rs.getInt("hotnews_id"));
				bean.setLang_id(rs.getInt("hotnews_lang_id"));
				bean.setTitle(rs.getString("hotnews_title"));
				bean.setSubtitle(rs.getString("hotnews_subtitle"));
				bean.setAuthor(rs.getString("hotnews_author"));
				bean.setDescription(rs.getString("hotnews_description"));
				bean.setLinkA(rs.getString("hotnews_linkA"));
				bean.setLinkB(rs.getString("hotnews_linkB"));
				bean.setLinkC(rs.getString("hotnews_linkC"));
				bean.setImageApath(rs.getString("hotnews_imgPathA"));
				bean.setImageBpath(rs.getString("hotnews_imgPathB"));
				bean.setImageCpath(rs.getString("hotnews_imgPathC"));
				bean.setBreadcrumbA(rs.getInt("hotnews_breadcrumbA"));
				bean.setBreadcrumbB(rs.getInt("hotnews_breadcrumbB"));
				bean.setBreadcrumbC(rs.getInt("hotnews_breadcrumbC"));
				bean.setFileApath(rs.getString("hotnews_filePathA"));
				bean.setFileBpath(rs.getString("hotnews_filePathB"));
				bean.setFileCpath(rs.getString("hotnews_filePathC"));
				bean.setTop(rs.getInt("hotnews_top"));
				bean.setEnabled(rs.getInt("hotnews_enabled"));
				bean.setCreateDate(rs.getString("hotnews_createDate"));
				bean.setPageviews(rs.getInt("hotnews_pageViews"));
				bean.setDisplayOrder(rs.getInt("displayOrder"));
				bean.setContent_short(rs.getString("hotnews_content_short"));
				bean.setContent_long(rs.getString("hotnews_content_long"));
				bean.setPublishTime(rs.getString("publish_time"));
				bean.setPlainText(rs.getString("plain_text"));
				bean.setFileTitle1(rs.getString("file_title_1"));
				bean.setFileTitle2(rs.getString("file_title_2"));
				bean.setFileTitle3(rs.getString("file_title_3"));
				bean.setFileDesc1(rs.getString("file_desc_1"));
				bean.setFileDesc2(rs.getString("file_desc_2"));
				bean.setFileDesc3(rs.getString("file_desc_3"));
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

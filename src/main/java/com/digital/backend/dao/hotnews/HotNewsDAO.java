package com.digital.backend.dao.hotnews;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.digital.backend.bean.hotnews.HotNewsBean;
import com.digital.backend.common.bean.CommonDataBean;

public class HotNewsDAO {
	private static HotNewsDAO hotNewsDAO;
	
	private HotNewsDAO(){}
	
	public synchronized static HotNewsDAO getInstance(){
		return hotNewsDAO == null ? new HotNewsDAO() : hotNewsDAO;
	}
	
	public int getMaxId() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int hotnews_id = 0;
		
		try{
			String sql = "select ifnull(max(hotnews_id),0) as hotnews_id from digital_hotnews";
			conn = DriverManager.getConnection("proxool.digital"); 
			pstmt= conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				hotnews_id = rs.getInt("hotnews_id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		return hotnews_id;
	}
	
	public void changeExistingOrder(int langId) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "update digital_hotnews set displayOrder = displayOrder + 1 where hotnews_lang_id = ? ";
			conn = DriverManager.getConnection("proxool.digital"); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, langId);
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	public void insertHotNews(CommonDataBean bean) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			//prepare sql script
			StringBuffer sql = new StringBuffer();
			sql.append("insert into digital_hotnews (id, hotnews_id, hotnews_lang_id, hotnews_title, hotnews_subtitle, hotnews_description, hotnews_author, hotnews_linkA, ")
				.append(" hotnews_linkB, hotnews_linkC, hotnews_imgPathA, hotnews_imgPathB, hotnews_imgPathC, hotnews_breadcrumbA, hotnews_breadcrumbB, hotnews_breadcrumbC, ")
				.append(" hotnews_filePathA, hotnews_filePathB, hotnews_filePathC, hotnews_createDate, hotnews_top, hotnews_enabled, hotnews_delete, displayOrder, hotnews_content_short, hotnews_content_long, publish_time ) ")
				.append(" plain_text, file_title_1, file_title_2, file_title_3, file_desc_1, file_desc_2, file_desc_3 ")
				.append(" values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,now(), ?,?,?,1,?,?,? ,?,?,?,?,?,?,?) ");
			
			conn = DriverManager.getConnection("proxool.digital"); 
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setNull(1, java.sql.Types.INTEGER);
			pstmt.setInt(2, bean.getId());
			pstmt.setInt(3, bean.getLang_id());
			pstmt.setNString(4, bean.getTitle());
			pstmt.setString(5, bean.getSubtitle());
			pstmt.setString(6, bean.getDescription());
			pstmt.setString(7, bean.getAuthor());
			pstmt.setString(8, bean.getLinkA());
			pstmt.setString(9, bean.getLinkB());
			pstmt.setString(10, bean.getLinkC());
			pstmt.setString(11, bean.getImageApath());
			pstmt.setString(12, bean.getImageBpath());
			pstmt.setString(13, bean.getImageCpath());
			pstmt.setInt(14, bean.getBreadcrumbA());
			pstmt.setInt(15, bean.getBreadcrumbB());
			pstmt.setInt(16, bean.getBreadcrumbC());
			pstmt.setString(17, bean.getFileApath());
			pstmt.setString(18, bean.getFileBpath());
			pstmt.setString(19, bean.getFileCpath());
			//pstmt.setNull(20, java.sql.Types.DATE);//default is now()
			pstmt.setBoolean(20, bean.getTop() == 1 ? true : false);
			pstmt.setBoolean(21, bean.getEnabled() == 1 ? true : false);
			pstmt.setBoolean(22, false);
			pstmt.setString(23, bean.getContent_short());
			pstmt.setString(24, bean.getContent_long());
			pstmt.setString(25, bean.getPublishTime());
			pstmt.setString(26, bean.getPlainText());
			pstmt.setString(27, bean.getFileTitle1());
			pstmt.setString(28, bean.getFileTitle2());
			pstmt.setString(29, bean.getFileTitle3());
			pstmt.setString(30, bean.getFileDesc1());
			pstmt.setString(31, bean.getFileDesc2());
			pstmt.setString(32, bean.getFileDesc3());
			
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	public void updateHotNews(CommonDataBean bean) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			//prepare sql script
			StringBuffer sql = new StringBuffer();
			sql.append("update digital_hotnews set hotnews_title = ?, hotnews_subtitle = ?, hotnews_description = ?, ")
				.append("                                           hotnews_author = ?, hotnews_linkA = ?, hotnews_linkB = ?, hotnews_linkC = ?,  ")
				.append("                                           hotnews_breadcrumbA = ?, hotnews_breadcrumbB = ?, hotnews_breadcrumbC = ?,")
				.append("                                           hotnews_top = ?, hotnews_enabled = ?, hotnews_content_short = ?, hotnews_content_long = ?, ")
				.append("											   publish_time = ? ");
			
			if(!"".equals(bean.getImageApath())){
				sql.append(",hotnews_imgPathA = '" + bean.getImageApath() + "'");	
			}
			if(!"".equals(bean.getImageBpath())){
				sql.append(",hotnews_imgPathB = '" + bean.getImageBpath() + "'");	
			}
			if(!"".equals(bean.getImageCpath())){
				sql.append(",hotnews_imgPathC = '" + bean.getImageCpath() + "'");	
			}
			if(!"".equals(bean.getFileApath())){
				sql.append(", hotnews_filePathA = '" + bean.getFileApath() + "'");
			}
			if(!"".equals(bean.getFileBpath())){
				sql.append(", hotnews_filePathB = '" + bean.getFileBpath() + "'");
			}
			if(!"".equals(bean.getFileCpath())){
				sql.append(", hotnews_filePathC = '" + bean.getFileCpath() + "'");
			}
			
			sql.append(" where hotnews_id = " + bean.getId() + " and hotnews_lang_id = " + bean.getLang_id());
			
			conn = DriverManager.getConnection("proxool.digital"); 
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getSubtitle());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getAuthor());
			pstmt.setString(5, bean.getLinkA());
			pstmt.setString(6, bean.getLinkB());
			pstmt.setString(7, bean.getLinkC());
			pstmt.setInt(8, bean.getBreadcrumbA());
			pstmt.setInt(9, bean.getBreadcrumbB());
			pstmt.setInt(10, bean.getBreadcrumbC());
			pstmt.setBoolean(11, bean.getTop() == 1 ? true : false);
			pstmt.setBoolean(12, bean.getEnabled() == 1 ? true : false);
			pstmt.setString(13, bean.getContent_short());
			pstmt.setString(14, bean.getContent_long());
			pstmt.setString(15, bean.getPublishTime());
			
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	public ArrayList<CommonDataBean> getHotNews(int hotnews_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_id = ? ";
			
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotnews_id);
			
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
	
	public ArrayList<CommonDataBean> getHotNewsByPage(int page, int page_size) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		try{
			String sql = "select * from digital_hotnews where hotnews_lang_id = 1 and hotnews_delete = false order by publish_time desc limit ?, ? ";//only get cht version
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page - 1) * page_size);
			pstmt.setInt(2, page_size);
			
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

	public int getTotal() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		
		try{
			String sql = "select count(*) as count from digital_hotnews where hotnews_lang_id = 1 and hotnews_delete = false ";//only get cht version
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				total = rs.getInt("count");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return total;
	}

	public void delHotNewsById(int hotnews_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "update digital_hotnews set hotnews_delete = true where hotnews_id = ? ";
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotnews_id);
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}

	public void updateDisplayOrderById(int id, int order) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "update digital_hotnews set displayOrder = ? where hotnews_id = ? ";
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order);
			pstmt.setInt(2, id);
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	public void deleteImage(int id, int langId, int imageNo) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		try{
			if(imageNo == 1){				
				sql = "update digital_hotnews set hotnews_imgPathA = '' where hotnews_id = ? and hotnews_lang_id = ? ";
			}else if(imageNo == 2){
				sql = "update digital_hotnews set hotnews_imgPathB = '' where hotnews_id = ? and hotnews_lang_id = ? ";
			}else{
				sql = "update digital_hotnews set hotnews_imgPathC = '' where hotnews_id = ? and hotnews_lang_id = ? ";
			}
		
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, langId);
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	public void deleteFile(int id, int langId, int fileNo) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			String sql = "";
			if(fileNo == 1){
				sql = "update digital_hotnews set hotnews_filePathA = '' where hotnews_id = ? and hotnews_lang_id = ? ";				
			}else if(fileNo == 2){
				sql = "update digital_hotnews set hotnews_filePathB = '' where hotnews_id = ? and hotnews_lang_id = ? ";	
			}else{
				sql = "update digital_hotnews set hotnews_filePathC = '' where hotnews_id = ? and hotnews_lang_id = ? ";	
			}
			conn = DriverManager.getConnection("proxool.digital");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, langId);
			pstmt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
}

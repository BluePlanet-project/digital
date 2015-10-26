package com.digital.backend.action.items.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.digital.backend.bean.hotnews.HotNewsBean;
import com.digital.backend.common.bean.CommonDataBean;
import com.digital.backend.common.items.ItemAction;
import com.digital.backend.dao.academic.AcademicDAO;
import com.digital.backend.dao.converage.ConverageDAO;
import com.digital.backend.dao.dataaddon.DataAddonDAO;
import com.digital.backend.dao.database.DataBaseDAO;
import com.digital.backend.dao.homebanner.HomeBannerDAO;
import com.digital.backend.dao.hotnews.HotNewsDAO;
import com.digital.backend.dao.interperspective.InterPerspectiveDAO;
import com.digital.backend.dao.knowtaiwan.KnowTaiwanDAO;
import com.digital.backend.dao.relatedweb.RelatedWebDAO;
import com.digital.backend.dao.research.ResearchDAO;
import com.digital.backend.dao.researchresource.ResearchResourceDAO;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class DataEditAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int ITEM_LANG_CHT = 1;
	private int ITEM_LANG_ENU = 2;
	private String ITEM_UPLOAD_DIR = "/upload/items/";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Hashtable parameters = new Hashtable();
		parameters = upload(request, response);
		
		int id = Integer.parseInt(parameters.get("id").toString());
		//CHT
		String title_cht = parameters.get("title_cht") == null ? "" : parameters.get("title_cht").toString();
		String author_cht = parameters.get("author_cht") == null ? "" : parameters.get("author_cht").toString();
		String link_1_cht = parameters.get("link_1_cht") == null ? "" : parameters.get("link_1_cht").toString();
		String link_2_cht = parameters.get("link_2_cht") == null ? "" : parameters.get("link_2_cht").toString();
		String link_3_cht = parameters.get("link_3_cht") == null ? "" : parameters.get("link_3_cht").toString();
		String image_1_cht = parameters.get("image_1_cht") == null ? "" : parameters.get("image_1_cht").toString();
		String image_2_cht = parameters.get("image_2_cht") == null ? "" : parameters.get("image_2_cht").toString();
		String image_3_cht = parameters.get("image_3_cht") == null ? "" : parameters.get("image_3_cht").toString();
		int breadcrumb_1_cht = Integer.parseInt(parameters.get("breadcrumb_1_cht") == null ? "0" : parameters.get("breadcrumb_1_cht").toString());
		int breadcrumb_2_cht = Integer.parseInt(parameters.get("breadcrumb_2_cht") == null ? "0" : parameters.get("breadcrumb_2_cht").toString());
		int breadcrumb_3_cht = Integer.parseInt(parameters.get("breadcrumb_3_cht") == null ? "0" : parameters.get("breadcrumb_3_cht").toString());
		String file_1_cht = parameters.get("file_1_cht") == null ? "" : parameters.get("file_1_cht").toString();
		String file_2_cht = parameters.get("file_2_cht") == null ? "" : parameters.get("file_2_cht").toString();
		String file_3_cht = parameters.get("file_3_cht") == null ? "" : parameters.get("file_3_cht").toString();
		String subtitle_cht = parameters.get("subtitle_cht") == null ? "" : parameters.get("subtitle_cht").toString();
		String description_cht = parameters.get("description_cht") == null ? "" : parameters.get("description_cht").toString();
		String content_short_cht = parameters.get("content_short_cht") == null ? "" : parameters.get("content_short_cht").toString();
		String content_long_cht = parameters.get("content_long_cht") == null ? "" : parameters.get("content_long_cht").toString();
		int top_cht = Integer.parseInt(parameters.get("top_cht") == null ? "0" : parameters.get("top_cht").toString());
		int enabled_cht = Integer.parseInt(parameters.get("enabled_cht") == null ? "0" : parameters.get("enabled_cht").toString());
		
		//del image
		int del_img_1_cht = Integer.parseInt(parameters.get("del_img_1_cht") == null ? "0" : "1");
		//del file
		int del_file_a_cht = Integer.parseInt(parameters.get("del_file_a_cht") == null ? "0" : "1");
		int del_file_b_cht = Integer.parseInt(parameters.get("del_file_b_cht") == null ? "0" : "1");
		int del_file_c_cht = Integer.parseInt(parameters.get("del_file_c_cht") == null ? "0" : "1");
		
		//keep page number
		int page = Integer.parseInt(parameters.get("page") == null ? "1" : parameters.get("page").toString());
		
		//ENU
		String title_enu = parameters.get("title_enu") == null ? "" : parameters.get("title_enu").toString();
		String author_enu = parameters.get("author_enu") == null ? "" : parameters.get("author_enu").toString();
		String link_1_enu = parameters.get("link_1_enu") == null ? "" : parameters.get("link_1_enu").toString();
		String link_2_enu = parameters.get("link_2_enu") == null ? "" : parameters.get("link_2_enu").toString();
		String link_3_enu = parameters.get("link_3_enu") == null ? "" : parameters.get("link_3_enu").toString();
		String image_1_enu = parameters.get("image_1_enu") == null ? "" : parameters.get("image_1_enu").toString();
		String image_2_enu = parameters.get("image_2_enu") == null ? "" : parameters.get("image_2_enu").toString();
		String image_3_enu = parameters.get("image_3_enu") == null ? "" : parameters.get("image_3_enu").toString();
		int breadcrumb_1_enu = Integer.parseInt(parameters.get("breadcrumb_1_enu") == null ? "0" : parameters.get("breadcrumb_1_enu").toString());
		int breadcrumb_2_enu = Integer.parseInt(parameters.get("breadcrumb_2_enu") == null ? "0" : parameters.get("breadcrumb_2_enu").toString());
		int breadcrumb_3_enu = Integer.parseInt(parameters.get("breadcrumb_3_enu") == null ? "0" : parameters.get("breadcrumb_3_enu").toString());
		String file_1_enu = parameters.get("file_1_enu") == null ? "" : parameters.get("file_1_enu").toString();
		String file_2_enu = parameters.get("file_2_enu") == null ? "" : parameters.get("file_2_enu").toString();
		String file_3_enu = parameters.get("file_3_enu") == null ? "" : parameters.get("file_3_enu").toString();
		String subtitle_enu = parameters.get("subtitle_enu") == null ? "" : parameters.get("subtitle_enu").toString();
		String description_enu = parameters.get("description_enu") == null ? "" : parameters.get("description_enu").toString();
		String content_short_enu = parameters.get("content_short_enu") == null ? "" : parameters.get("content_short_enu").toString();
		String content_long_enu = parameters.get("content_long_enu") == null ? "" : parameters.get("content_long_enu").toString();
		int top_enu = Integer.parseInt(parameters.get("top_enu") == null ? "0" : parameters.get("top_enu").toString());
		int enabled_enu = Integer.parseInt(parameters.get("enabled_enu") == null ? "0" : parameters.get("enabled_enu").toString());
		
		//del image
		int del_img_1_enu = Integer.parseInt(parameters.get("del_img_1_enu") == null ? "0" :  "1");
		//del file
		int del_file_a_enu = Integer.parseInt(parameters.get("del_file_a_enu") == null ? "0" : "1");
		int del_file_b_enu = Integer.parseInt(parameters.get("del_file_b_enu") == null ? "0" : "1");
		int del_file_c_enu = Integer.parseInt(parameters.get("del_file_c_enu") == null ? "0" : "1");
		
		//set up bean
		//CHT
		CommonDataBean bean = new CommonDataBean();
		bean.setId(id);
		bean.setLang_id(ITEM_LANG_CHT);
		bean.setTitle(title_cht);
		bean.setAuthor(author_cht);
		bean.setLinkA(link_1_cht.replace("%ID%", String.valueOf(id)));
		bean.setLinkB(link_2_cht);
		bean.setLinkC(link_3_cht);
		bean.setImageApath(image_1_cht);
		bean.setImageBpath(image_2_cht);
		bean.setImageCpath(image_3_cht);
		bean.setBreadcrumbA(breadcrumb_1_cht);
		bean.setBreadcrumbB(breadcrumb_2_cht);
		bean.setBreadcrumbC(breadcrumb_3_cht);
		bean.setFileApath(file_1_cht);
		bean.setFileBpath(file_2_cht);
		bean.setFileCpath(file_3_cht);
		bean.setSubtitle(subtitle_cht);
		bean.setDescription(description_cht);
		bean.setTop(top_cht);
		bean.setEnabled(enabled_cht);
		bean.setContent_short(content_short_cht);
		bean.setContent_long(content_long_cht);

		String action = parameters.get("action") == null ? "" : parameters.get("action").toString();
		ItemAction itemAction = ItemAction.getAction(action);
		switch(itemAction){
			case hotnews:				
				HotNewsDAO.getInstance().updateHotNews(bean);
				if(del_img_1_cht == 1){
					HotNewsDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					HotNewsDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					HotNewsDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					HotNewsDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case interperspective:
				InterPerspectiveDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					InterPerspectiveDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					InterPerspectiveDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					InterPerspectiveDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					InterPerspectiveDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case converage:
				ConverageDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					ConverageDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					ConverageDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					ConverageDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					ConverageDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case research:
				ResearchDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					ResearchDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					ResearchDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					ResearchDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					ResearchDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case knowTaiwan:
				KnowTaiwanDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					KnowTaiwanDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					KnowTaiwanDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					KnowTaiwanDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					KnowTaiwanDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case database:
				DataBaseDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					DataBaseDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					DataBaseDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					DataBaseDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					DataBaseDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case dataaddon:
				DataAddonDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					DataAddonDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					DataAddonDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					DataAddonDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					DataAddonDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case researchResource:
				ResearchResourceDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					ResearchResourceDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					ResearchResourceDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					ResearchResourceDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					ResearchResourceDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case relatedWeb:
				RelatedWebDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					RelatedWebDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					RelatedWebDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					RelatedWebDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					RelatedWebDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case academic:
				AcademicDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					AcademicDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					AcademicDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					AcademicDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					AcademicDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			case homebanner:
				HomeBannerDAO.getInstance().updateData(bean);
				if(del_img_1_cht == 1){
					HomeBannerDAO.getInstance().deleteImageA(id, ITEM_LANG_CHT);
				}
				if(del_file_a_cht == 1){
					HomeBannerDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 1);
				}
				if(del_file_a_cht == 2){
					HomeBannerDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 2);
				}
				if(del_file_a_cht == 3){
					HomeBannerDAO.getInstance().deleteFile(id, ITEM_LANG_CHT, 3);
				}
				break;
			default:
				break;
		}
		
		
		//ENU
		bean.setId(id);
		bean.setLang_id(ITEM_LANG_ENU);
		bean.setTitle("".equals(title_enu) ? title_cht : title_enu);
		bean.setAuthor("".equals(author_enu) ? author_cht : author_enu);
		bean.setLinkA("".equals(link_1_enu) ? link_1_cht : link_1_enu);
		bean.setLinkB("".equals(link_2_enu) ? link_2_cht : link_2_enu);
		bean.setLinkC("".equals(link_3_enu) ? link_3_cht : link_3_enu);
		bean.setImageApath("".equals(image_1_enu) ? image_1_cht : image_1_enu);
		bean.setImageBpath("".equals(image_2_enu) ? image_2_cht : image_2_enu);
		bean.setImageCpath("".equals(image_3_enu) ? image_3_cht : image_3_enu);
		bean.setBreadcrumbA(breadcrumb_1_enu == 0 ? breadcrumb_1_cht : breadcrumb_1_enu);
		bean.setBreadcrumbB(breadcrumb_2_enu == 0 ? breadcrumb_2_cht : breadcrumb_2_enu);
		bean.setBreadcrumbC(breadcrumb_3_enu == 0 ? breadcrumb_3_cht : breadcrumb_3_enu);
		bean.setFileApath("".equals(file_1_enu) ? file_1_cht : file_1_enu);
		bean.setFileBpath("".equals(file_2_enu) ? file_2_cht : file_2_enu);
		bean.setFileCpath("".equals(file_3_enu) ? file_3_cht : file_3_enu);
		bean.setSubtitle("".equals(subtitle_enu) ? subtitle_cht : subtitle_enu);
		bean.setDescription("".equals(description_enu) ? description_cht : description_enu);
		bean.setTop(top_enu == 0 ? top_cht : top_enu);
		bean.setEnabled(enabled_enu == 0 ? enabled_cht : enabled_enu);
		bean.setContent_short("".equals(content_short_enu) ? content_short_cht : content_short_enu);
		bean.setContent_long("".equals(content_long_enu) ? content_long_cht : content_long_enu);
		
		switch(itemAction){
			case hotnews:				
				HotNewsDAO.getInstance().updateHotNews(bean);
				if(del_img_1_enu == 1){
					HotNewsDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case interperspective:
				InterPerspectiveDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					InterPerspectiveDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case converage:
				ConverageDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					ConverageDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case research:
				ResearchDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					ResearchDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case knowTaiwan:
				KnowTaiwanDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					KnowTaiwanDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case database:
				DataBaseDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					DataBaseDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case dataaddon:
				DataAddonDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					DataAddonDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case researchResource:
				ResearchResourceDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					ResearchResourceDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case relatedWeb:
				RelatedWebDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					RelatedWebDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case academic:
				AcademicDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					AcademicDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			case homebanner:
				HomeBannerDAO.getInstance().updateData(bean);
				if(del_img_1_enu == 1){
					HomeBannerDAO.getInstance().deleteImageA(id, ITEM_LANG_ENU);
				}
				break;
			default:
				break;
		}
		
		String url = "/backend/item-list.do?action=" + action + "&page=" + page;
		response.sendRedirect(url);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable upload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Hashtable parameters = new Hashtable();
		String error         = "";
		String fileName      = "";
		// max Upload < 10MB !
		MultipartParser parser = new MultipartParser(request, 10*1024*1024);
		//String realPath = getServletContext().getRealPath(HOTNEWS_UPLOAD_DIR);
		String realPath = "E://www//digital//upload//items//";
		parser.setEncoding("utf-8");
		Part part;
		while ((part = parser.readNextPart()) != null){
			String name = part.getName();
		    if (part.isParam()) {
		    	ParamPart paramPart = (ParamPart) part;
		        String value = paramPart.getStringValue();
		        parameters.put(name, value);
		    }else if (part.isFile()) {
		        FilePart filePart = (FilePart) part;
		        fileName = filePart.getFileName();
		        Calendar calendar = Calendar.getInstance();
				long nowTime = calendar.getTimeInMillis();
		        if (fileName != null){
		        	parameters.put(filePart.getName(), ITEM_UPLOAD_DIR + String.valueOf(nowTime) + "." + FilenameUtils.getExtension(fileName));
		            FileOutputStream outs = null;
		            try{
		            	new File(realPath).mkdirs();
		                outs = new FileOutputStream(realPath + String.valueOf(nowTime) + "." + FilenameUtils.getExtension(fileName));
		                filePart.writeTo(outs);
		                outs.flush();
		                outs.close();
		            }catch (Exception e) {
		            	error = "Failed in MultiPartRequest: " + e.getMessage();
		            	System.out.println(error);
		            }
		         }
		     }
		  }
		  return parameters;
	}
}

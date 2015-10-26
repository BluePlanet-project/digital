package com.digital.frontend.action.gallery;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.backend.common.items.ItemAction;
import com.digital.frontend.action.dao.academic.AcademicDAO;
import com.digital.frontend.action.dao.converage.ConverageDAO;
import com.digital.frontend.action.dao.dataaddon.DataAddonDAO;
import com.digital.frontend.action.dao.database.DataBaseDAO;
import com.digital.frontend.action.dao.homebanner.HomeBannerDAO;
import com.digital.frontend.action.dao.hotnews.HotNewsDAO;
import com.digital.frontend.action.dao.interperspective.InterPerspectiveDAO;
import com.digital.frontend.action.dao.knowtaiwan.KnowTaiwanDAO;
import com.digital.frontend.action.dao.relatedweb.RelatedWebDAO;
import com.digital.frontend.action.dao.researchresource.ResearchResourceDAO;
import com.digital.frontend.common.bean.CommonDataBean;
import com.digital.frontend.dao.research.ResearchDAO;
import com.oreilly.servlet.ParameterParser;

public class FrontGalleryAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
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
		ParameterParser parser = new ParameterParser(request);
		
		String action = parser.getStringParameter("action", "");
		ItemAction itemAction = ItemAction.getAction(action);
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		CommonDataBean topBean = new CommonDataBean();
		String gallery_title_cht = "";
		
		switch(itemAction){
			case hotnews:
				list = HotNewsDAO.getInstance().getGalleryData(1);
				topBean = HotNewsDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "最新消息";
				break;
			case interperspective:
				list = InterPerspectiveDAO.getInstance().getGalleryData(1);
				topBean = InterPerspectiveDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "國際視野";
				break;
			case converage:
				list = ConverageDAO.getInstance().getGalleryData(1);
				topBean = ConverageDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "專題報導";
				break;
			case research:
				list = ResearchDAO.getInstance().getGalleryData(1);
				topBean = ResearchDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "研究計畫";
				break;
			case knowTaiwan:
				list = KnowTaiwanDAO.getInstance().getGalleryData(1);
				topBean = KnowTaiwanDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "看見台灣";
				break;
			case database:
				list = DataBaseDAO.getInstance().getGalleryData(1);
				topBean = DataBaseDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "資料庫系統";
				break;
			case dataaddon:
				list = DataAddonDAO.getInstance().getGalleryData(1);
				topBean = DataAddonDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "數位工具";
				break;
			case researchResource:
				list = ResearchResourceDAO.getInstance().getGalleryData(1);
				topBean = ResearchResourceDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "國外相關網站";
				break;
			case relatedWeb:
				list = RelatedWebDAO.getInstance().getGalleryData(1);
				topBean = RelatedWebDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "國內相關網站";
				break;
			case academic:
				list = AcademicDAO.getInstance().getGalleryData(1);
				topBean = AcademicDAO.getInstance().getTopGalleryData(1);
				gallery_title_cht = "學術活動";
				break;
			default:
				break;
		}
		
		ArrayList<CommonDataBean> homebannerList = HomeBannerDAO.getInstance().getAllData(1);
		
		request.setAttribute("action", action);
		request.setAttribute("galleryList", list);
		request.setAttribute("galleryTotal", list.size());
		request.setAttribute("topBean", topBean);
		request.setAttribute("gallery_title_cht", gallery_title_cht);
		
		request.setAttribute("homebannerList", homebannerList);
		
		String url = "/frontend/gallery.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}

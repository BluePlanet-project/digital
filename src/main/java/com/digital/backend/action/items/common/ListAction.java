package com.digital.backend.action.items.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.oreilly.servlet.ParameterParser;

public class ListAction extends HttpServlet{
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
		
		try{
			
			int page = parser.getIntParameter("page", 1);
			int page_size = parser.getIntParameter("page_size", 10);
			String action = parser.getStringParameter("action","");
			
			ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
			int totalNumbers = 0;
			double totalPages = 0;
			String url = "";
			
			ItemAction itemAction = ItemAction.getAction(action);
			switch(itemAction){
				case homebanner:
					list = HomeBannerDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = HomeBannerDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case hotnews:
					list = HotNewsDAO.getInstance().getHotNewsByPage(page, page_size);
					totalNumbers = HotNewsDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case interperspective:
					list = InterPerspectiveDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = InterPerspectiveDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case converage:
					list = ConverageDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = ConverageDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case research:
					list = ResearchDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = ResearchDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case knowTaiwan:
					list = KnowTaiwanDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = KnowTaiwanDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case database:
					list = DataBaseDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = DataBaseDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case dataaddon:
					list = DataAddonDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = DataAddonDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case researchResource:
					list = ResearchResourceDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = ResearchResourceDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case relatedWeb:
					list = RelatedWebDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = RelatedWebDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				case academic:
					list = AcademicDAO.getInstance().getDataByPage(page, page_size);
					totalNumbers = AcademicDAO.getInstance().getTotal();
					totalPages = Math.ceil(totalNumbers / (double) page_size);
					break;
				default:
					break;
			}
			url = "/backend/items/item-list.jsp";
			
			request.setAttribute("page", page);
			request.setAttribute("page_size", page_size);
			request.setAttribute("totalNumbers", totalNumbers);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("itemList", list);
			request.setAttribute("action", action);

			getServletContext().getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

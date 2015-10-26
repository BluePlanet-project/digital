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
import com.digital.common.bean.breadcrumb.BreadCrumbBean;
import com.digital.common.dao.breadcrumb.BreadCrumbDAO;
import com.oreilly.servlet.ParameterParser;

public class DataViewAction extends HttpServlet{
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
		int id = parser.getIntParameter("id", 0);
		String action = parser.getStringParameter("action", "");
		int page = parser.getIntParameter("page", 1);
		
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		ItemAction itemAction = ItemAction.getAction(action);
		switch(itemAction){
			case hotnews:
				list = HotNewsDAO.getInstance().getHotNews(id);
				break;
			case interperspective:
				list = InterPerspectiveDAO.getInstance().getData(id);
				break;
			case converage:
				list = ConverageDAO.getInstance().getData(id);
				break;
			case research:
				list = ResearchDAO.getInstance().getData(id);
				break;
			case knowTaiwan:
				list = KnowTaiwanDAO.getInstance().getData(id);
				break;
			case database:
				list = DataBaseDAO.getInstance().getData(id);
				break;
			case dataaddon:
				list = DataAddonDAO.getInstance().getData(id);
				break;
			case researchResource:
				list = ResearchResourceDAO.getInstance().getData(id);
				break;
			case relatedWeb:
				list = RelatedWebDAO.getInstance().getData(id);
				break;
			case academic:
				list = AcademicDAO.getInstance().getData(id);
				break;
			case homebanner:
				list = HomeBannerDAO.getInstance().getData(id);
				break;
			default:
				break;	
		}
		
		
		ArrayList<BreadCrumbBean> level_one = BreadCrumbDAO.getInstance().getAllBreadByLevel(1);
		ArrayList<BreadCrumbBean> level_two = BreadCrumbDAO.getInstance().getAllBreadByLevel(2);
		ArrayList<BreadCrumbBean> level_three = BreadCrumbDAO.getInstance().getAllBreadByLevel(3);
		
		request.setAttribute("page", page);
		request.setAttribute("itemsList", list);
		request.setAttribute("level_one", level_one);
		request.setAttribute("level_two", level_two);
		request.setAttribute("level_three", level_three);
		request.setAttribute("action", action);
		
		String url = "/backend/items/item-edit.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}

package com.digital.frontend.action.detail;

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
import com.digital.frontend.action.dao.hotnews.HotNewsDAO;
import com.digital.frontend.action.dao.interperspective.InterPerspectiveDAO;
import com.digital.frontend.action.dao.knowtaiwan.KnowTaiwanDAO;
import com.digital.frontend.action.dao.relatedweb.RelatedWebDAO;
import com.digital.frontend.action.dao.researchresource.ResearchResourceDAO;
import com.digital.frontend.common.bean.CommonDataBean;
import com.digital.frontend.dao.research.ResearchDAO;
import com.oreilly.servlet.ParameterParser;

public class FrontDetailAction extends HttpServlet{
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
		int id = parser.getIntParameter("id", 0);
		ItemAction itemAction = ItemAction.getAction(action);
		CommonDataBean bean = new CommonDataBean();
		ArrayList<CommonDataBean> list = new ArrayList<CommonDataBean>();
		
		switch(itemAction){
			case hotnews:
				bean = HotNewsDAO.getInstance().getDetailData(id, 1);
				list = HotNewsDAO.getInstance().getRestData(id, 1);
				break;
			case interperspective:
				bean = InterPerspectiveDAO.getInstance().getDetailData(id, 1);
				list = InterPerspectiveDAO.getInstance().getRestData(id, 1);
				break;
			case converage:
				bean = ConverageDAO.getInstance().getDetailData(id, 1);
				list = ConverageDAO.getInstance().getRestData(id, 1);
				break;
			case research:
				bean = ResearchDAO.getInstance().getDetailData(id, 1);
				list = ResearchDAO.getInstance().getRestData(id, 1);
				break;
			case knowTaiwan:
				bean = KnowTaiwanDAO.getInstance().getDetailData(id, 1);
				list = KnowTaiwanDAO.getInstance().getRestData(id, 1);
				break;
			case database:
				bean = DataBaseDAO.getInstance().getDetailData(id, 1);
				list = DataBaseDAO.getInstance().getRestData(id, 1);
				break;
			case dataaddon:
				bean = DataAddonDAO.getInstance().getDetailData(id, 1);
				list = DataAddonDAO.getInstance().getRestData(id, 1);
				break;
			case researchResource:
				bean = ResearchResourceDAO.getInstance().getDetailData(id, 1);
				list = ResearchResourceDAO.getInstance().getRestData(id, 1);
				break;
			case relatedWeb:
				bean = RelatedWebDAO.getInstance().getDetailData(id, 1);
				list = RelatedWebDAO.getInstance().getRestData(id, 1);
				break;
			case academic:
				bean = AcademicDAO.getInstance().getDetailData(id, 1);
				list = AcademicDAO.getInstance().getRestData(id, 1);
				break;
			default:
				break;
		}
		ArrayList<CommonDataBean> researchresourceList = ResearchResourceDAO.getInstance().getAllData(1);
		ArrayList<CommonDataBean> relatedwebList = RelatedWebDAO.getInstance().getAllData(1);
		ArrayList<CommonDataBean> databaseList = DataBaseDAO.getInstance().getAllData(1);
		ArrayList<CommonDataBean> dataaddonList = DataAddonDAO.getInstance().getAllData(1);
		
		request.setAttribute("action", action);
		request.setAttribute("itemBean", bean);
		request.setAttribute("itemListRight", list);
		request.setAttribute("researchresourceList", researchresourceList);
		request.setAttribute("relatedwebList", relatedwebList);
		request.setAttribute("databaseList", databaseList);
		request.setAttribute("dataaddonList", dataaddonList);
		
		String url = "/frontend/detail.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}

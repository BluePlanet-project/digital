package com.digital.backend.action.items.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.backend.common.items.ItemAction;
import com.digital.backend.dao.academic.AcademicDAO;
import com.digital.backend.dao.converage.ConverageDAO;
import com.digital.backend.dao.dataaddon.DataAddonDAO;
import com.digital.backend.dao.database.DataBaseDAO;
import com.digital.backend.dao.hotnews.HotNewsDAO;
import com.digital.backend.dao.interperspective.InterPerspectiveDAO;
import com.digital.backend.dao.knowtaiwan.KnowTaiwanDAO;
import com.digital.backend.dao.relatedweb.RelatedWebDAO;
import com.digital.backend.dao.research.ResearchDAO;
import com.digital.backend.dao.researchresource.ResearchResourceDAO;
import com.oreilly.servlet.ParameterParser;

public class DataDelAction extends HttpServlet{
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
			int id = parser.getIntParameter("id", 0);
			String action = parser.getStringParameter("action", "");
			
			ItemAction itemAction = ItemAction.getAction(action);
			if(id != 0){
				switch(itemAction){
					case hotnews:
						HotNewsDAO.getInstance().delHotNewsById(id);
						break;
					case interperspective:
						InterPerspectiveDAO.getInstance().delDataById(id);
						break;
					case converage:
						ConverageDAO.getInstance().delDataById(id);
						break;
					case research:
						ResearchDAO.getInstance().delDataById(id);
						break;
					case knowTaiwan:
						KnowTaiwanDAO.getInstance().delDataById(id);
						break;
					case database:
						DataBaseDAO.getInstance().delDataById(id);
						break;
					case dataaddon:
						DataAddonDAO.getInstance().delDataById(id);
						break;
					case researchResource:
						ResearchResourceDAO.getInstance().delDataById(id);
						break;
					case relatedWeb:
						RelatedWebDAO.getInstance().delDataById(id);
						break;
					case academic:
						AcademicDAO.getInstance().delDataById(id);
						break;
					default:
						break;
				}
			}
			
			String url = "/backend/item-list.do?action=" + action;
			response.sendRedirect(url);
		}catch(Exception e){
			throw e;
		}
	}
}

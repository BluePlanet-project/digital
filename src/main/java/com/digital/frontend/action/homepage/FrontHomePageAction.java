package com.digital.frontend.action.homepage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.frontend.action.dao.converage.ConverageDAO;
import com.digital.frontend.action.dao.dataaddon.DataAddonDAO;
import com.digital.frontend.action.dao.database.DataBaseDAO;
import com.digital.frontend.action.dao.homebanner.HomeBannerDAO;
import com.digital.frontend.action.dao.hotnews.HotNewsDAO;
import com.digital.frontend.action.dao.interperspective.InterPerspectiveDAO;
import com.digital.frontend.action.dao.relatedweb.RelatedWebDAO;
import com.digital.frontend.action.dao.researchresource.ResearchResourceDAO;
import com.digital.frontend.common.bean.CommonDataBean;
import com.digital.frontend.dao.research.ResearchDAO;
import com.oreilly.servlet.ParameterParser;

public class FrontHomePageAction extends HttpServlet{
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
			ArrayList<CommonDataBean> hotnewsList = HotNewsDAO.getInstance().getAllData(1);
			ArrayList<CommonDataBean> researchList = ResearchDAO.getInstance().getAllData(1);
			ArrayList<CommonDataBean> converageList = ConverageDAO.getInstance().getAllData(1);
			ArrayList<CommonDataBean> interperspectiveList = InterPerspectiveDAO.getInstance().getAllData(1);
			
			ArrayList<CommonDataBean> homebannerList = HomeBannerDAO.getInstance().getAllData(1);
			
			request.setAttribute("hotnewsList", hotnewsList);
			request.setAttribute("researchList", researchList);
			request.setAttribute("converageList", converageList);
			request.setAttribute("interperspectiveList", interperspectiveList);
			request.setAttribute("hotnews_title_cht", "³Ì·s®ø®§");
			
			request.setAttribute("homebannerList", homebannerList);
			
			String url = "/frontend/index.jsp";
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			
		}
	}
}

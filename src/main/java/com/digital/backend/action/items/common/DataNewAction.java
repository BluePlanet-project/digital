package com.digital.backend.action.items.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.backend.common.items.ItemAction;
import com.digital.common.bean.breadcrumb.BreadCrumbBean;
import com.digital.common.dao.breadcrumb.BreadCrumbDAO;
import com.oreilly.servlet.ParameterParser;

public class DataNewAction extends HttpServlet{
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
		
		try{
			ParameterParser parser = new ParameterParser(request);
			
			String action = parser.getStringParameter("action", "");
			
			ArrayList<BreadCrumbBean> level_one = BreadCrumbDAO.getInstance().getAllBreadByLevel(1);
			ArrayList<BreadCrumbBean> level_two = BreadCrumbDAO.getInstance().getAllBreadByLevel(2);
			ArrayList<BreadCrumbBean> level_three = BreadCrumbDAO.getInstance().getAllBreadByLevel(3);
			
			String url = "";
			
			request.setAttribute("level_one", level_one);
			request.setAttribute("level_two", level_two);
			request.setAttribute("level_three", level_three);
			request.setAttribute("action", action);
			
			/*ItemAction itemAction = ItemAction.getAction(action);
			switch(itemAction){
				case hotnews:
					
					break;
				case interperspective:					
					break;
				default:
					break;
			}*/
			
			url = "/backend/items/item-add.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

package com.digital.backend.action.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.backend.common.utils.ActionForwardUtil;
import com.oreilly.servlet.ParameterParser;

public class BackendHomeAction extends HttpServlet{
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
			HttpServletResponse response) throws Exception {
		ParameterParser parser = new ParameterParser(request);
		
		//ActionForwardUtil forwardUtil = new ActionForwardUtil();
		//String url = forwardUtil.getForwardURL("digital.backend.index");
		String url = "/backend/item-list.do?action=hotnews";
		getServletContext().getRequestDispatcher(url).forward(request, response);			
	}
}

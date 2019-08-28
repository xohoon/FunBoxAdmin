package net.admin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.admin.action.IndexAction;

import net.admin.action.LoginCheckAction;
import net.admin.action.LoginFormAction;
import net.common.action.Action;
import net.common.action.ActionForward;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		try {
			switch (command) {			
			case "/loginForm.ad":
				action = new LoginFormAction();
				forward = action.execute(request, response);
				break;
			case "/LoginCheckAction.ad":
				action = new LoginCheckAction();
				forward = action.execute(request, response);
				break;
			case "/index.ad":
				action = new IndexAction();
				forward = action.execute(request, response);
				break;
			default:
				break;
			}
			if (forward != null) {
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}

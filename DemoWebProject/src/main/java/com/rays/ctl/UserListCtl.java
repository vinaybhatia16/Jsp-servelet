package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.User1Bean;
import com.rays.model.User1Model;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User1Bean bean = new User1Bean();
		User1Model model = new User1Model();

		int pageNo = 1;
		int pageSize = 10;

		try {
			List<User1Bean> list = model.search(bean, pageNo, pageSize);
			List<User1Bean> nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("nextList" ,nextList);
			request.setAttribute("pageNo", pageNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");
		User1Bean bean = new User1Bean();
		User1Model model = new User1Model();

		int pageNo = 1;
		int pageSize = 10;

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {
			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					bean.setId(Integer.parseInt(id));
					try {
						model.delete(bean);
						request.setAttribute("succesMsg", "record deleted succesfully");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			} else {
				request.setAttribute("errorMsg", "select at least one record");
			}
		}

		if (op.equals("next")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageNo++;

		}

		if (op.equals("previous")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageNo--;
		}

		if (op.equals("search")) {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
			bean.setLogin(request.getParameter("login"));

		}
		try {
			List<User1Bean> list = model.search(bean, pageNo, pageSize);
			List<User1Bean> nextList = model.search(bean, pageNo+1, pageSize);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("list", list);
			request.setAttribute("nextList",nextList );

		} catch (Exception e) {

			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}
}

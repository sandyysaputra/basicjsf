package id.co.skyforce.basicjsf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");

		req.setAttribute("namea", name);
		req.setAttribute("agee", age);
		req.getRequestDispatcher("output.jsp").forward(req, resp);
	}

}

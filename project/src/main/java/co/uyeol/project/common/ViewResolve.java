package co.uyeol.project.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolve {
	public static void views(HttpServletRequest request, HttpServletResponse response, String viewName) 
			throws ServletException, IOException {
		String jspPage = "WEB-INF/views/" + viewName + ".jsp";
		
		RequestDispatcher dispacher = request.getRequestDispatcher(jspPage);
		dispacher.forward(request, response);
	}
}

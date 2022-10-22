package poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.CookieUtils;
import poly.common.SessionUtils;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOutSiteServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils.add("email", null, 0, response);
		
		SessionUtils.invalidate(request);
		
		request.getRequestDispatcher("/HomePage").forward(request, response);
	}

}

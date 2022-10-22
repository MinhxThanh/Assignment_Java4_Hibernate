package poly.site.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.dao.UserDao;
import poly.model.User;

/**
 * Servlet implementation class RegisterSiteServlet
 */
@WebServlet("/Register")
public class RegisterSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageInfo.prepareAndForwardSite(request, response, PageType.REGISTER_SITE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = new User();
		try {
			
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDao dao = new UserDao();
			user.setCreateDate(new Date());
			dao.insert(user);
			
			request.getRequestDispatcher("/LoginPage").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.setAttribute("user", user);
		PageInfo.prepareAndForwardSite(request, response, PageType.REGISTER_SITE_PAGE);
	}

}

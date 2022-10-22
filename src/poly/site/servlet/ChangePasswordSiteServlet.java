package poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.UserDao;
import poly.domain.ChangePassword;
import poly.model.User;

/**
 * Servlet implementation class ChangePasswordSiteServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user = new UserDao().findByEmail(SessionUtils.getLoginEmail(request));
			
			request.setAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.CHANGEPASSWORD_SITE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String emailString = SessionUtils.getLoginEmail(request);
			
			ChangePassword form = new ChangePassword();
			BeanUtils.populate(form, request.getParameterMap());
		
			request.setAttribute("email", emailString);

			if (!form.getComfrimPassword().equals(form.getNewPassword())) {
				request.setAttribute("error", "New password and comfrim password are not idential!");
			}else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getEmail(), form.getOldPassword(), form.getNewPassword());
				
				request.setAttribute("message", "Your password updated!");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.CHANGEPASSWORD_SITE_PAGE);

	}

}

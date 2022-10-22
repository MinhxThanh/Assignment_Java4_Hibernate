package poly.site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.EmailUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.UserDao;
import poly.domain.Email;
import poly.model.User;

/**
 * Servlet implementation class ForgotPasswordSiteServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordSiteServlet() {
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
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.FORGOTPASSWORD_SITE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String emailAddress = request.getParameter("email");
		try {
			if (emailAddress == null) {
				request.setAttribute("error", "Email cann't null, please!");
			} else {
				User user = new UserDao().findByEmail(emailAddress);
				
				Email email = new Email();
				email.setFrom("thanhlmps18795@fpt.edu.vn");
				email.setFromPassword("0987654321Thanh");
				email.setTo(emailAddress);
				email.setSubjectString("Forgot Pasword");

				StringBuffer sBuffer = new StringBuffer();

				sBuffer.append("<b>Dear Ms/Mr." + user.getUsername() + " </b><br>");
				sBuffer.append("This is your old password:<ins> "+ user.getPassword() +"</ins>");
				sBuffer.append("Regards <br>");
				sBuffer.append("Administraor");

				email.setContent(sBuffer.toString());
				EmailUtils.send(email);
								
				request.setAttribute("message", "System has been sent password to this email " + emailAddress + "!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.FORGOTPASSWORD_SITE_PAGE);
	}

}

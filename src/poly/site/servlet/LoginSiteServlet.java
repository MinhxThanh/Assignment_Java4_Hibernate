package poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.common.CookieUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.UserDao;
import poly.domain.LoginForm;
import poly.model.User;

/**
 * Servlet implementation class LoginSiteServlet
 */
@WebServlet("/LoginPage")
public class LoginSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = CookieUtils.get("email", request);
		
		System.out.println("Email cookie: "+ email);
		
		 if (email == null) {
			 System.out.println("1: " + email);
				PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_SITE_PAGE);
				System.out.println("...: " + email);
				return;
				
		 }
		 System.out.println("2");
		 SessionUtils.add(request, "email", email);
		 
		 request.getRequestDispatcher("/HomePage").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String remember = request.getParameter("remember");
//
//		// kiểm tra tài khoản đăng nhập
//		if (!username.equalsIgnoreCase("poly")) {
//			request.setAttribute("error", "Sai tên đăng nhập!");
//		} else if (password.length() < 6) {
//			request.setAttribute("error", "Sai mật khẩu!");
//		} else {
//			request.setAttribute("message", "Đăng nhập thành công!");
//			// ghi nhớ hoặc xóa tài khoản đã ghi nhớ bằng cookie 
//			int hours = (remember == null) ? 0 : 30*24; // 0 = xóa 
//			CookieUtils.add("username", username, hours, response); 
//			CookieUtils.add("password", password, hours, response);
//		}
		
		
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			System.out.println("form: " + form.getEmail());
			System.out.println("password: " + form.getPassword());
			UserDao dao = new UserDao();
			User user = dao.Login(form.getEmail(), form.getPassword());
			
			System.out.println("user: " + user);
			if (user == null) {
				request.setAttribute("error", "Invalid email or password");
				PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_SITE_PAGE);
			}else {
				System.out.println("sessiton email: " + user.getEmail());
				SessionUtils.add(request, "email", user.getEmail());
				System.out.println("checkbox: " + form.isRemember());
				if(form.isRemember()) {
					CookieUtils.add("email", form.getEmail(), 48, response);
				}else {
					CookieUtils.add("email", form.getEmail(), 0, response);
				}
				if (user.getRole() == 0) {
					request.getRequestDispatcher("/HomePage").forward(request, response);
				}else if (user.getRole() == 1) {
					request.getRequestDispatcher("/VideoManagement").forward(request, response);
				}
				request.getSession().setAttribute("user", user);
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", e.getMessage());
		}
	}

}

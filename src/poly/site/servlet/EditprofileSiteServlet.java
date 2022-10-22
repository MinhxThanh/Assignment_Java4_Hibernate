package poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.common.UploadUtils;
import poly.dao.UserDao;
import poly.dao.VideoCountryDao;
import poly.model.User;
import poly.model.VideoCountry;

/**
 * Servlet implementation class EditprofileSiteServlet
 */
@WebServlet("/Editprofile")
@MultipartConfig
public class EditprofileSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditprofileSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = SessionUtils.getLoginEmail(request);
		
		System.out.println("email: " + email);
		
		if (email == null) {
			request.getRequestDispatcher("/LoginPage").forward(request, response);
			return;
		}
		try {
			
			User user = new UserDao().findByEmail(email);
						
			request.setAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		this.getDatabase(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("123");
		String username = request.getParameter("username");
		String country = request.getParameter("country");
////		byte[] image = request.getParameter("image");
		System.out.println("id1: " + id);
		System.out.println("username: " + username);
		System.out.println("country: " + country);
		try {
			User user = new User();
//			BeanUtils.populate(user, request.getParameterMap());
			
//			String email = SessionUtils.getLoginEmail(request);
			UserDao dao = new UserDao();
			User oldUser = dao.findByEmail(SessionUtils.getLoginEmail(request));
						
			user.setUserID(Integer.parseInt(id));
			user.setUsername(username);
			
			if (request.getPart("coverUser").getSize() == 0) {
				user.setImage(oldUser.getImage());
			} else {
				user.setImage("uploadUser/" + UploadUtils.processUploadFileUser("coverUser", request, "/uploadUser",
						String.valueOf(user.getUserID())));
			}
			if (request.getParameter("country").equals("Country?")) {
				user.setCountry(oldUser.getCountry());
			}else {
				user.setCountry(user.getCountry());
			}
			
			dao.update(user);
			
			request.setAttribute("message", "User profile updated!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		this.getDatabase(request, response);

	}
	
	private void getDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoCountryDao countryDao = new VideoCountryDao();
			
			List<VideoCountry> videoCountries = countryDao.findAll();
			
			request.setAttribute("videoCountrys", videoCountries);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.EDITPROFILE_SITE_PAGE);
	}

}

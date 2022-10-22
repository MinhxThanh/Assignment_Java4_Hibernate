package poly.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.common.CookieUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.common.UploadUtils;
import poly.dao.UserDao;
import poly.dao.VideoCountryDao;
import poly.model.User;
import poly.model.VideoCountry;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet({"/UserManagement", "/createUser", "/deleteUser", "/updateUser", "/resetUser", "/editUser", "/insertCountryUser"})
@MultipartConfig
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = CookieUtils.get("email", request);

		System.out.println("Email cookie: " + email);

		if (email == null) {
			System.out.println("1: " + email);
			PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_SITE_PAGE);
			System.out.println("...: " + email);
			return;

		}
		UserDao dao = new UserDao();
		User user = dao.findByEmail(email);
		if (user.getRole() == 0) {
			CookieUtils.add("email", null, 0, response);

			SessionUtils.invalidate(request);

			PageInfo.prepareAndForwardSite(request, response, PageType.LOGIN_SITE_PAGE);
		}
		
		
		String urlString = request.getRequestURL().toString();
		if (urlString.contains("editUser")) {
			edit(request, response);
			return;
		}
		if (urlString.contains("deleteUser")) {
			delete(request, response);
			return;
		}
		if (urlString.contains("resetUser")) {
			reset(request, response);
			return;
		}
		this.getDatabase(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String urlString = request.getRequestURL().toString();
		if (urlString.contains("createUser")) {
			insert(request, response);
			return;
		}
		if (urlString.contains("updateUser")) {
			update(request, response);
			return;
		}
		if (urlString.contains("insertCountryUser")) {
			insertCountry(request, response);
			return;
		}

		this.getDatabase(request, response);
	}

	

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDao dao = new UserDao();
			User oldUser = dao.findByID(user.getUserID());
			
			user.setCreateDate(oldUser.getCreateDate());
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
			
			request.setAttribute("user", user);
			request.setAttribute("message", "User updated!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = simpleDateFormat.format(new Date());
		
		User user = new User();
		try {
			Date dt = simpleDateFormat.parse(strDate);
			BeanUtils.populate(user, request.getParameterMap());
			
			user.setCreateDate(dt);
			user.setImage("uploadUser/" + UploadUtils.processUploadFileUser("coverUser", request, "/uploadUser",
					String.valueOf(user.getUserID())));

			UserDao dao = new UserDao();
			dao.insert(user);
			
			request.setAttribute("user", user);
			request.setAttribute("message", "User inserted!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
	}

	private void insertCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoCountry country = new VideoCountry();
		try {
			VideoCountryDao dao = new VideoCountryDao();
			
			country.setName(request.getParameter("inserCountry"));
			
			dao.insert(country);
			
			request.setAttribute("message", "Country inserted!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("user", new User());
		this.getDatabase(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("id");
		try {
			UserDao dao = new UserDao();
			
			dao.dalete(Integer.parseInt(userID));
			
			request.setAttribute("message", "User deleted!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("id");
		System.out.println("edit-userid: " + userID);
		
		if (userID == null) {
			request.setAttribute("error", "User ID is required!!");
			this.getDatabase(request, response);
			return;
		}
		
		try {
			UserDao dao = new UserDao();
			User user = dao.findByID(Integer.parseInt(userID));
			
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
	}

	private void getDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoCountryDao countryDao = new VideoCountryDao();
			UserDao userDao = new UserDao();
			
			List<VideoCountry> videoCountries = countryDao.findAll();
			List<User> users = userDao.findAll();
			
			request.setAttribute("videoCountrys", videoCountries);
			request.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGEMENT_PAGE);
	}
}

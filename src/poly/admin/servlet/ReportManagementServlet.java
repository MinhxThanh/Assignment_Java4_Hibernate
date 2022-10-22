package poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Insert;

import poly.common.CookieUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.FavoriteDao;
import poly.dao.UserDao;
import poly.dao.VideoDao;
import poly.domain.FavoriteReport;
import poly.domain.FavoriteUserReport;
import poly.model.User;
import poly.model.Video;

/**
 * Servlet implementation class ReportManagementServlet
 */
@WebServlet({ "/ReportManagement" })
public class ReportManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

		reportFavoriteByVideos(request, response);
		reportFavoriteUserByVideos(request, response);

//		try {
//			VideoDao videoDao = new VideoDao();
//			List<Video> vlList = videoDao.findAll();
//			request.setAttribute("vlList", vlList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		PageInfo.prepareAndForwardAdmin(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void reportFavoriteByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();

			List<FavoriteReport> list = dao.reportFavariteByViddeos();

			request.setAttribute("favoriteList", list);
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportFavoriteUserByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int videoUserID = 0;
		try {
			String videoUserIDString = request.getParameter("videoUserID");

			System.out.println("videoUserIDString: " + videoUserIDString);

			VideoDao videoDao = new VideoDao();
			List<Video> vlList = videoDao.findAll();

			if (videoUserIDString == null && vlList.size() > 0) {
				videoUserID = vlList.get(0).getVideoID();
				videoUserIDString = String.valueOf(videoUserID);
			}

			System.out.println("videoUserIDString1: " + videoUserIDString);
			System.out.println("videoUserID: " + videoUserID);

			FavoriteDao dao = new FavoriteDao();

			List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideo(Integer.parseInt(videoUserIDString));

			request.setAttribute("videoUserID", videoUserIDString);
			request.setAttribute("vlList", vlList);
			request.setAttribute("FavoriteUser", list);
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}

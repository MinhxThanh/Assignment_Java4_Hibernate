package poly.site.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.dao.VideoDao;
import poly.model.Video;

/**
 * Servlet implementation class HomeSiteServlet
 */
@WebServlet("/HomePage")
public class HomeSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeSiteServlet() {
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
		try {
			int page = 0;
			try {
				page = Integer.parseInt(request.getParameter("page")) -1;
			} catch (Exception ex) {
				page = 0;
			}
			VideoDao dao = new VideoDao();

			List<Video> list = dao.getVideoPaging(page);
			
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPage", dao.getTotalPage());			
			request.setAttribute("videos", list);
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}

		PageInfo.prepareAndForwardSite(request, response, PageType.HOME_SITE_PAGE);

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

}

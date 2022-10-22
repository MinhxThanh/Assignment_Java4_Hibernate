package poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.FavoriteDao;
import poly.dao.UserDao;
import poly.domain.FavoriteUser;
import poly.model.User;


/**
 * Servlet implementation class FavoriteVideoSiteServlet
 */
@WebServlet("/FavoriteVideo")
public class FavoriteVideoSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String emailString = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteVideoSiteServlet() {
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
		emailString = email;
		
		if (email == null) {
			request.getRequestDispatcher("/LoginPage").forward(request, response);
			return;
		}
		
		this.getVideoUserFavorite(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = request.getParameter("videoID");
		
		System.out.println("videoID-post: " + videoID);
		
		if (videoID == null) {
			PageInfo.prepareAndForwardSite(request, response, PageType.FAVORITE_SITE_PAGE);
			return;
		}
		
		try {
			User user = new UserDao().findByEmail(emailString);
			
			FavoriteDao dao = new FavoriteDao();
			dao.deleteVideoFavoriteUser(user.getUserID(), Integer.parseInt(videoID));
			
			this.getVideoUserFavorite(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getVideoUserFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new UserDao().findByEmail(emailString);
			
			FavoriteDao dao = new FavoriteDao();
			
			List<FavoriteUser> list = dao.favoriteUserVideo(user.getUserID());
			
			request.setAttribute("favorite", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.FAVORITE_SITE_PAGE);
		
	}

}

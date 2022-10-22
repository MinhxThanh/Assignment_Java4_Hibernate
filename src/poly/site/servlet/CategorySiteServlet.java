package poly.site.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.EmailUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.dao.AnCommentDao;
import poly.dao.CommentDao;
import poly.dao.FavoriteDao;
import poly.dao.RateDao;
import poly.dao.ShareDao;
import poly.dao.UserDao;
import poly.dao.VideoDao;
import poly.domain.Email;
import poly.model.AnConmment;
import poly.model.Comment;
import poly.model.Favorite;
import poly.model.Rate;
import poly.model.Share;
import poly.model.User;
import poly.model.Video;

/**
 * Servlet implementation class CategorySiteServlet
 */
@WebServlet({ "/Category", "/categoryFavorite", "/categoryShare" ,"/categoryComment", "/categoryRemoveComment", "/categoryRating", "/categoryAnComment"})
public class CategorySiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String categoryVideoID = "";
	 String emailString = "";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategorySiteServlet() {
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
		String videoID = "";
		if(categoryVideoID == "") {
			videoID = request.getParameter("id");
			System.out.println("videoID-info: " + videoID);
			categoryVideoID = videoID;
		}
		if((categoryVideoID != null) && (!categoryVideoID.equals(request.getParameter("id")))){
			videoID = request.getParameter("id");
			System.out.println("videoID-info: " + videoID);
			categoryVideoID = videoID;
		}
		
		
		System.out.println("searchID: " + videoID);
		
		
		String urlString = request.getRequestURL().toString();
		if(urlString.contains("categoryRemoveComment")) {
			
			categoryRemoveComment(request, response);
			return;
		}
		
		
		
		this.inforVideo(request, response);
		System.out.println("categoryVideoID: " + categoryVideoID);
		
//		AnCommentDao anCommentDao = new AnCommentDao();
//		List<AnConmment> anCommnetList = anCommentDao.getAllCommmentByVideoIDAndCommentID(Integer.parseInt(videoID), Integer.parseInt(request.getParameter("commentIDtest")));
//		
		System.out.println("anCommnetList: " + request.getParameter("commentIDtest"));
//		System.out.println("anCommnetList1: " + anCommnetList);

	}

	private void inforVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String videoID = categoryVideoID;
		System.out.println("videoID-info: " + videoID);
		
		if (videoID == null) {
			response.sendRedirect("HomePage");
			return;
		}
		
		try {
			String email = SessionUtils.getLoginEmail(request);
			
			VideoDao dao = new VideoDao();
			Video video = dao.findByID(Integer.parseInt(videoID));
			
			CommentDao commentDao = new CommentDao();
			List<Comment> commentList = commentDao.getAllCommmentByVideoID(Integer.parseInt(videoID));
			
			for (Comment comment : commentList) {
				AnCommentDao commentAnDao = new AnCommentDao();
				List<AnConmment> anCommnetList = commentAnDao.getAllCommmentByVideoIDAndCommentID(Integer.parseInt(videoID), comment.getCommentID());
				System.out.println("anCommnetList test:" + anCommnetList);
				
				request.setAttribute("anCommnetList", anCommnetList);
			}
			
			
			
			double ratingPoint = new RateDao().getMediumRatingVideo(Integer.parseInt(videoID));
			double totalUserRated = new RateDao().getTotalUserRated(Integer.parseInt(videoID));
			
			if (email != null) {
				User user = new UserDao().findByEmail(email);
				
				Rate rate = new RateDao().findUseridAndVideoidInRate(user.getUserID(), Integer.parseInt(videoID));
				
				System.out.println("rate poin1: " + rate.getPoint());
				
				System.out.println("VideoID rate: " + rate.getVideo().getVideoID());
				
				if (video.getVideoID() == rate.getVideo().getVideoID()) {		
					System.out.println("rate poin: " + rate.getPoint());
					request.setAttribute("rate", rate);
				}

			}
			
			request.setAttribute("commentAnVideoID", videoID);
			
			request.setAttribute("commentUser", commentList);
			request.setAttribute("totalUserRated", String.format("%.0f", totalUserRated));
			request.setAttribute("ratingPoint", String.format("%.1f", ratingPoint));
			
			request.setAttribute("video", video);
			PageInfo.prepareAndForwardSite(request, response, PageType.CATEGORY_SITE_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = SessionUtils.getLoginEmail(request);
		
		System.out.println("email: " + email);
		emailString = email;
		
		if (email == null) {
			request.getRequestDispatcher("/LoginPage").forward(request, response);
			return;
		}
		
		
		String urlString = request.getRequestURL().toString();
		if (urlString.contains("categoryShare")) {
			categoryShare(request, response);
			return;
		}
		if(urlString.contains("categoryFavorite")) {
			categoryFavorite(request, response);
			return;
		}
		if(urlString.contains("categoryComment")) {
			categoryComment(request, response);
			return;
		}
		if(urlString.contains("categoryRating")) {
			categoryRating(request, response);
			return;
		}
		if(urlString.contains("categoryAnComment")) {
			System.out.println("1commented!");
			categoryAnComment(request, response);
			System.out.println("2commented!");
			return;
		}
		
	}
	
	private void categoryRating(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String point = request.getParameter("rating");
		
		try {
			User user = new UserDao().findByEmail(emailString);
			
			RateDao rateDao = new RateDao();
			
			System.out.println("categoryRating videoID: " + categoryVideoID);
			System.out.println("categoryRating findUserRate: " + rateDao.findUseridAndVideoidInRate(user.getUserID(), Integer.parseInt(categoryVideoID)) );
			
			if ((rateDao.findUseridAndVideoidInRate(user.getUserID(), Integer.parseInt(categoryVideoID)) == null) ) {
				Rate rate = new Rate();
				rate.setPoint(Float.parseFloat(point));
				rate.setUser(new UserDao().findByEmail(emailString));
				rate.setVideo(new VideoDao().findByID(Integer.parseInt(categoryVideoID)));
				
				rateDao.insert(rate);
				System.out.println("insert rate successful!");
			}else {
				RateDao dao = new RateDao();
				Rate rateOld = dao.findUseridAndVideoidInRate(user.getUserID(), Integer.parseInt(categoryVideoID)); 
				
				Rate rate = new Rate();
				rate.setRateID(rateOld.getRateID());
				rate.setUser(rateOld.getUser());
				rate.setVideo(rateOld.getVideo());
				rate.setPoint(Float.parseFloat(point));
				
				rateDao.update(rate);
				System.out.println("update rate successful!");
			}
			System.out.println("Rating success this film " + point + " point!");
			request.setAttribute("message", "Rating success this film " + point + " point!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.inforVideo(request, response);
	}

	private void categoryRemoveComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String commentID = request.getParameter("commentID");
			
			System.out.println("commentID: " + commentID);
			
			CommentDao dao = new CommentDao();
			dao.dalete(Integer.parseInt(commentID));

			request.setAttribute("message", "Comment deleted!!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.inforVideo(request, response);
		
	}
	
	private void categoryAnComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = sdf.format(cal.getTime());
		
        String contentComment = request.getParameter("contentAnComment");
        String anCommentID = request.getParameter("commentAnID");
        
		AnConmment comment = new AnConmment();
		System.out.println("commented!?  " + anCommentID);
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat();
	        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
			Date date = sdf1.parse(strDate);
			System.out.println("date: " + date);
			
			User user = new UserDao().findByEmail(emailString);
			AnCommentDao dao = new AnCommentDao();
			
			comment.setComment(new CommentDao().findByID(Integer.parseInt(anCommentID)));
			comment.setImage(user.getImage());
			comment.setContent(contentComment);
			comment.setTitle(user.getUsername());
			comment.setCreateDate(new Date(System.currentTimeMillis()));
			comment.setUser(user);
			comment.setVideo(new VideoDao().findByID(Integer.parseInt(categoryVideoID)));
			
			dao.insert(comment);
			
			System.out.println("commented!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail!");
		}
		this.inforVideo(request, response);
	}

	private void categoryComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = sdf.format(cal.getTime());
		
		String contentComment = request.getParameter("contentComment");
		Comment comment = new Comment();
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat();
	        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
			Date date = sdf1.parse(strDate);
			System.out.println("date: " + date);
			
			User user = new UserDao().findByEmail(emailString);
			CommentDao dao = new CommentDao();
			
			comment.setImage(user.getImage());
			comment.setContent(contentComment);
			comment.setTitle(user.getUsername());
			comment.setCreateDate(new Date(System.currentTimeMillis()));
			comment.setUser(user);
			comment.setVideo(new VideoDao().findByID(Integer.parseInt(categoryVideoID)));
			
			dao.insert(comment);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.inforVideo(request, response);
	}

	private void categoryFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = categoryVideoID;
		System.out.println("videoID: " + videoID);

		Favorite favorite = new Favorite();
		try {
			FavoriteDao dao = new FavoriteDao();

			favorite.setLikeDate(new Date());

			favorite.setUser(new UserDao().findByEmail(SessionUtils.getLoginEmail(request)));
			
			System.out.println("video-: " + videoID);
			
			favorite.setVideo(new VideoDao().findByID(Integer.parseInt(videoID)));
			
			dao.insert(favorite);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.inforVideo(request, response);
		System.out.println("categoryVideoID: " + categoryVideoID);
	}

	private void categoryShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = categoryVideoID;
		String emailAddress = request.getParameter("email");
		try {
			if (videoID == null) {
				request.setAttribute("error", "Video ID is null!");
			} else {
				Email email = new Email();
				email.setFrom("thanhlmps18795@fpt.edu.vn");
				email.setFromPassword("0987654321Thanh");
				email.setTo(emailAddress);
				email.setSubjectString("Share Favorite Video");

				StringBuffer sBuffer = new StringBuffer();

				sBuffer.append("Dear Ms/Mr. <br>");
				sBuffer.append("The video is more interesting and I want to share this with you! <br>");
				sBuffer.append("Please click the link: ")
						.append(String.format("<a href=''>View Video</a> <br>", videoID));
				sBuffer.append("Regards <br>");
				sBuffer.append("Administraor");

				email.setContent(sBuffer.toString());
				EmailUtils.send(email);
				
				System.out.println("video-1: " + videoID);
				
				ShareDao dao = new ShareDao();
				Share share = new Share();
				
				share.setEmails(emailAddress);
				share.setShareDate(new Date());
				
//				String userID = SessionUtils.getLoginEmail(request);
//				UserDao userDao = new UserDao();
//				User user = userDao.findByEmail(userID);
				
				share.setUser(new UserDao().findByEmail(SessionUtils.getLoginEmail(request)));
				
				System.out.println("video-: " + videoID);
				
				share.setVideo(new VideoDao().findByID(Integer.parseInt(videoID)));
				
				dao.insert(share);
				
				System.out.println("inserted");
				
				request.setAttribute("message", "Video link has been sent!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.inforVideo(request, response);
	}

//	private void categoryShareSearchID(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//		String videoID = request.getParameter("id");
//		
//		System.out.println("searchID: " + videoID);
//		categoryVideoID = videoID;
//		
//		if (videoID == null) {
//			response.sendRedirect("/HomePage");
//			return;
//		}
//
//		request.setAttribute("videoID", videoID);
//		PageInfo.prepareAndForwardSite(request, response, PageType.CATEGORY_SITE_PAGE);
//	}
}

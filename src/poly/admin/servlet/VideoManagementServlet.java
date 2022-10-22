package poly.admin.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import poly.common.CookieUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;
import poly.common.UploadUtils;
import poly.dao.UserDao;
import poly.dao.VideoCountryDao;
import poly.dao.VideoDao;
import poly.dao.VideoTypeDao;
import poly.model.User;
import poly.model.Video;
import poly.model.VideoCountry;
import poly.model.VideoType;

/**
 * Servlet implementation class VideoManagementServlet
 */
@WebServlet({ "/VideoManagement", "/create", "/delete", "/update", "/reset", "/edit", "/insertType", "/insertCountry" })
@MultipartConfig
public class VideoManagementServlet extends HttpServlet {

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
		
		
		String urlString = request.getRequestURL().toString();
		if (urlString.contains("edit")) {
			edit(request, response);
			return;
		}
		if (urlString.contains("delete")) {
			delete(request, response);
			return;
		}
		if (urlString.contains("reset")) {
			reset(request, response);
			return;
		}

		this.getDatabase(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String urlString = request.getRequestURL().toString();
		if (urlString.contains("create")) {
			insertNew(request, response);
			return;
		}
		if (urlString.contains("update")) {
			updateNew(request, response);
			return;
		}
		if (urlString.contains("reset")) {
			reset(request, response);
			return;
		}
		if (urlString.contains("insertType")) {
			insertType(request, response);
			return;
		}
		if (urlString.contains("insertCountry")) {
			insertCountry(request, response);
			return;
		}

		this.getDatabase(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void insertCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoCountry country = new VideoCountry();
		try {

			VideoCountryDao dao = new VideoCountryDao();

			country.setName(request.getParameter("insertCountry"));

			dao.insert(country);
			
			request.setAttribute("message", "Video country inserted!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void insertType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoType type = new VideoType();
		try {

			VideoTypeDao dao = new VideoTypeDao();

			type.setName(request.getParameter("nameType"));

			dao.insert(type);
			request.setAttribute("videoTypes", type);
			request.setAttribute("message", "Video type inserted!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		this.getDatabase(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void insertNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String videoTypeString = request.getParameter("clipType");
		String videoCountryString = request.getParameter("clipCountry");

		System.out.println("test: " + request.getParameter("hiddenId"));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = simpleDateFormat.format(new Date());
		
		Video video = new Video();
		try {
			Date dt = simpleDateFormat.parse(strDate);
			BeanUtils.populate(video, request.getParameterMap());

			System.out.println("type: " + video.getVideoType());
			System.out.println("country: " + video.getVideoCountry());

			video.setVideoType(new VideoTypeDao().findByID(Integer.parseInt(videoTypeString)));
			video.setVideoCountry(new VideoCountryDao().findByID(Integer.parseInt(videoCountryString)));
			video.setCreateDate(dt);
			video.setViews(0);
//			if (request.getPart("cover").getSize() == 0) {
//				video.setPoster("uploads/");
//			} else {
				video.setPoster("uploads/" + UploadUtils.processUploadFile("cover", request, "/uploads",
						String.valueOf(video.getVideoID())));
//			}
			VideoDao dao = new VideoDao();
			dao.insert(video);

			this.getDatabase(request, response);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video inserted!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void updateNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String videoID = request.getParameter("videoID");
//		System.out.println("id-edit: " + videoID);
//		if (videoID == null) {
//			request.setAttribute("error", "Video id is required!!");
//			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
//			return;
//		}
		String videoTypeString = request.getParameter("clipType");
		String videoCountryString = request.getParameter("clipCountry");

		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());

//			video.setVideoType(new VideoTypeDao().findByID(video.getVideoType()));
//			video.setVideoCountry(new VideoCountryDao().findByID(video.getVideoCountry()));

			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findByID(video.getVideoID());

			System.out.println("id: " + video.getVideoID());

			if (request.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster("uploads/" + UploadUtils.processUploadFile("cover", request, "/uploads",
						String.valueOf(video.getVideoID())));
			}
			video.setVideoType(new VideoTypeDao().findByID(Integer.parseInt(videoTypeString)));
			video.setVideoCountry(new VideoCountryDao().findByID(Integer.parseInt(videoCountryString)));
			video.setVideoID(oldVideo.getVideoID());
			video.setViews(oldVideo.getViews());
			video.setCreateDate(oldVideo.getCreateDate());

			dao.update(video);

			this.getDatabase(request, response);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video updated!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("video", new Video());
		this.getDatabase(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String videoID = request.getParameter("videoID");
			VideoDao dao = new VideoDao();
			dao.dalete(Integer.parseInt(videoID));

			request.setAttribute("message", "Video deleted!!");
			this.getDatabase(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	@SuppressWarnings("unused")
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoID = request.getParameter("videoID");
		System.out.println("id-edit: " + videoID);
		if (videoID == null) {
			request.setAttribute("error", "Video id is required!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}

		String titleString = request.getParameter("title");
		String otherNameString = request.getParameter("otherName");
		String videoTypeString = request.getParameter("videoType");
		String videoCountryString = request.getParameter("videoCountry");
		String actionString = request.getParameter("action");
		String description = request.getParameter("desCription");

		System.out.println("type-update: " + Integer.parseInt(videoTypeString));
		try {
			Video video = new Video();
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findByID(Integer.parseInt(videoID));

			video.setTitle(titleString);
			video.setOtherName(otherNameString);
			video.setVideoType(new VideoTypeDao().findByID(Integer.parseInt(videoTypeString)));
			video.setVideoCountry(new VideoCountryDao().findByID(Integer.parseInt(videoCountryString)));
			video.setAction(Integer.parseInt(actionString));
			video.setDesCription(description);

			if (request.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster("uploads/" + UploadUtils.processUploadFile("cover", request, "/uploads",
						String.valueOf(video.getVideoID())));
			}
			video.setVideoID(oldVideo.getVideoID());
			video.setViews(oldVideo.getViews());
			video.setCreateDate(oldVideo.getCreateDate());

			dao.update(video);

			this.getDatabase(request, response);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video updated!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	@SuppressWarnings("unused")
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = simpleDateFormat.format(new Date());

		String titleString = request.getParameter("title");
		String otherNameString = request.getParameter("otherName");
		String videoTypeString = request.getParameter("videoType");
		String videoCountryString = request.getParameter("videoCountry");
		String actionString = request.getParameter("action");
		String description = request.getParameter("desCription");

		System.out.println("type: " + videoTypeString);

		try {
			Date dt = simpleDateFormat.parse(strDate);
			Video video = new Video();

			video.setTitle(titleString);
			video.setOtherName(otherNameString);
			video.setVideoType(new VideoTypeDao().findByID(Integer.parseInt(videoTypeString)));
			video.setVideoCountry(new VideoCountryDao().findByID(Integer.parseInt(videoCountryString)));
			video.setAction(Integer.parseInt(actionString));
			video.setDesCription(description);
			video.setViews(0);
			video.setCreateDate(dt);
//			video.setPoster(UploadUtils.setImage("photo_file", request));

			VideoDao dao = new VideoDao();
			dao.insert(video);

			this.getDatabase(request, response);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video insert success!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String videoID = request.getParameter("id");
		System.out.println("id-edit: " + videoID);
		if (videoID == null) {
			request.setAttribute("error", "Video id is required!!");
			this.getDatabase(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}

		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findByID(Integer.parseInt(videoID));

			request.setAttribute("video", video);
			this.getDatabase(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void getDatabase(HttpServletRequest request, HttpServletResponse response) {
		try {
			VideoCountryDao videoCountryDao = new VideoCountryDao();
			VideoTypeDao videoTypeDao = new VideoTypeDao();
			VideoDao videoDao = new VideoDao();

			List<VideoCountry> videoCountry = videoCountryDao.findAll();
			List<VideoType> videoType = videoTypeDao.findAll();
			List<Video> list = videoDao.findAll();

			request.setAttribute("videoCountrys", videoCountry);
			request.setAttribute("videoTypes", videoType);
			request.setAttribute("videos", list);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}

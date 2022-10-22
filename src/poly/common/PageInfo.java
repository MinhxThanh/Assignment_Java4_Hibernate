package poly.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap();
	
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report Management", "/admin/reports/reports.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management", "/admin/videos/videos.jsp", null));

		pageRoute.put(PageType.HOME_SITE_PAGE, new PageInfo("Home", "/views/site/items/item-content.jsp", null));
		pageRoute.put(PageType.LOGIN_SITE_PAGE, new PageInfo("Login", "/views/site/login.jsp", null));
		pageRoute.put(PageType.REGISTER_SITE_PAGE, new PageInfo("Register", "/views/site/register.jsp", null));
		pageRoute.put(PageType.CATEGORY_SITE_PAGE, new PageInfo("Category", "/views/site/category.jsp", null));
		pageRoute.put(PageType.EDITPROFILE_SITE_PAGE, new PageInfo("Edit Profile", "/views/site/editprofile.jsp", null));
		pageRoute.put(PageType.FAVORITE_SITE_PAGE, new PageInfo("Favorite", "/views/site/items/item-content-favorite.jsp", null));
		pageRoute.put(PageType.FORGOTPASSWORD_SITE_PAGE, new PageInfo("Forgot Password", "/views/site/forgotPassword.jsp", null));
		pageRoute.put(PageType.CHANGEPASSWORD_SITE_PAGE, new PageInfo("Change Password", "/views/site/items/changePassword.jsp", null));

	}
	public static void prepareAndForwardAdmin(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("admin/layout.jsp").forward(request, response);
	}
	
	public static void prepareAndForwardSite(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("views/site/index.jsp").forward(request, response);
	}
	
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getcontentUrl() {
		return contentUrl;
	}
	public void setcontentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getscriptUrl() {
		return scriptUrl;
	}
	public void setscriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
}


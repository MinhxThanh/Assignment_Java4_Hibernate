package poly.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	// Tạo và gửi cookie về client để lưu
	public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}

	// Đọc giá trị cookie gửi từ client
	public static String get(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}

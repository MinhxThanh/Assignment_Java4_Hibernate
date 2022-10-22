package poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import poly.common.SessionUtils;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns = "/AuthFilter")
public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setAttribute("isLogin", SessionUtils.isLogin((HttpServletRequest) request));
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}

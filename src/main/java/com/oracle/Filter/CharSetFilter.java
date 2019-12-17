package com.oracle.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CharSetFilter
 */
public class CharSetFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharSetFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String pp = req.getHeader("X-Requested-With");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if (pp != null && pp.equalsIgnoreCase("XMLHttpRequest")) {
			response.setContentType("application/json;charset=utf-8");

		} else {
			response.setContentType("text/html;charset=utf-8");

		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

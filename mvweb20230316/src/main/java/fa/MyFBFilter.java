package fa;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class MyFBFilter
 */

//@WebFilter("/MyFBFilter")
@WebFilter(filterName = "MyFBFilter", urlPatterns = {"/fb/*"})
public class MyFBFilter extends HttpFilter implements Filter {
	
	private FilterConfig fConfig = null;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public MyFBFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Pre-Process Start");
		System.out.println("Pre-Process==>" + fConfig.getFilterName());
		long start = System.currentTimeMillis();
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		System.out.println("執行時間:" + (end - start) + "ms");
		System.out.println("Post-Process==>" + fConfig.getFilterName());
		System.out.println("=====================================");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		if (fConfig == null) {
			return ("FilterA()");
		}
		StringBuffer sb = new StringBuffer("FilterA(");
		sb.append(fConfig);
		sb.append(")");
		return (sb.toString());
	}

	public void log(String msg) {
		fConfig.getServletContext().log(msg);
	}
}

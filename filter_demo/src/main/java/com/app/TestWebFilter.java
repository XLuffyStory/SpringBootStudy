package com.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestWebFilter 的过滤路径是 /test
 * 
 * @WebFilter 需要与 放到启动类的 @ServletComponentScan 一起使用
 * 
 *            https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/htmlsingle/#boot-features-embedded-container-servlets-filters-listeners-scanning
 *            When using an embedded container, automatic registration of
 *            classes annotated with @WebServlet, @WebFilter, and @WebListener
 *            can be enabled by using @ServletComponentScan.
 * 
 *
 */

@WebFilter(filterName = "testWebFilter", urlPatterns = "/test")
public class TestWebFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	logger.info("Test Web Filter: " + req.getRequestURI());

	// 当注释掉这行时，GET localhost:8081/test 不会有任何返回值
	// 可以根据条件判断是否执行 chain.doFilter(request, response);
	// 如果不执行chain.doFilter(request, response);
	// 那么GET localhost:8081/test 对应的controller方法也不会执行
	chain.doFilter(request, response);

    }

    public void destroy() {

    }

}

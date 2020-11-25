package com.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * TestFilter 的过滤路径是 /*
 *
 */
@Component
public class TestFilter implements Filter{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void init(FilterConfig filterConfig) throws ServletException {
	
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest req =(HttpServletRequest) request;
	logger.info("Test Filter: " + req.getRequestURI());
	
	chain.doFilter(request, response);
    }

    public void destroy() {
	
    }
    

}

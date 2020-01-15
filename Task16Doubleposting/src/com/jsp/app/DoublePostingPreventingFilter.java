package com.jsp.app;

import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;
@WebFilter(value="/*")
public class DoublePostingPreventingFilter implements Filter {
	
	@Override
	public void init(FilterConfig fg) throws ServletException { 
	}
	HttpSession session = null ;
	HttpServletRequest hreq = null ;
	int serverToken = 0 ;
	int clientToken = 0 ;
	//type casting
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
	FilterChain chain) throws IOException, ServletException {
		
	hreq = (HttpServletRequest)req;
     PrintWriter writer = res.getWriter();
	//session = hreq.getSession(true);
	//for 1st request when Session obj is not there for browser
	if(hreq.getMethod().equals("GET")){
	session = hreq.getSession(true);
	session.setAttribute("stoken", new Random().nextInt(10000));
	chain.doFilter(req, res);
	}else{
	//read ServerSessionToken
		try{
	serverToken = (Integer)session.getAttribute("stoken");
	//read clientSessionToken
	
	session.setMaxInactiveInterval(10);
	}catch(Exception ae){
		System.out.println("session time out");
		writer.println("session timeout......");
	}
	System.out.println("serverToken:"+serverToken);
	clientToken = Integer.parseInt(req.getParameter("ctoken"));
	System.out.println("clientToken:"+clientToken);
	System.out.println(clientToken+"----------"+serverToken);
	
	if(serverToken == clientToken){
	session.setAttribute("stoken",  new Random().nextInt(10000));
	chain.doFilter(req, res);
	}else{
	RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
	rd.forward(req, res);
	}
	
	}
	}
	@Override
	public void destroy() { 
	}
	}     

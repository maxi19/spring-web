package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.spring.entidad.Auto;
import com.spring.service.AutoService;

@WebServlet("/auto")
public class AltaAutoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private  AutoService autoService;
	
	@Override
	public void init() throws ServletException {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		this.autoService = (AutoService) ctx.getBean("service");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Auto auto =	(Auto) req.getAttribute("auto");
		Auto auto = new Auto("b", "b", "b");
		
		autoService.persist(auto);
		
		 resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
	        try {
	            Gson gson = new Gson();

	            PrintWriter out = resp.getWriter();
	            resp.setContentType("application/json");
	            resp.setCharacterEncoding("utf-8");
	            resp.setStatus(HttpStatus.OK.value());
	            out.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	
}

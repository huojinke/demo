package com.zhiyou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.User;

public class LoginInterCeptor implements HandlerInterceptor{
	
	/**
	 * 在执行controller方法之前执行，如果返回true代表放行，返回false不放行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user=(User) request.getSession().getAttribute("USER");
		if(user==null){//代表用户没登录
			response.sendRedirect("index.jsp");//重定向登录页面
			return false;
		}		
		return true;//代表登录了
	}
	//controller代码执行完，但是还没有返回视图的时候
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("controller代码执行完，但是还没有返回视图的时候");
	}
	//结合视图之后调用
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("结合视图之后调用");
	}

}

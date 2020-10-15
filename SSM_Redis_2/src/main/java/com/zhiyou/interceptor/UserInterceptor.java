package com.zhiyou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.User;

public class UserInterceptor implements HandlerInterceptor{
	//��ִ��controller����֮ǰִ�У��������true���������У����Ϊfalse�Ͳ�����
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user=(User) request.getSession().getAttribute("USER");
		if(user==null){//����δ��¼
			response.sendRedirect("index.jsp");
			return false;
		}
		return true;
	}
	//controller֮��ִ�е�δ������ͼ
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//controller֮��ִ���ҷ�����ͼ��
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

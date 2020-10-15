package com.zhiyou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FileInterCeptor implements HandlerInterceptor{
	//拦截文件，不符合格式的图片
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截非图片文件以及超范围图片");
		MultipartFile file=(MultipartFile) request.getSession().getAttribute("FILE");
		String name=null;
		//判断上传文件是否为空
		if(file.isEmpty()){
			System.out.println("未上传文件");
			return false;
		}else{
			//如果不为空窃取文件名的后缀
			int a=file.getOriginalFilename().indexOf(".");
			int b=file.getOriginalFilename().length();
			 name=file.getOriginalFilename().substring(a,b);
		}
		//判断文件是否为.jsp或者.png
		if(!(name.equals(".jpg")||name.equals(".png"))){
			System.out.println("文件类型不是图片");
			return false;
		}
		//判断文件是否超过范围
		else if(file.getSize()>100){
			System.out.println("图片内存超出范围");
			return false;
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

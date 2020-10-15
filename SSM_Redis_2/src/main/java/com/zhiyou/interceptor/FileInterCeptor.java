package com.zhiyou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FileInterCeptor implements HandlerInterceptor{
	//�����ļ��������ϸ�ʽ��ͼƬ
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("���ط�ͼƬ�ļ��Լ�����ΧͼƬ");
		MultipartFile file=(MultipartFile) request.getSession().getAttribute("FILE");
		String name=null;
		//�ж��ϴ��ļ��Ƿ�Ϊ��
		if(file.isEmpty()){
			System.out.println("δ�ϴ��ļ�");
			return false;
		}else{
			//�����Ϊ����ȡ�ļ����ĺ�׺
			int a=file.getOriginalFilename().indexOf(".");
			int b=file.getOriginalFilename().length();
			 name=file.getOriginalFilename().substring(a,b);
		}
		//�ж��ļ��Ƿ�Ϊ.jsp����.png
		if(!(name.equals(".jpg")||name.equals(".png"))){
			System.out.println("�ļ����Ͳ���ͼƬ");
			return false;
		}
		//�ж��ļ��Ƿ񳬹���Χ
		else if(file.getSize()>100){
			System.out.println("ͼƬ�ڴ泬����Χ");
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

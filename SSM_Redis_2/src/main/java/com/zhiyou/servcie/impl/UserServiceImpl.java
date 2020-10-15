package com.zhiyou.servcie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;
	@CacheEvict(value="userSelect",allEntries=true)
	public void add(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}
	@CacheEvict(value="userSelect",allEntries=true)
	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}
	//���������Ҫ�������ķ������Լ�ָ����Ҫ����Ļ���  allEntries:�����Ƿ���������е�����Ԫ��
	@CacheEvict(value="userSelect",allEntries=true)
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	//ָ�����淽����ʹ�û��棬������userSelect
	@Cacheable(value="userSelect")
	public List<User> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}
	@Cacheable(value="userSelect")
	public User selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}
//
//	public User SelectByName(String name, String password) {
//		// TODO Auto-generated method stub
//		return dao.SelectByName(name, password);
//	}

}

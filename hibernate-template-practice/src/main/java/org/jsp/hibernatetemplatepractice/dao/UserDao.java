package org.jsp.hibernatetemplatepractice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jsp.hibernatetemplatepractice.dto.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {
	
	private HibernateTemplate hibernatetemplate;


	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}
	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}
	@Transactional
	public User saveuser(User user) {
		hibernatetemplate.save(user);
		return user;
	}
	@Transactional
	public User updateUser(User user) {
		User dbuser=hibernatetemplate.get(User.class, user.getId());
		
		if(dbuser!=null) {
			dbuser.setName(user.getName());
			dbuser.setPhone(user.getPhone());
			dbuser.setEmail(user.getEmail());
			dbuser.setPassword(user.getPassword());
			
			return user;
		}
		return null;
	}
	
	public User findUserById(int id){
		return hibernatetemplate.get(User.class,id);
	}
	
	
	@Transactional
	public boolean delete(int id) {
		User user=findUserById(id);
		
		if(user!=null) {
			hibernatetemplate.delete(user);
			return true;
		}
		return false;
	}
	@SuppressWarnings(value = { "deprecation", "unchecked" })
	public User verifyByPhonePass(double phone, String pass) {
		// TODO Auto-generated method stub
//		return null;

		List<User>user=(List<User>) hibernatetemplate.find("select u from User u where u.phone=?0 and u.password=?1",phone,pass);
				if(user.isEmpty()) {
					return null;
				}
				return user.get(0);
		
	}
}

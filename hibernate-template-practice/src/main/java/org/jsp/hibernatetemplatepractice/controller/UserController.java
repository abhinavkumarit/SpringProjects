package org.jsp.hibernatetemplatepractice.controller;

import java.util.Scanner;

import org.jsp.hibernatetemplatepractice.dao.UserDao;
import org.jsp.hibernatetemplatepractice.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-orm.xml");
		UserDao userDao=context.getBean("userDao",UserDao.class);
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Find User By Id");
		System.out.println("4.Delete User By Id");
		System.out.println("5.Verify By phone and password");
		
		System.out.println("Enter your choice:");
		
		int choice=sc.nextInt();
		
		
		switch(choice) {
		case 1:{
			User user=new User();
			System.out.println("Enter User name:");
			user.setName(sc.next());
			System.out.println("Enter User phone:");
			user.setPhone(sc.nextLong());
			System.out.println("Enter User Email:");
			user.setEmail(sc.next());
			System.out.println("Enter User password:");
			user.setPassword(sc.next());
			userDao.saveuser(user);
			System.out.println("User data save with id: "+user.getId());
			
		}
		break;
		
		case 2:
		{
			User user=new User();
			System.out.println("Enter User id:");
			user.setId(sc.nextInt());
			System.out.println("Enter User name:");
			user.setName(sc.next());
			System.out.println("Enter User phone:");
			user.setPhone(sc.nextLong());
			System.out.println("Enter User Email:");
			user.setEmail(sc.next());
			System.out.println("Enter User password:");
			user.setPassword(sc.next());
			userDao.updateUser(user);
			System.out.println("User data update with id: "+user.getId());
		}
		break;
		
		case 3:{
			System.out.println("Enter the User Id to print details");
			User user = userDao.findUserById(sc.nextInt());
			if (user != null)
				System.out.println(user);
			else
				System.err.println("You have entered an Invalid User id");
		
		}
		break;
		case 4:{
			System.out.println("Enter the UserId to delete the userDetails:");
			boolean res=userDao.delete(sc.nextInt());
			if(res==true) {
				System.out.println("User Details been deleted!");
			}
			else {
				System.out.println("Unable to find with userId!");
			}
		}
		break;
		case 5:{
			System.out.println("Verify user by phone_no and password:");
			User user=userDao.verifyByPhonePass(sc.nextDouble(),sc.next());
			if(user!=null) {
				System.out.println(user);
			}
			else {
				System.out.println("Invalid!");
			}
		}
		break;
		default:
			break;
		
		}
		
		
	}
}

package org.jsp.hibernatetemplatepractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

//import org.apache.commons.dbcp.BasicDataSource;

public class testcfg {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-orm.xml");
		HibernateTemplate template=context.getBean("hibernateTemplate",HibernateTemplate.class);
		System.out.println(template);
	}
	
}

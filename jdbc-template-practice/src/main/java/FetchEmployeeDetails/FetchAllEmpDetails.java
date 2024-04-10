package FetchEmployeeDetails;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class FetchAllEmpDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String qry="select * from employee";
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		
				

	}

}

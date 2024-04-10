package SaveEmployee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployeeDetails {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		int i=template.update("insert into employee values(1,'abhinav','12000','Analyst')");
		System.out.println("row "+i+" inserted");
		((AbstractApplicationContext) context).close();
	}
}

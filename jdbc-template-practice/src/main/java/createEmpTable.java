import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
public class createEmpTable {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		template.execute("create table employee (id int not null,name varchar(45) not null,salary decimal not null,designation varchar(45) not null, primary key(id)) ");
		System.out.println("table created");
		((AbstractApplicationContext) context).close();
	}
}

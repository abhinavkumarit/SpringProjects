package SaveEmployeDetailsDynamic;

//import java.io.Closeable;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployeeDetails {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp_id:");
		int id=sc.nextInt();
		System.out.println("Enter emp_Name:");
		String name=sc.next();
		System.out.println("Enter emp_salary:");
		double sal=sc.nextDouble();
		System.out.println("Enter emp_designation:");
		String designation=sc.next();
		String qry="insert into employee values(?,?,?,?)";
		
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		int i=template.update(qry,id,name,sal,designation);
		System.out.println("row "+i+" inserted");
		((AbstractApplicationContext) context).close();
		
	}
}

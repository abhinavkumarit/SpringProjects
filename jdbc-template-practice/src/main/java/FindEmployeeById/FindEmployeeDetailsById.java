package FindEmployeeById;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FindEmployeeDetailsById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		Scanner sc=new Scanner(System.in);
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		System.out.println("Enter empid:");
		int id=sc.nextInt();
		String dql="select * from employee where id=?";
		ResultSetExtractor<String> rse = rs -> {
			if (rs.next()) {
				System.out.println("Employee Id:" + rs.getInt(1));
				System.out.println("Employee Name:" + rs.getString(2));
				System.out.println("Salary:" + rs.getDouble(3));
				System.out.println("Designation:" + rs.getString(4));
				return "Employee Found";
			} else
				return "Invalid Employee Id";
		};
		@SuppressWarnings("deprecation")
		String message = template.query(dql, new Object[] { id }, rse);
		System.out.println(message);
		((ClassPathXmlApplicationContext) context).close();
		sc.close();
	}
	

}

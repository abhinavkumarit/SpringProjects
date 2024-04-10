package UpdateUserDetailsById;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateUserById {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String qry="update employee";
		Scanner sc=new Scanner(System.in);
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		
		String qry="update employee set  name=?,salary=?,designation=? where id=?";
		
		System.out.println("Enter emp_id: ");
		int id=sc.nextInt();
		System.out.println("Enter emp_name: ");
		String name=sc.next();
		System.out.println("Enter emp_sal: ");
		double salary=sc.nextDouble();
		System.out.println("Enter emp_desig: ");
		String designation=sc.next();
		
		int n=template.update(qry,name,salary,designation,id);
		if(n>0) {
			System.out.println("Emp with id "+id+" updated!");
		}
		else {
			System.out.println("Invalid id!");
		}
	

	}
}

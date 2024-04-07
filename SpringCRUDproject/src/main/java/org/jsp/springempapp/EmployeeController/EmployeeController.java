package org.jsp.springempapp.EmployeeController;

import java.util.List;
import java.util.Scanner;

import org.jsp.springempapp.EmployeeConfig;
import org.jsp.springempapp.EmployeeDao.EmployeeDao;
import org.jsp.springempapp.EmployeeDto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeDao employeeDao=context.getBean(EmployeeDao.class);
		Employee emp=new Employee();

		System.out.println("1. Save Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Find Employee By Id");
		System.out.println("4. Delete Employee By Id");
		System.out.println("5. Verify Employee by phone and name");
		System.out.println("6. Verify Employee by email and name");
		System.out.println("7. Verify Employee by Id and name");
		System.out.println("8. Find Employee by salary");
		System.out.println("9. Find Employee by Designation");
		System.out.println("10. Find Employee by name");
		System.out.println("11.Find Employee between a salary range");
		
		System.out.println("Enter your choice:");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1: {
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter phone number:");
			long phone=sc.nextLong();
			System.out.println("Enter email:");
			String email=sc.next();
			System.out.println("Enter designation");
			String disg=sc.next();
			System.out.println("Enter sal:");
			double sal=sc.nextDouble();
			emp.setName(name);
			emp.setPhone(phone);
			emp.setEmail(email);
			emp.setDisg(disg);
			emp.setSalary(sal);
			
			emp=employeeDao.saveEmp(emp);
			System.out.println("Empoye with id "+emp.getId()+ " has been inserted");
			break;
		}
		case 2:{
			System.out.println("Enter emp_id, name, phone number, email, disg, sal to update emp:");
			emp.setId(sc.nextInt());
			emp.setName(sc.next());
			emp.setPhone(sc.nextLong());
			emp.setEmail(sc.next());
			emp.setDisg(sc.next());
			emp.setSalary(sc.nextDouble());
			emp=employeeDao.updateEmployee(emp);
			if(emp!=null) {
				System.out.println("Emp Record is updated !");
			}
			else {
				System.out.println("Failed to update!");
		
			}
			break;
		}
		case 3:{
			System.out.println("Enter id to find details of Employee:");
			int id=sc.nextInt();
			emp=employeeDao.FindDetailsOfEmp(id);
			if(emp!=null) {
				System.out.println(emp.toString());
			}
			else {
				System.out.println("Not found!");
			}
			break;
		}
		case 4:{
			System.out.println("Enter id to delete the record: ");
			int id=sc.nextInt();
			employeeDao.DeleteEmpRecordById(id);
			break;
		}
		
		case 5:{
			System.out.println("Enter phone number:");
			long phone=sc.nextLong();
			System.out.println("Enter name:");
			String name=sc.next();
			emp=employeeDao.verifyEmployee(phone,name);
			if(emp!=null) {
//				emp.toString();
				System.out.println(emp.toString());
			}
			else {
				System.out.println("Failed to find");
			}
		
			break;
		}
		case 6:{
			System.out.println("Enter email:");
			String email=sc.next();
			System.out.println("Enter name:");
			String name=sc.next();
			emp=employeeDao.verifyEmployee(email, name);
			if(emp!=null) {
				System.out.println(emp.toString());
			}
			else {
				System.out.println("Not Found!");
			}
			break;
		}
		case 7:
		{
			System.out.println("Enter id of Employee:");
			int id=sc.nextInt();
			System.out.println("Enter name of Employee:");
			String name=sc.next();
			emp=employeeDao.verifyEmployee(id, name);
			if(emp!=null) {
				System.out.println(emp.toString());
			}
			else {
				System.out.println("Invalid Entry!");
			}
			break;
		}
		case 8:{
			System.out.println("Enter salary of Employee");
			double salary=sc.nextDouble();
			List<Employee>list=employeeDao.findEmployeeBySalary(salary);
			if(list.isEmpty()) {
				System.out.println("Not Found!");
			}
			else {
				System.out.println("Emp with details");
				for(Employee emp2: list) {
					System.out.println(emp2);
				}
			}
			break;
		}
		case 9:
		{
			System.out.println("Enter designation of Employee:");
			String designation=sc.next();
			List<Employee>list=employeeDao.findEmployeeByDesignation(designation);
			if(list.isEmpty()) {
				System.out.println("Not Found!");
			}
			else {
				System.out.println("Emp details:");
				for(Employee emp2: list) {
					System.out.println(emp2);
				}
			}
			break;
		}
		case 10:{
			System.out.println("Enter name of Employee:");
			String name=sc.next();
			List<Employee>list=employeeDao.findEmployeeByName(name);
			if(list.isEmpty()) {
				System.out.println("Not Found!");
			}
			else {
				System.out.println("Emp details:");
				for(Employee emp2: list) {
					System.out.println(emp2);
				}
			}
			break;
		}
		case 11:{
			System.out.println("Enter the minimum and maximum salary to find Employees");
			double min_salary = sc.nextDouble();
			double max_salary = sc.nextDouble();
			List<Employee>list=employeeDao.findEmployeeBySalaryRange(min_salary,max_salary);
			if(list.isEmpty()) {
				System.out.println("Not Found!");
			}
			else {
				System.out.println("Emp details!");
				for(Employee emp2: list) {
					System.out.println(emp2);
				}
			}
			break;
		}
		default: {
			System.err.println("Invalid Choice");
			sc.close();
			((AnnotationConfigApplicationContext) context).close();
		}
			
		}
		
		
	}

}

package org.jsp.springempapp.EmployeeDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.jsp.springempapp.EmployeeDto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;

@Repository
@SuppressWarnings(value = { "unchecked" })
public class EmployeeDao {
	@Autowired
	private EntityManager manager;
	
	public Employee saveEmp(Employee emp) {
		EntityTransaction transaction=manager.getTransaction();
		
		manager.persist(emp);
		transaction.begin();
		transaction.commit();
		return emp;
	}

//	public Employee UpdateRecord(Employee emp) {
//		// TODO Auto-generated method stub
////		return null;
//		EntityTransaction transaction=manager.getTransaction();
//		Employee findemp=manager.find(Employee.class, emp.getId());
//		if(findemp!=null) {
//			transaction.begin();
//			manager.persist(emp);
//			transaction.commit();
//			return emp;
//		}
//		else {
//			return null;
//		}
//		
//	}
	


	public Employee updateEmployee(Employee emp) {
	EntityTransaction entityTransaction = manager.getTransaction();
	Employee dbEmployee = manager.find(Employee.class, emp.getId());
	entityTransaction.begin();
	if (dbEmployee != null) {
		dbEmployee.setDisg(emp.getDisg());
		dbEmployee.setEmail(emp.getEmail());
		dbEmployee.setName(emp.getName());
//		dbEmployee.setPassword(employee.getPassword());
		dbEmployee.setPhone(emp.getPhone());
		dbEmployee.setSalary(emp.getSalary());
		entityTransaction.commit();
		return dbEmployee;
	}
	return null;
	
	}

	public Employee FindDetailsOfEmp(int id) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		Employee emp=manager.find(Employee.class, id);
		if(emp!=null) {
			return emp;
		}
		else {
			return null;
		}
	}

	public void DeleteEmpRecordById(int id) {
		EntityTransaction transaction=manager.getTransaction();
		Employee emp=manager.find(Employee.class, id);
		if(emp!=null) {
			transaction.begin();
			manager.remove(emp);
			transaction.commit();
			System.out.println("Employee with id "+id+" deleted");
		}
		else {
			System.out.println("Unable to find!");
		}
	}

	public Employee verifyEmployee(long phone, String name) {
		Query q=manager.createQuery("select e from Employee e where e.name=?1 and e.phone=?2");
		q.setParameter(1, name);
		q.setParameter(2, phone);
		try {
			return (Employee) q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}

	public Employee verifyEmployee(String email, String name) {
		// TODO Auto-generated method stub
		Query q=manager.createQuery("select e from Employee e where e.email=?1 and e.name=?2");
		q.setParameter(1, email);
		q.setParameter(2, name);
		
		try {
			return (Employee)q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	public Employee verifyEmployee(int id, String name) {
		Query q=manager.createQuery("select e from Employee e where e.id=?1 and e.name=?2");
		q.setParameter(1, id);
		q.setParameter(2, name);
		try {
			return (Employee)q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}

	public List<Employee> findEmployeeBySalary(double salary) {
		// TODO Auto-generated method stub
//		return null;
		Query q=manager.createQuery("select e from Employee e where e.salary=?1");
		q.setParameter(1, salary);
		return q.getResultList();
		
	}

	public List<Employee> findEmployeeByDesignation(String designation) {
		// TODO Auto-generated method stub
		Query q=manager.createQuery("select e from Employee e where e.disg=?1");
		q.setParameter(1, designation);
		return q.getResultList();
		
	}

	public List<Employee> findEmployeeByName(String name) {
		
		Query q=manager.createQuery("select e from Employee e where e.name=?1");
		q.setParameter(1, name);
		return q.getResultList();
		
	}

	public List<Employee> findEmployeeBySalaryRange(double min_sal, double max_sal) {
		// TODO Auto-generated method stub
//		return null;
		Query q=manager.createQuery("select e from Employee e where e.salary between ?1 and ?2");
		q.setParameter(1, min_sal);
		q.setParameter(2, max_sal);
		return q.getResultList();
	}
}

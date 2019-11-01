package springmvc.mongo.model;

import java.util.List;

import com.mongodb.DBObject;

public interface EmployeeI {
	
	public boolean add(Employee employee);
	public boolean edit(Employee employee);
	public boolean delete(String id);
	public Employee findEmployeeById(String id);
	public List getAllEmployee();
	DBObject getDBObject(String emp_id);

}

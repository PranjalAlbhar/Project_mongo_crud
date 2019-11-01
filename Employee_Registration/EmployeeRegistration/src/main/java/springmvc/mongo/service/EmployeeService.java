package springmvc.mongo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import springmvc.mongo.controller.EmployeeController;
import springmvc.mongo.model.Employee;
import springmvc.mongo.model.EmployeeI;
import springmvc.mongo.model.MongoConnection;


@Service("employeeService")
@Transactional
public class EmployeeService implements EmployeeI {

	private static Logger logger = Logger.getLogger(EmployeeService.class);
    static String db_name = "pranjaldb", db_collection = "EmployeeCollection";
	@Override
	public boolean add(Employee employee) {
		 boolean output = false;
	        Random ran = new Random();
	        logger.debug("Adding a new user to the mongo database; Entered Employee is= " + employee.getEmp_name());
	        try {           
	            DBCollection collection =MongoConnection.getCollection(db_name, db_collection);
	 
	         
	            // Create a new object and add the new user details to this object.
	            BasicDBObject document = new BasicDBObject();
	            document.put("emp_id", String.valueOf(ran.nextInt(100))); 
	            document.put("emp_name",employee.getEmp_name());            
	            document.put("emp_address", employee.getEmp_address());
	            document.put("emp_mobile_Number",employee.getEmp_mobile_Number());
	            document.put("emp_email",employee.getEmp_email());
	            document.put("emp_dob",employee.getEmp_dob());
	            document.put("emp_gender",employee.getEmp_gender());
	            document.put("emp_joining_Date",employee.getEmp_joining_Date());
	            document.put("emp_department",employee.getEmp_department());
	            document.put("emp_salary",employee.getEmp_salary());
	            
	            
	            // Save a new user to the mongo collection.
	            collection.insert(document);
	            output = true;
	        } catch (Exception e) {
	            output = false;
	            logger.error("An error occurred while saving a new user to the mongo database", e);            
	        }
	        return output;
		
	}

	@Override
	public boolean edit(Employee employee) {
		// TODO Auto-generated method stub
		
		
		boolean output = false;
        logger.debug("Updating the existing user in the mongo database; Entered user_id is= " + employee.getEmp_id());
        try {
            // Fetching the user details.
            BasicDBObject existing = (BasicDBObject) getDBObject(employee.getEmp_id());
 
            DBCollection collection = MongoConnection.getCollection(db_name, db_collection);
 
            // Create a new object and assign the updated details.
            BasicDBObject edited = new BasicDBObject();
       
            edited.put("emp_id",employee.getEmp_id()); 
            edited.put("emp_name",employee.getEmp_name());            
            edited.put("emp_address", employee.getEmp_address());
            edited.put("emp_mobile_Number",employee.getEmp_mobile_Number());
            edited.put("emp_email",employee.getEmp_email());
            edited.put("emp_dob",employee.getEmp_dob());
            edited.put("emp_gender",employee.getEmp_gender());
            edited.put("emp_joining_Date",employee.getEmp_joining_Date());
            edited.put("emp_department",employee.getEmp_department());
            edited.put("emp_salary",employee.getEmp_salary());
            
            // Update the existing user to the mongo database.
            collection.update(existing, edited);
            output = true;
        } catch (Exception e) {
            output = false;
            logger.error("An error has occurred while updating an existing user to the mongo database", e);            
        }
        return output;
		
	}

	@Override
	public boolean delete(String emp_id) {
		// TODO Auto-generated method stub
		boolean output = false;
        logger.debug("Deleting an existing user from the mongo database; Entered user_id is= " + emp_id);
        try {
            // Fetching the required user from the mongo database.
            BasicDBObject item = (BasicDBObject) getDBObject(emp_id);
 
            DBCollection coll =MongoConnection.getCollection(db_name, db_collection);
 
            // Deleting the selected user from the mongo database.
            coll.remove(item);
            output = true;          
        } catch (Exception e) {
            output = false;
            logger.error("An error occurred while deleting an existing user from the mongo database", e);          
        }   
        return output;
	
	}

	@Override
	public Employee findEmployeeById(String emp_id) {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
        DBCollection collection = MongoConnection.getCollection(db_name, db_collection);
 
        // Fetching the record object from the mongo database.
        DBObject where_query = new BasicDBObject();
        where_query.put("emp_id", emp_id);
		/*
		 * where_query.put("emp_id", employee.getEmp_id());
		 * where_query.put("emp_name",employee.getEmp_name());
		 * where_query.put("emp_address", employee.getEmp_address());
		 * where_query.put("emp_mobile_Number",employee.getEmp_mobile_Number());
		 * where_query.put("emp_email",employee.getEmp_email());
		 * where_query.put("emp_dob",employee.getEmp_dob());
		 * where_query.put("emp_gender",employee.getEmp_gender());
		 * where_query.put("emp_joining_Date",employee.getEmp_joining_Date());
		 * where_query.put("emp_department",employee.getEmp_department());
		 * where_query.put("emp_salary",employee.getEmp_salary());
		 * 
		 * 
		 */
        
        DBObject dbObject = collection.findOne(where_query);       
        employee.setEmp_id(dbObject.get("emp_id").toString());
        employee.setEmp_name(dbObject.get("emp_name").toString());
        employee.setEmp_address(dbObject.get("emp_address").toString());
        employee.setEmp_mobile_Number(dbObject.get("emp_mobile_Number").toString());
        employee.setEmp_email(dbObject.get("emp_email").toString());
        employee.setEmp_dob(dbObject.get("emp_dob").toString());
        employee.setEmp_gender(dbObject.get("emp_gender").toString());
        employee.setEmp_joining_Date(dbObject.get("emp_joining_Date").toString());
        employee.setEmp_department(dbObject.get("emp_department").toString());
        employee.setEmp_salary(dbObject.get("emp_salary").toString());
        
        // Return user object.
        return employee;
	
	}

	
	@Override
	public List getAllEmployee() {
		 List employee_list = new ArrayList();
	        DBCollection collection = MongoConnection.getCollection(db_name, db_collection);
	 
	        // Fetching cursor object for iterating on the database records.
	        DBCursor cursor = collection.find();  
	        while(cursor.hasNext()) {           
	            DBObject dbObject = cursor.next();
	 
	          Employee employee = new Employee();
	       
	          employee.setEmp_id(dbObject.get("emp_id").toString());
	          logger.info("Employee Id"+dbObject.get("emp_id").toString());
	         employee.setEmp_name(dbObject.get("emp_name").toString());
	         logger.info("Employee Name is"+dbObject.get("emp_name").toString());
	          employee.setEmp_address(dbObject.get("emp_address").toString());
	          employee.setEmp_mobile_Number(dbObject.get("emp_mobile_Number").toString());
	          employee.setEmp_email(dbObject.get("emp_email").toString());
	          employee.setEmp_dob(dbObject.get("emp_dob").toString());
	          employee.setEmp_gender(dbObject.get("emp_gender").toString());
	          employee.setEmp_joining_Date(dbObject.get("emp_joining_Date").toString());
	          employee.setEmp_department(dbObject.get("emp_department").toString());
	          employee.setEmp_salary(dbObject.get("emp_salary").toString());
	          
	            // Adding the user details to the list.
	            employee_list.add(employee);
	        }
	        logger.info("Total records fetched from the mongo database are= " + employee_list.size());
	        return employee_list;
		
	}

	

	@Override
	public DBObject getDBObject(String emp_id) {
		  DBCollection coll = MongoConnection.getCollection(db_name, db_collection);
			 
	        // Fetching the record object from the mongo database.
	        DBObject where_query = new BasicDBObject();
	 
	        // Put the selected user_id to search.
	        where_query.put("emp_id", emp_id);
	  
	        return coll.findOne(where_query);
		
	}
	

}

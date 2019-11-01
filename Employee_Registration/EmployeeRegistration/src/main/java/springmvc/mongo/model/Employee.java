package springmvc.mongo.model;

public class Employee {

	String emp_id;
	String emp_name;
	String emp_address;
	String emp_mobile_Number;
	String emp_email;
	String emp_dob;
	String emp_gender;
	String emp_joining_Date;
	String emp_department;
	String emp_salary;

	public Employee() {
		super();
	}

	public Employee(String emp_id, String emp_name, String emp_address, String emp_mobile_Number, String emp_email,
			String emp_dob, String emp_gender, String emp_joining_Date, String emp_department, String emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.emp_mobile_Number = emp_mobile_Number;
		this.emp_email = emp_email;
		this.emp_dob = emp_dob;
		this.emp_gender = emp_gender;
		this.emp_joining_Date = emp_joining_Date;
		this.emp_department = emp_department;
		this.emp_salary = emp_salary;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_mobile_Number() {
		return emp_mobile_Number;
	}

	public void setEmp_mobile_Number(String emp_mobile_Number) {
		this.emp_mobile_Number = emp_mobile_Number;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_dob() {
		return emp_dob;
	}

	public void setEmp_dob(String emp_dob) {
		this.emp_dob = emp_dob;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public String getEmp_joining_Date() {
		return emp_joining_Date;
	}

	public void setEmp_joining_Date(String emp_joining_Date) {
		this.emp_joining_Date = emp_joining_Date;
	}

	public String getEmp_department() {
		return emp_department;
	}

	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}

	public String getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(String emp_salary) {
		this.emp_salary = emp_salary;
	}

}

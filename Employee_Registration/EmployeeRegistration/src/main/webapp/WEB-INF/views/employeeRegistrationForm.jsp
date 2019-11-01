<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3 id="form_header" class="text-warning" align="center">User
			Form</h3>
		<div></div>

	
		<!-- User input form to add a new user or update the existing user-->
		<c:url var="saveUrl" value="/employee/save" />
		<form:form id="user_form" modelAttribute="empAttr" method="POST"
			action="${saveUrl}">
			<form:hidden path="emp_id" />
			<label for="user_name">Enter Name: </label>
			<form:input id="user_name" cssClass="form-control" path="emp_name" />

			<label for="user_name">Enter Address: </label>
			<form:textarea id="user_name" cssClass="form-control" path="emp_address" />

			<label for="user_name">Enter Mobile Number: </label>
			<form:input id="user_name" cssClass="form-control"
				path="emp_mobile_Number" />

			<label for="user_name">Enter EmailId: </label>
			<form:input id="user_name" cssClass="form-control" path="emp_email" />

		
			<label for="user_birthDate">Select Data of Birth </label>
			<form:input type="date" id="user_birthDate" cssClass="form-control"
				path="emp_dob" />
			<br>

<label for="user_name">Select Gender </label>
			<form:radiobutton id="user_name" cssClass="form-control"
				path="emp_gender" value="male"/>Male
			<form:radiobutton id="user_name" cssClass="form-control"
				path="emp_gender" value="female" />female<br>

			<label for="user_joiningDate">Select joining Date: </label>
			<form:input type="date" id="user_joiningDate" cssClass="form-control"
				path="emp_joining_Date" />

			<label for="user_name">Select Department: </label>
			<form:select id="user_name" cssClass="form-control" path="emp_department">
				<form:option value="department" label="department">Select</form:option>
				<form:option value="HR" label="HR">HR</form:option>
				<form:option value="Developer" label="Developer">Developer</form:option>
				<form:option value="Testing" label="Testing">Testing</form:option>
				<form:option value="Finance" label="Finance">Finance</form:option>
				<form:option value="Others" label="Others">Others</form:option>

			</form:select>

			<label for="user_name">Enter Salary: </label>
			<form:input id="user_name" cssClass="form-control" path="emp_salary" />



			<div></div>

			<button id="saveBtn" type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>
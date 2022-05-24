import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.Part;

public class empDTO {
	private int employee_id;
	private String emp_name;
//	private int manager_id;
//	private int department_id;
	private String manager_name;
	private String department_name;
	
	public empDTO() {
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

//	public int getManager_id() {
//		return manager_id;
//	}
//
//	public void setManager_id(int manager_id) {
//		this.manager_id = manager_id;
//	}
//
//	public int getDepartment_id() {
//		return department_id;
//	}
//
//	public void setDepartment_id(int department_id) {
//		this.department_id = department_id;
//	}
	
	
}

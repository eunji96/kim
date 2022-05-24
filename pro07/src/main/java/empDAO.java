import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class empDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<empDTO> listEmp() {
		ArrayList<empDTO>list=new ArrayList<empDTO>();
		try {
			connDB();
			String query="select a.employee_id, a.emp_name, b.emp_name manager_name, c.department_name "+
							"from employees a, employees b, departments c "+
							"where a.manager_id=b.employee_id "+
							" and a.department_id=c.department_id";
			this.stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int employee_id=rs.getInt("employee_id");
				String emp_name=rs.getString("emp_name");
//				int manager_id=rs.getInt("manager_id");
//				int department_id=rs.getInt("department_id");
				String m_name=rs.getString("manager_name");
				String d_name=rs.getString("department_name");
				empDTO em=new empDTO();
				em.setEmployee_id(employee_id);
				em.setEmp_name(emp_name);
//				em.setManager_id(manager_id);
//				em.setDepartment_id(department_id);
				em.setManager_name(m_name);
				em.setDepartment_name(d_name);
				list.add(em);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String userid="ora_user";
		String passcode="human123";
		try {
			Class.forName(driver);
			this.conn=DriverManager.getConnection(url,userid,passcode);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
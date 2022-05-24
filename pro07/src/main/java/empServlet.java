

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class empServlet
 */
@WebServlet("/empList")
public class empServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		empDAO dao=new empDAO();
		ArrayList<empDTO> list=dao.listEmp();
		
		out.print("<html><head><title>emp</title></head><body>");
		out.print("<table border=1><tr><th>employee_id</th><th>emp_name</th><th>manager_name</th><th>department_name</th></tr>");
		
		for(int i=0; i<list.size(); i++) {
			empDTO em=list.get(i);
			int e_id=em.getEmployee_id();
			String e_name=em.getEmp_name();
//			int m_id=em.getManager_id();
//			int d_id=em.getDepartment_id();
			String m_name=em.getManager_name();
			String d_name=em.getDepartment_name();
			out.print("<tr><td>"+e_id+"</td><td>"+e_name+"</td><td>"+m_name+"</td><td>"+d_name+"</td></tr>");
		}
		out.print("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

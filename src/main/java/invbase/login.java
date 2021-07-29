package invbase;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
		
		String LoginName = request.getParameter("LoginName");
		String LoginPassword = request.getParameter("LoginPassword");
		
		HttpSession session = request.getSession();
	    String rang = (String) session.getAttribute("rang");
	    if (rang == null) {
	    	if (LoginName.equals("moder")) {
				if (LoginPassword.equals("pass")) {
					writer.print("Success Login");
					session.setAttribute("rang", "moder__pass");
				} else {
					writer.print("Invalid password");
				}
			} else {
				writer.print("Invalid nickname");
			}
	    } else {
	    	if(rang.equals("moder__pass")) {
	    		writer.print("Success Login");
	    	}
	    }
		
	}

}

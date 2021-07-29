package invbase;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createsample
 */
@WebServlet("/createsample")
public class createsample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbService.insertSample(Integer.parseInt(request.getParameter("CreateInputACCENUMB")), 
				request.getParameter("CreateInputCOUNTRY"), 
				request.getParameter("CreateInputACCENAME"), 
				Integer.parseInt(request.getParameter("CreateInputYEAR")), 
				Integer.parseInt(request.getParameter("CreateInputHEIGHT")), 
				Integer.parseInt(request.getParameter("CreateInputDATEM")), Integer.parseInt(request.getParameter("CreateInputDATED")), 
				Integer.parseInt(request.getParameter("CreateInputSTAB1")), 
				Integer.parseInt(request.getParameter("CreateInputSTAB2")), 
				Integer.parseInt(request.getParameter("CreateInputSTAB3")));
	}

}

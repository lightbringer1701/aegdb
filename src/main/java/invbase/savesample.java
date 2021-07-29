package invbase;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/savesample")
public class savesample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbService.saveSample(Integer.parseInt(request.getParameter("SENDID")), 
				Integer.parseInt(request.getParameter("EditInputACCENUMB")), 
				request.getParameter("EditInputCOUNTRY"), 
				request.getParameter("EditInputACCENAME"), 
				Integer.parseInt(request.getParameter("EditInputYEAR")), 
				Integer.parseInt(request.getParameter("EditInputHEIGHT")), 
				Integer.parseInt(request.getParameter("EditInputDATEM")), 
				Integer.parseInt(request.getParameter("EditInputDATED")), 
				Integer.parseInt(request.getParameter("EditInputSTAB1")), 
				Integer.parseInt(request.getParameter("EditInputSTAB2")), 
				Integer.parseInt(request.getParameter("EditInputSTAB3")));
	}

}

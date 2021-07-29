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

@WebServlet(value="/search", loadOnStartup=1)
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		new dbService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    
	    HttpSession session = request.getSession();
	    String rang = (String) session.getAttribute("rang");
	    boolean moderRang = false;
	    if(rang != null) {
	    	if(rang.equals("moder__pass")) {
	    		moderRang = true;
	    	}
	    }
	    	    
	    boolean sortMOVE = true;
	    if (request.getParameter("SearchMove").equals("Descending")) {
	    	sortMOVE = false;
	    } 
	    
	    dbService.writeHTML(writer, 
	    		moderRang,
	    		request.getParameter("SearchType"),
	    		sortMOVE,
	    		request.getParameter("SearchInputACCENUMB"), 
				request.getParameter("SearchInputCOUNTRY"), 
				request.getParameter("SearchInputACCENAME"), 
				request.getParameter("SearchInputYEAR"), 
				request.getParameter("SearchInputHEIGHT"), 
				request.getParameter("SearchInputDATE"),
				request.getParameter("SearchInputSTAB1"), 
				request.getParameter("SearchInputSTAB2"), 
				request.getParameter("SearchInputSTAB3")
			);
	}

}

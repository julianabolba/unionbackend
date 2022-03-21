/*package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfissionalDao;

*
 * Servlet implementation class ProfissionalDelete
 
@WebServlet("/ProDelete")
public class ProfissionalDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfissionalDelete() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ProfissionalId = Integer.parseInt(request.getParameter("profissionalId"));
		ProfissionalDao.delete(profissionalId);
		
		ProfissionalCreateAndFind profissionalCreateAndFind = new ProfissionalCreateAndFind();
		profissionalCreateAndFind.doGet(request, response);
	}

	
}
*/
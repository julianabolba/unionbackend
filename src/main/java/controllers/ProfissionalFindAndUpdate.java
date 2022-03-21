package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfissionalDao;
import model.Profissional;

/**
 * Servlet implementation class ProfissionalFindAndUpdate
 */
@WebServlet("/ProUpdate")
public class ProfissionalFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfissionalFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int profissionalId = Integer.parseInt(request.getParameter("profissionalId"));
		Profissional profissional = ProfissionalDao.findByPk(profissionalId);
		
		request.setAttribute("profissional", profissional);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdatepro.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profissional profissional = new Profissional();
		profissional.setId(Integer.parseInt(request.getParameter("id")));
		
		profissional.setNome(request.getParameter("nome"));
		profissional.setArea(request.getParameter("area"));
		profissional.setCpf(request.getParameter("cpf"));
		profissional.setNascimento(request.getParameter("nascimento"));
		profissional.setEmail(request.getParameter("email"));
		profissional.setTelefone(request.getParameter("telefone"));
		profissional.setAjuda(request.getParameter("ajuda"));
		profissional.setSituacao(request.getParameter("situacao"));
		
		ProfissionalDao.update(profissional);
		ProfissionalCreateAndFind profissionalCreateAndFind = new ProfissionalCreateAndFind();
		profissionalCreateAndFind.doGet(request, response);
		
	}

	
}

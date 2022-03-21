package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfissionalDao;
import model.Profissional;

/**
 * Servlet implementation class ProfissionalCreateAndFind
 */
@WebServlet("/CreateAndFindPro")
public class ProfissionalCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfissionalCreateAndFind() {
       super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Profissional> profissionais= ProfissionalDao.find(pesquisa);
		
		request.setAttribute("profissionais", profissionais);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listapro.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profissional profissional = new Profissional();
		
		profissional.setNome(request.getParameter("nome"));
		profissional.setArea(request.getParameter("area"));
		profissional.setCpf(request.getParameter("cpf"));
		profissional.setNascimento(request.getParameter("nascimento"));
		profissional.setEmail(request.getParameter("email"));
		profissional.setTelefone(request.getParameter("telefone"));
		profissional.setAjuda(request.getParameter("ajuda"));
		//profissional.setSituacao(request.getParameter("situacao"));
		
		
		ProfissionalDao.create(profissional);
		doGet(request, response);
	}

}

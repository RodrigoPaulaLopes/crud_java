package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;


@WebServlet("/Formulario")
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FormularioController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.sendRedirect("formulario.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		if(id != 0) {
			
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String numero = request.getParameter("numero");
			
			Cliente c = new Cliente(id ,nome, email, numero);
			
			ClienteDAO dao = new ClienteDAO();
			
			dao.update(c);
			
			request.setAttribute("msg", "Cliente Alterado com sucesso!");
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}else {
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String numero = request.getParameter("numero");
			
			Cliente c = new Cliente(nome, email, numero);
			
			ClienteDAO dao = new ClienteDAO();
			
			dao.inserir(c);
			
			request.setAttribute("msg", "Cliente inserido com sucesso!");
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}
		
		
	}

}

package kennedy;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/PessoaController" })
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public PessoaController() {
        
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ControladorPessoa CP = new ControladorPessoa();
		String func = request.getParameter("func"); // funcao para distinguir se ira cadastrar ou excluir
		
		if(func.equals("lis")){
			// Pegar a lista
		List<Pessoa> Pessoas = CP.getPessoa();
		
		// Adiciona a lista no request como atributo
		request.setAttribute("pessoa", Pessoas);
		
		// Levar para o JSP
		RequestDispatcher view = request.getRequestDispatcher("Pessoa.jsp");
		view.forward(request, response);
		
		} 	else if(func.equals("exc")){
			String pos = request.getParameter("pos");
			CP.excluir(Integer.parseInt(pos));
			response.getWriter() 
			  .print("<script> window.alert('Excluido com Sucesso'); location.href='PessoaController?func=lis;</script>");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String telefone = request.getParameter("telefone");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		
		Pessoa cliente = new Pessoa();
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		
		ControladorPessoa CP = new ControladorPessoa();
		CP.salvar(cliente);
		response.setContentType("text/html");
		response.getWriter()
		  .print("<script> window.alert('Salvo com Sucesso'); location.href='PessoaController?func=lis;</script>");
		
		//doGet(request, response);
		
		
		
	}

}
